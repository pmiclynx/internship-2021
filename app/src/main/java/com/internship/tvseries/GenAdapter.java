package com.internship.tvseries;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class GenAdapter extends RecyclerView.Adapter<GenAdapter.ViewHolder> {
    private final List<Result> movieResult;
    private final ItemClickListener listener;
    private final EndOfListListener endOfListListener;
    private final Context context;
    private int page = 1;
    private boolean endReached = false;

    public interface ItemClickListener {
        void onItemClicked(int id);
    }

    public interface EndOfListListener {
        void onEndReached(int page);
    }

    public GenAdapter(Context context, List<Result> movieResult, ItemClickListener listener, EndOfListListener endOfListListener) {
        this.context = context;
        this.movieResult = new ArrayList<>(movieResult);
        this.listener = listener;
        this.endOfListListener = endOfListListener;
    }


    @NonNull
    @Override
    public GenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.card_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenAdapter.ViewHolder holder, int position) {
        Result item = movieResult.get(position);
        holder.Bind(item);

        if (position == getItemCount() - 1) {
            if (!endReached)
                endOfListListener.onEndReached(++page);
        }
        holder.view.setOnClickListener(v -> listener.onItemClicked(item.getId()));
    }

    @Override
    public int getItemCount() {
        return movieResult.size();
    }

    public void appendList(List<Result> nextPageList) {
        if (nextPageList.isEmpty())
            endReached = true;
        else {
            movieResult.addAll(nextPageList);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View view;
        TextView movieTitle, movieRate, releaseDate;
        ImageView movieImg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            movieTitle = itemView.findViewById(R.id.movie_name);
            movieRate = itemView.findViewById(R.id.rate);
            releaseDate = itemView.findViewById(R.id.release_date);
            movieImg = itemView.findViewById(R.id.movie_img);

        }

        public void Bind(Result movie) {
            movieTitle.setText(movie.getName());
            movieRate.setText(String.valueOf(movie.getVoteAverage()));
            releaseDate.setText(movie.getFirstAirDate());
            Glide.with(context)
                    .load(Constants.IMAGE_BASE_URL + movie.getPosterPath())
                    .into(movieImg);
        }
    }
}