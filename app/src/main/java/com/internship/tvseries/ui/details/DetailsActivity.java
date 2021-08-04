package com.internship.tvseries.ui.details;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.internship.tvseries.data.api.ApiClient;
import com.internship.tvseries.data.api.TvDetailsApi;
import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.databinding.ActivityDetailsBinding;
import com.internship.tvseries.utils.Constants;
import com.internship.tvseries.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int id = getIntent().getExtras().getInt("id");
        DetailsViewModelFactory factory = InjectorUtils.getInstance().provideDetailsViewModelFactory(id);
        DetailsViewModel viewModel = new ViewModelProvider(this, factory).get(DetailsViewModel.class);

        viewModel.tvDetails.observe(this, this::bindUI);
//        initUiTest();
    }

    private void bindUI(TvDetailsResponse tv) {
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
    }

    private void initUiTest() {
        TvDetailsApi tvApi = ApiClient.getTvDetailsApi();
        int id = getIntent().getExtras().getInt("id");
        Call<TvDetailsResponse> responseCall = tvApi.getMovieDetails(id);
        responseCall.enqueue(new Callback<TvDetailsResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvDetailsResponse> call, @NotNull Response<TvDetailsResponse> response) {
                if (response.code() == 200) {
                    TvDetailsResponse tv = response.body();
//                    Log.v("ionel", tv.toString());
                    if (tv != null) {
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
                    }

                } else {
                    Log.v("ionel", response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvDetailsResponse> call, @NotNull Throwable t) {
                Log.v("ionel", t.getMessage());
            }
        });



    }
}