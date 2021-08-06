package com.internship.tvseries.ui.favorites;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.internship.tvseries.GenAdapter;
import com.internship.tvseries.R;
import com.internship.tvseries.data.model.TvDetailsResponse;
import com.internship.tvseries.data.repository.FavoritesRepository;
import com.internship.tvseries.data.repository.db.FavoritesDatabase;
import com.internship.tvseries.ui.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;


public class FavoritesFragment extends Fragment {

    //public static String BASE_URL = "https://api.themoviedb.org/3/";


    private RecyclerView recyclerView;
    private List<TvDetailsResponse> movieList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        movieList = FavoritesRepository.getInstance(FavoritesDatabase.getInstance(getContext()).favoritesDao()).getAll();

        // retrofit

        recyclerView = view.findViewById(R.id.recycler_vfavorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FavAdapter adapter = new FavAdapter(getContext(), movieList, new FavAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(int id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);


    }


}