package com.internship.tvseries.ui.favorites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.internship.tvseries.R;
import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.FavoritesRepository;
import com.internship.tvseries.data.repository.db.FavoritesDatabase;

import java.util.ArrayList;
import java.util.List;


public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {
    private final List<TvDetailsResponse> movieResult;
    private final ItemClickListener listener;
    private final Context context;

    public interface ItemClickListener {
        void onItemClicked(int id);
    }

    String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w780";

    public FavAdapter(Context context, List<TvDetailsResponse> movieResult, ItemClickListener listener) {
        this.context = context;
        this.movieResult = new ArrayList<>(movieResult);
        this.listener = listener;
    }


    @NonNull
    @Override
    public FavAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.card_view_fav, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.ViewHolder holder, int position) {
        TvDetailsResponse item = movieResult.get(position);
        holder.Bind(item);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(item.getId());
            }
        });
        holder.delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(item);
            }
        });
    }

    private void deleteItem(TvDetailsResponse item) {
        FavoritesRepository repo = FavoritesRepository.getInstance(FavoritesDatabase.getInstance(context).favoritesDao());

        new Thread(() -> repo.delete(item)).start();
        movieResult.remove(item);
        notifyDataSetChanged();
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
        ImageButton delBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            movieTitle = itemView.findViewById(R.id.movie_name);
            movieRate = itemView.findViewById(R.id.rate);
            releaseDate = itemView.findViewById(R.id.release_date);
            movieImg = itemView.findViewById(R.id.movie_img);
            delBtn = itemView.findViewById(R.id.del_fav);

        }

        public void Bind(TvDetailsResponse movie) {
            movieTitle.setText(movie.getName());
            movieRate.setText(String.valueOf(movie.getVoteAverage()));
            releaseDate.setText(movie.getFirstAirDate());

            //Adding glide to display image
            Glide.with(context)
                    .load(IMAGE_BASE_URL + movie.getPosterPath())
                    //.load("https://cdn.vox-cdn.com/thumbor/AahdPlzwvjRZGh1WjS1ND_Mkub0=/0x0:2040x1360/1200x800/filters:focal(857x517:1183x843)/cdn.vox-cdn.com/uploads/chorus_image/image/68820539/acastro_180427_1777_0001.0.jpg")

                    .into(movieImg);
        }
    }
}