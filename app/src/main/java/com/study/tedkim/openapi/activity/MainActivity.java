package com.study.tedkim.openapi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.study.tedkim.openapi.R;
import com.study.tedkim.openapi.adapter.BoxofficeAdapter;
import com.study.tedkim.openapi.interfaces.KobisAPIService;
import com.study.tedkim.openapi.interfaces.NaverAPIService;
import com.study.tedkim.openapi.model.BoxofficeData;
import com.study.tedkim.openapi.model.MovieData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView mBoxofficeList;
    BoxofficeAdapter mAdapter;

    public static ArrayList<BoxofficeData.BoxOfficeResult.DailyBoxOfficeList> mBoxofficeDataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRecyclerView();
        initBoxofficeData();
    }

    private void initBoxofficeData() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String yesterday = dateFormat.format(calendar.getTime());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.KOBIS_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KobisAPIService service = retrofit.create(KobisAPIService.class);
        Call<BoxofficeData> call = service.getBoxofficeList(getString(R.string.kofic_api_key), yesterday);
        call.enqueue(new Callback<BoxofficeData>() {
            @Override
            public void onResponse(Call<BoxofficeData> call, Response<BoxofficeData> response) {

                if (response.isSuccessful()) {

                    for(BoxofficeData.BoxOfficeResult.DailyBoxOfficeList data : response.body().getBoxOfficeResult().getDailyBoxOfficeList()){
                        mBoxofficeDataset.add(data);
                        downloadImage(data);
                    }

                    mAdapter.notifyDataSetChanged();

                } else {
                    Log.e("FAIL_GET_DATA", "fail to get box office data");
                }
            }

            @Override
            public void onFailure(Call<BoxofficeData> call, Throwable t) {
                t.printStackTrace();
                Log.e("FAIL_ACCESS_DATA", "fail to access box office server");
            }
        });
    }

    private void downloadImage(final BoxofficeData.BoxOfficeResult.DailyBoxOfficeList movie){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.NAVER_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NaverAPIService service = retrofit.create(NaverAPIService.class);
        Call<MovieData> call = service.getMovieDetail(
                getString(R.string.naver_movie_api_id),
                getString(R.string.naver_movie_api_secret),
                movie.getMovieNm(),
                1);

        call.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {

                if(response.isSuccessful()){

                    MovieData data = response.body();
                    movie.setImgUrl(data.getItems()[0].getImage());
                    mAdapter.notifyDataSetChanged();
//                    mAdapter.notifyItemChanged(mBoxofficeDataset.indexOf(data));

                } else {
                    Log.e("FAIL_GET_DATA", "fail to get movie data");
                }
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {
                t.printStackTrace();
                Log.e("FAIL_ACCESS_DATA", "fail to access naver server");
            }
        });

    }

    private void setRecyclerView() {

        mBoxofficeList = (RecyclerView) findViewById(R.id.recyclerView_boxofficeList);
        mAdapter = new BoxofficeAdapter(MainActivity.this, mBoxofficeDataset);
        mBoxofficeList.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mBoxofficeList.setLayoutManager(layoutManager);
    }
}
