package com.internship.tvseries.ui.details;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.internship.tvseries.R;
import com.internship.tvseries.data.api.ApiClient;
import com.internship.tvseries.data.api.TvDetailsApi;
import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.databinding.ActivityDetailsBinding;
import com.internship.tvseries.utils.Constants;

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

        /*
        Button testButton = findViewById(R.id.testButton);

        testButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TvDetailsApi tvApi = ApiClient.getTvDetailsApi();

                Call<TvDetailsResponse> responseCall = tvApi.getMovieDetails(84958);

                responseCall.enqueue(new Callback<TvDetailsResponse>() {
                    @Override
                    public void onResponse(Call<TvDetailsResponse> call, Response<TvDetailsResponse> response) {
                        if (response.code() == 200) {
                            TvDetailsResponse tv = response.body();
                            Log.v("ionel", tv.toString());
                        } else {
                            Log.v("ionel", response.message());

                        }
                    }

                    @Override
                    public void onFailure(Call<TvDetailsResponse> call, Throwable t) {
                        Log.v("ionel", t.getMessage());
                    }
                });
            }
        });*/

        initUi();
    }

    private void initUi() {
        ImageView backdrop = findViewById(R.id.ivBackdrop);
        ImageView poster = findViewById(R.id.ivPoster);
        TextView title = findViewById(R.id.tvTitle);
        TextView rating = findViewById(R.id.tvRating);
        TextView overview = findViewById(R.id.tvOverview);

        TvDetailsApi tvApi = ApiClient.getTvDetailsApi();
        int id = getIntent().getExtras().getInt("id");
        Call<TvDetailsResponse> responseCall = tvApi.getMovieDetails(84958);
        responseCall.enqueue(new Callback<TvDetailsResponse>() {
            @Override
            public void onResponse(Call<TvDetailsResponse> call, Response<TvDetailsResponse> response) {
                if (response.code() == 200) {
                    TvDetailsResponse tv = response.body();
//                    Log.v("ionel", tv.toString());
                    if (tv != null) {
                        Glide.with(backdrop.getContext())
                                .load(Constants.IMAGE_BASE_URL + tv.getBackdropPath())
                                .into(backdrop);
                        Glide.with(backdrop.getContext())
                                .load(Constants.IMAGE_BASE_URL + tv.getPosterPath())
                                .into(poster);
                        title.setText(tv.getName());
                        binding.tvRating.setText("Rating: " + tv.getVoteAverage());
                        overview.setText(tv.getOverview());
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
            public void onFailure(Call<TvDetailsResponse> call, Throwable t) {
                Log.v("ionel", t.getMessage());
            }
        });



    }
}