package com.haji.suada.tmdbapp.rest;

import com.haji.suada.tmdbapp.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by suadahaji.
 */
public interface ApiInterface {

    /**
     * @Query – specifies the query key name with the value of the annotated parameter.
     */
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<MovieResponse> getUpcominggMovies(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);


    /**
     * @Path – variable substitution for the API endpoint.
     * For example movie id will be swapped for{id} in the URL endpoint.
     *
     * @Body – payload for the POST call
     *
     * @Header – specifies the header with the value of the annotated parameter
     */
    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

}
