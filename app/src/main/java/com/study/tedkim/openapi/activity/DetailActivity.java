package com.study.tedkim.openapi.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.tedkim.openapi.R;
import com.study.tedkim.openapi.adapter.ActorAdapter;
import com.study.tedkim.openapi.interfaces.KobisAPIService;
import com.study.tedkim.openapi.interfaces.NaverAPIService;
import com.study.tedkim.openapi.model.BoxofficeData;
import com.study.tedkim.openapi.model.MovieData;
import com.study.tedkim.openapi.model.MovieDetail;

import java.text.NumberFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.study.tedkim.openapi.activity.MainActivity.mBoxofficeDataset;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    String mMovieTitle, mMovieCode;
    int mPosition;

    TextView mTitle, mRate, mDate, mGenre, mGrade, mRuntime, mTodayAudi, mTotalAudi, mAudiRatio;
    ImageView mPoster, mBackground;
    ImageButton mBack;

    ArrayList<MovieDetail.MovieInfoResult.MovieInfo.Actors> mDataset = new ArrayList<>();

    RecyclerView mActors;
    ActorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        mMovieTitle = intent.getStringExtra("TITLE");
        mMovieCode = intent.getStringExtra("CODE");
        mPosition = intent.getIntExtra("POSITION",0);

        initView();
        setRecyclerView();
        initData();
    }

    private void initView(){

        mTitle = (TextView) findViewById(R.id.textView_title);
        mRate = (TextView) findViewById(R.id.textView_rate);
        mDate = (TextView) findViewById(R.id.textView_openDate);
        mGrade = (TextView) findViewById(R.id.textView_grade);
        mRuntime = (TextView) findViewById(R.id.textView_runtime);
        mTodayAudi = (TextView) findViewById(R.id.textView_todayAudi);
        mTotalAudi = (TextView) findViewById(R.id.textView_totalAudi);
        mAudiRatio = (TextView) findViewById(R.id.textView_audiRatio);

        mGenre = (TextView) findViewById(R.id.textView_genre);

        mPoster = (ImageView) findViewById(R.id.imageView_poster);
        mBackground = (ImageView) findViewById(R.id.imageView_background);

        mBack = (ImageButton) findViewById(R.id.imageButton_back);
        mBack.setOnClickListener(this);

    }

    private void setRecyclerView(){

        mActors = (RecyclerView) findViewById(R.id.recyclerView_actor);
        mAdapter = new ActorAdapter(this, mDataset);
        mActors.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(DetailActivity.this);
        mActors.setLayoutManager(layoutManager);
    }

    private void initData(){

        Retrofit retrofit_naver = new Retrofit.Builder()
                .baseUrl(getString(R.string.NAVER_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NaverAPIService naverAPIService = retrofit_naver.create(NaverAPIService.class);
        Call<MovieData> naverCall = naverAPIService.getMovieDetail(
                getString(R.string.naver_movie_api_id),
                getString(R.string.naver_movie_api_secret),
                mMovieTitle,
                1);

        naverCall.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {

                if(response.isSuccessful()){

                    MovieData.Items data = response.body().getItems()[0];
                    mRate.setText(data.getUserRating());

                    if(data.getImage() != null) {
                        Glide.with(DetailActivity.this).load(data.getImage()).into(mPoster);
                        Glide.with(DetailActivity.this).load(data.getImage()).centerCrop().into(mBackground);
                        mBackground.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);
                    }
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

        Retrofit retrofit_kobis = new Retrofit.Builder()
                .baseUrl(getString(R.string.KOBIS_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KobisAPIService kobisAPIService = retrofit_kobis.create(KobisAPIService.class);
        Call<MovieDetail> kobisCall = kobisAPIService.getMovieDetail(getString(R.string.kofic_api_key), mMovieCode);
        kobisCall.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                if(response.isSuccessful()){

                    MovieDetail data = response.body();

                    mTitle.setText(data.getMovieInfoResult().getMovieInfo().getMovieNm());
                    mDate.setText(data.getMovieInfoResult().getMovieInfo().getOpenDt());
                    mGrade.setText(data.getMovieInfoResult().getMovieInfo().getNations()[0].getNationNm());
                    mRuntime.setText(String.format("%s 분",data.getMovieInfoResult().getMovieInfo().getShowTm()));
                    mGenre.setText(data.getMovieInfoResult().getMovieInfo().getGenres()[0].getGenreNm());

                    for(MovieDetail.MovieInfoResult.MovieInfo.Actors actor : data.getMovieInfoResult().getMovieInfo().getActors()){
                        mDataset.add(actor);
                    }


                } else {
                    Log.e("FAIL_GET_DATA", "fail to get movie data");
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                t.printStackTrace();
                Log.e("FAIL_ACCESS_DATA", "fail to access kobis server");
            }
        });

        BoxofficeData.BoxOfficeResult.DailyBoxOfficeList statistics = mBoxofficeDataset.get(mPosition);
        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        mTodayAudi.setText(numberFormat.format(Long.parseLong(statistics.getAudiCnt())));
        mTotalAudi.setText(numberFormat.format(Long.parseLong(statistics.getAudiAcc())));
        mAudiRatio.setText(statistics.getAudiChange());
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.imageButton_back:

                DetailActivity.this.finish();
                break;

        }
    }
}
