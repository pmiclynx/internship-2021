package com.internship.tvseries;
import com.internship.tvseries.data.model.Result;
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
import com.internship.tvseries.R;

import java.util.ArrayList;
import java.util.List;


public class GenAdapter extends RecyclerView.Adapter<GenAdapter.ViewHolder> {
    private final List<Result> movieResult;
    private final ItemClickListener listener;
    private Context context;
    public interface ItemClickListener{
        void onItemClicked(int id);
    }
    String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w780";

    public GenAdapter(Context context, List<Result> movieResult, ItemClickListener listener) {
        this.context = context;
        this.movieResult = new ArrayList<>(movieResult);
        this.listener=listener;
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
        Result item= movieResult.get(position);
        holder.Bind(item);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(item.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
//        Log.v("CNT", "hellooo" + movieResult.size());
        return movieResult.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final View view;
        TextView movieTitle, movieRate, releaseDate;
        ImageView movieImg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view=itemView;
            movieTitle = itemView.findViewById(R.id.movie_name);
            movieRate = itemView.findViewById(R.id.rate);
            releaseDate = itemView.findViewById(R.id.release_date);
            movieImg = itemView.findViewById(R.id.movie_img);

        }

        public void Bind(Result movie) {
            movieTitle.setText(movie.getName());
            movieRate.setText(String.valueOf(movie.getPopularity()));
            releaseDate.setText(movie.getFirstAirDate());

            //Adding glide to display image
            Glide.with(context)
                    .load(IMAGE_BASE_URL + movie.getPosterPath())
                    //.load("https://cdn.vox-cdn.com/thumbor/AahdPlzwvjRZGh1WjS1ND_Mkub0=/0x0:2040x1360/1200x800/filters:focal(857x517:1183x843)/cdn.vox-cdn.com/uploads/chorus_image/image/68820539/acastro_180427_1777_0001.0.jpg")

                    .into(movieImg);
        }
    }
}