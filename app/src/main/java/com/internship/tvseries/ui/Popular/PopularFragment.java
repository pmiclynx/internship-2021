package com.internship.tvseries.ui.Popular;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.internship.tvseries.GenAdapter;
import com.internship.tvseries.MainActivity;
import com.internship.tvseries.R;
import com.internship.tvseries.data.api.ApiClient;
import com.internship.tvseries.data.api.MovieApi;
import com.internship.tvseries.data.model.MoviesList;

import java.util.ArrayList;
import java.util.List;

import com.internship.tvseries.data.model.Result;
import com.internship.tvseries.databinding.FragmentPopularBinding;
import com.internship.tvseries.ui.base.BaseFragment;
import com.internship.tvseries.ui.details.DetailsActivity;
import com.internship.tvseries.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PopularFragment extends BaseFragment<PopularViewModel> {

    private FragmentPopularBinding binding;

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
    }

    private void bindUI(List<Result> movieResult) {
        binding.recyclerVpopular.setLayoutManager(new LinearLayoutManager(getContext()));
        GenAdapter adapter = new GenAdapter(getContext(), movieResult, id -> {
            Intent intent = new Intent(getContext(), DetailsActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        });
        binding.recyclerVpopular.setAdapter(adapter);
        binding.recyclerVpopular.setHasFixedSize(true);
    }




}