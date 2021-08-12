package com.internship.tvseries.ui.favorites;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.databinding.FragmentFavoritesBinding;
import com.internship.tvseries.ui.base.BaseFragment;
import com.internship.tvseries.ui.details.DetailsActivity;
import com.internship.tvseries.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class FavoritesFragment extends BaseFragment<FavoritesViewModel> {

    private FragmentFavoritesBinding binding;

    @NonNull
    @Override
    public FavoritesViewModel createViewModel() {
        FavoritesViewModelFactory favoritesViewModelFactory = InjectorUtils.getInstance().provideFavoritesViewModelFactory(getContext());
        return new ViewModelProvider(this, favoritesViewModelFactory).get(FavoritesViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        return binding.getRoot();
}

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        viewModel.favTvs.observe(getViewLifecycleOwner(), new Observer<List<TvDetailsResponse>>() {
            @Override
            public void onChanged(List<TvDetailsResponse> tvDetailsResponses) {
                binding.recyclerVfavorites.setLayoutManager(new LinearLayoutManager(getContext()));
                FavAdapter adapter = new FavAdapter(getContext(), tvDetailsResponses, new FavAdapter.ItemClickListener() {
                    @Override
                    public void onItemClicked(int id) {
                        Intent intent = new Intent(getContext(), DetailsActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemDelete(TvDetailsResponse tv) {
                        viewModel.delete(tv);
                    }
                });
                binding.recyclerVfavorites.setAdapter(adapter);
            }
            });
    }
}