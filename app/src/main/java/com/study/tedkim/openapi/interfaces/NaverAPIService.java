package com.study.tedkim.openapi.interfaces;

import com.study.tedkim.openapi.model.MovieData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by tedkim on 2017. 9. 18..
 */

public interface NaverAPIService {

    @GET("/v1/search/movie.json")
    Call<MovieData> getMovieDetail(@Header("X-Naver-Client-Id") String id,
                                   @Header("X-Naver-Client-Secret") String secret,
                                   @Query("query") String movieTitle,
                                   @Query("display") int display);
}
