package com.internship.tvseries.ui.TopRated;

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
import com.internship.tvseries.databinding.FragmentTopRatedBinding;
import com.internship.tvseries.ui.base.BaseFragment;
import com.internship.tvseries.ui.details.DetailsActivity;
import com.internship.tvseries.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class TopRatedFragment extends BaseFragment<TopRatedViewModel> {

    private FragmentTopRatedBinding binding;

    @NonNull
    @NotNull
    @Override
    public TopRatedViewModel createViewModel()   {
        TopRatedViewModelFactory factory = InjectorUtils.getInstance().provideTopRatedViewModelFactory();
        return new ViewModelProvider(this, factory).get(TopRatedViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTopRatedBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        viewModel.topRatedTvs.observe(getViewLifecycleOwner(), this::bindUI);
    }

    private void bindUI(List<Result> tvList) {
        binding.recyclerVtoprated.setLayoutManager(new LinearLayoutManager(getContext()));
        GenAdapter adapter = new GenAdapter(getContext(), tvList, id -> {
            Intent intent = new Intent(getContext(), DetailsActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        });
        binding.recyclerVtoprated.setAdapter(adapter);
        binding.recyclerVtoprated.setHasFixedSize(true);
    }
}
