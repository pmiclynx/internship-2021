package com.internship.tvseries.ui.details;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.db.FavoritesDatabase;
import com.internship.tvseries.data.repository.favorites.FavoritesRoomRepository;
import com.internship.tvseries.databinding.ActivityDetailsBinding;
import com.internship.tvseries.ui.base.BaseActivity;
import com.internship.tvseries.utils.Constants;
import com.internship.tvseries.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

/*
How to start a Details activity:
Intent intent = new Intent(this, DetailsActivity.class);
intent.putExtra("id", tvId);
startActivity(intent);
 */
public class DetailsActivity extends BaseActivity<DetailsViewModel> {

    private ActivityDetailsBinding binding;

    @NotNull
    @Override
    public DetailsViewModel createViewModel() {
        int id = getIntent().getExtras().getInt("id");
        DetailsViewModelFactory factory = InjectorUtils.getInstance().provideDetailsViewModelFactory(id, getApplicationContext());
        return new ViewModelProvider(this, factory).get(DetailsViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel.favoriteTv.observe(this, tvDetailsResponse -> binding.btnAddFavorite.setEnabled(tvDetailsResponse == null));
        viewModel.tvDetails.observe(this, this::bindUI);


    }

    private void bindUI(TvDetailsResponse tv) {
        FavoritesRoomRepository repo = FavoritesRoomRepository.getInstance(FavoritesDatabase.getInstance(getApplicationContext()).favoritesDao());
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
        if (tv.getNumberOfSeasons() == 0)
            binding.seasonsLayout.setVisibility(View.INVISIBLE);
        if(tv.getNumberOfEpisodes() == 0)
            binding.episodesLayout.setVisibility(View.INVISIBLE);
        binding.tvStatus.setText(tv.getStatus());
        if (tv.getStatus() == null)
            binding.tvStatus.setVisibility(View.INVISIBLE);
        binding.tvTagline.setText(tv.getTagline());

        viewModel.checkIfAlreadyAdded(tv.getId());

        binding.btnAddFavorite.setOnClickListener(view -> {
            viewModel.addFavorite(tv);
            binding.btnAddFavorite.setEnabled(false);
        });
    }
}