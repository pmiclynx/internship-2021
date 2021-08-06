package com.internship.tvseries.ui.details;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.internship.tvseries.data.api.ApiClient;
import com.internship.tvseries.data.api.TvDetailsApi;
import com.internship.tvseries.data.model.MoviesList;
import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.FavoritesDao;
import com.internship.tvseries.data.repository.FavoritesRepository;
import com.internship.tvseries.data.repository.db.FavoritesDatabase;
import com.internship.tvseries.databinding.ActivityDetailsBinding;
import com.internship.tvseries.ui.favorites.FavoritesFragment;
import com.internship.tvseries.utils.Constants;
import com.internship.tvseries.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
How to start a Details activity:
Intent intent = new Intent(this, DetailsActivity.class);
intent.putExtra("id", tvId);
startActivity(intent);
 */
public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private FindTvListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int id = getIntent().getExtras().getInt("id");
        DetailsViewModelFactory factory = InjectorUtils.getInstance().provideDetailsViewModelFactory(id);
        DetailsViewModel viewModel = new ViewModelProvider(this, factory).get(DetailsViewModel.class);

        viewModel.tvDetails.observe(this, this::bindUI);
    }

    private void bindUI(TvDetailsResponse tv) {
        FavoritesRepository repo = FavoritesRepository.getInstance(FavoritesDatabase.getInstance(getApplicationContext()).favoritesDao());
        Glide.with(getApplicationContext())
                .load(Constants.IMAGE_BASE_URL + tv.getBackdropPath())
                .into(binding.ivBackdrop);
        Glide.with(getApplicationContext())
                .load(Constants.IMAGE_BASE_URL + tv.getPosterPath())
                .into(binding.ivPoster);
        binding.tvTitle.setText(tv.getName());
        binding.tvRating.setText("Rating: " + tv.getVoteAverage());
        binding.tvOverview.setText(tv.getOverview());
        binding.tvSeasons.setText(String.valueOf(tv.getNumberOfSeasons()));
        binding.tvEpisodes.setText(String.valueOf(tv.getNumberOfEpisodes()));
        binding.tvStatus.setText(tv.getStatus());
        binding.tvTagline.setText(tv.getTagline());


        listener = new FindTvListener() {
            @Override
            public void onReceived(boolean found) {
                DetailsActivity.this.runOnUiThread(() -> {
                    if (found) binding.btnAddFavorite.setEnabled(false);
                });
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (repo.findById(tv.getId()) != null)
                    listener.onReceived(true);
            }
        }).start();


        binding.btnAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        repo.insert(tv);
                    }
                }).start();

                binding.btnAddFavorite.setEnabled(false);
            }
        });
    }

    public interface FindTvListener {
        void onReceived(boolean found);
    }
}