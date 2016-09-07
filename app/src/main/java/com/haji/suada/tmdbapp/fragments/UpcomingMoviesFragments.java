package com.haji.suada.tmdbapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haji.suada.tmdbapp.R;
import com.haji.suada.tmdbapp.adapter.MoviesAdapter;
import com.haji.suada.tmdbapp.helpers.Constants;
import com.haji.suada.tmdbapp.model.Movie;
import com.haji.suada.tmdbapp.model.MovieResponse;
import com.haji.suada.tmdbapp.rest.ApiClient;
import com.haji.suada.tmdbapp.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by suadahaji.
 */
public class UpcomingMoviesFragments extends Fragment {
    public UpcomingMoviesFragments() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upcoming_m_fragment, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiInterface.getUpcominggMovies(Constants.API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();

                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        return view;
    }

}
