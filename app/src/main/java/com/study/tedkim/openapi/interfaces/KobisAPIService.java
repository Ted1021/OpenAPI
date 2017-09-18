package com.study.tedkim.openapi.interfaces;

import com.study.tedkim.openapi.model.BoxofficeData;
import com.study.tedkim.openapi.model.MovieDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tedkim on 2017. 9. 18..
 */

public interface KobisAPIService {

    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    Call<BoxofficeData> getBoxofficeList(@Query("key") String key, @Query("targetDt") String date);

    @GET("/kobisopenapi/webservice/rest/movie/searchMovieInfo.json")
    Call<MovieDetail> getMovieDetail(@Query("key") String key, @Query("movieCd") String movieCd);
}
