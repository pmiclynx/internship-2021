package com.internship.tvseries.ui.favorites;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.internship.tvseries.R;
import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.favorites.FavoritesRoomRepository;
import com.internship.tvseries.data.repository.db.FavoritesDatabase;
import com.internship.tvseries.ui.base.BaseFragment;
import com.internship.tvseries.ui.details.DetailsActivity;
import com.internship.tvseries.utils.InjectorUtils;

import java.util.ArrayList;
import java.util.List;


public class FavoritesFragment extends BaseFragment<FavoritesViewModel> {

    @NonNull
    @Override
    public FavoritesViewModel createViewModel() {
        FavoritesViewModelFactory favoritesViewModelFactory = InjectorUtils.getInstance().provideFavoritesViewModelFactory(getContext());
        return new ViewModelProvider(this, favoritesViewModelFactory).get(FavoritesViewModel.class);
    }

    //public static String BASE_URL = "https://api.themoviedb.org/3/";


    private RecyclerView recyclerView;
    private List<TvDetailsResponse> movieList = new ArrayList<>();
    private MoviesListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);


        return view;
}

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        viewModel.favTvs.observe(getViewLifecycleOwner(), new Observer<List<TvDetailsResponse>>() {
            @Override
            public void onChanged(List<TvDetailsResponse> tvDetailsResponses) {
                recyclerView = view.findViewById(R.id.recycler_vfavorites);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                FavAdapter adapter = new FavAdapter(getContext(), tvDetailsResponses, new FavAdapter.ItemClickListener() {
                    @Override
                    public void onItemClicked(int id) {
                        Intent intent = new Intent(getContext(), DetailsActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }
                });
                recyclerView.setAdapter(adapter);
            }
            });


    }



    public interface MoviesListener {
        void onReceived(List<TvDetailsResponse> movies);
    }

}