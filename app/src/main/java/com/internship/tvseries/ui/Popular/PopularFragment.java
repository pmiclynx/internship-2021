package com.internship.tvseries.ui.Popular;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
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
import com.internship.tvseries.ui.details.DetailsActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PopularFragment extends Fragment {

    public static String CATEGORY = "popular";


    private RecyclerView recyclerView;
    private List<Result> movieList = new ArrayList<>();
    private MutableLiveData<List<Result>> list = new MutableLiveData<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_popular, container, false);

        Call<MoviesList> call = ApiClient.getMovieApi().listOfMovies(CATEGORY);

        call.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                if (response.code() != 200) {
                    //handle the error and display it
                    return;
                }
                List<Result> movieList = new ArrayList<>();
                MoviesList movies = response.body();
                for (Result movie : movies.getResults()) {
                    movieList.add(movie);
                }

                list.postValue(movieList);

            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
            }
        });

        list.observe(getViewLifecycleOwner(), movieResult -> {
            recyclerView = view.findViewById(R.id.recycler_vpopular);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            GenAdapter adapter = new GenAdapter(getContext(), movieResult, new GenAdapter.ItemClickListener() {
                @Override
                public void onItemClicked(int id) {
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);


        });

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);





    }

    private void PutDataIntoRecyclerView(List<Result> movieList) {
//        movieList.forEach(m -> {
//            Log.v("CNT", m.getName());
//        });
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}