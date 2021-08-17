package com.internship.tvseries.ui.Popular;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.internship.tvseries.GenAdapter;
import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.databinding.FragmentPopularBinding;
import com.internship.tvseries.ui.base.BaseFragment;
import com.internship.tvseries.ui.details.DetailsActivity;
import com.internship.tvseries.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class PopularFragment extends BaseFragment<PopularViewModel> {

    private FragmentPopularBinding binding;
    private GenAdapter adapter;

    @NotNull
    @NonNull
    @Override
    public PopularViewModel createViewModel() {
        PopularViewModelFactory factory = InjectorUtils.getInstance().providePopularViewModelFactory();
        return new ViewModelProvider(this, factory).get(PopularViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPopularBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        viewModel.popularTvs.observe(getViewLifecycleOwner(), this::bindUI);
        viewModel.newPopularTvs.observe(getViewLifecycleOwner(), this::nextPage);
    }

    private void bindUI(List<Result> movieResult) {
        binding.recyclerVpopular.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new GenAdapter(getContext(), movieResult, id -> {
            Intent intent = new Intent(getContext(), DetailsActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }, page -> viewModel.nextPage(page));
        binding.recyclerVpopular.setAdapter(adapter);
    }

    private void nextPage(List<Result> newResults) {
        adapter.appendList(newResults);
    }
}