package com.haji.suada.tmdbapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haji.suada.tmdbapp.R;
import com.haji.suada.tmdbapp.model.Movie;

import java.util.List;

/**
 * Created by suadahaji.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView thumbnail;
        RatingBar ratingBar;

        public MovieViewHolder(View itemView) {
            super(itemView);
           // moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
            movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
           // ratingBar = (RatingBar) itemView.findViewById(R.id.vote_average);

            /*data = (TextView) itemView.findViewById(R.id.subtitle);
            movieDescription = (TextView) itemView.findViewById(R.id.movie_description);
            rating = (TextView) itemView.findViewById(R.id.rating);*/
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }


    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.MovieViewHolder holder, int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        /*
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());*/
        Glide.with(context).load("http://image.tmdb.org/t/p/original/" + movies.get(position).getBackdropPath()).into(holder.thumbnail);
       // holder.ratingBar.setRating(movies.get(position).getVoteAverage());
       // Float.valueOf(String.valueOf(your_double_variable))
        /*Float vote_count = Float.valueOf(String.valueOf(movies.get(position).getVoteAverage())) ;
        Log.d("Vote", vote_count + " ");*/
        /*holder.ratingBar.setStepSize((float) 2.25);
        holder.ratingBar.setIsIndicator(true);
        holder.ratingBar.setRating(Float.parseFloat(String.valueOf(movies.get(position).getVoteAverage())));*/
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
