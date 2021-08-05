package com.internship.tvseries.ui.Popular;
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
import com.internship.tvseries.R;
import com.internship.tvseries.data.api.MovieApi;
import com.internship.tvseries.data.model.MoviesList;

import java.util.ArrayList;
import java.util.List;

import com.internship.tvseries.data.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PopularFragment extends Fragment {

    public static String BASE_URL = "https://api.themoviedb.org/3/";
    public static int PAGE = 1;
    public static String API_KEY = "0a416fc6c49f4a04db6e3bd398ef8579";
    public static String LANGUAGE = "en-US";
    public static String CATEGORY = "popular";


    private RecyclerView recyclerView;
    private List<Result> movieList = new ArrayList<>();
    private MutableLiveData<List<Result>> list = new MutableLiveData<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_popular, container, false);


        // retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApi popularInterface = retrofit.create(MovieApi.class);
        Call<MoviesList> call = popularInterface.listOfMovies(CATEGORY,API_KEY, LANGUAGE, PAGE);// get json data and convert it to gson

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
            GenAdapter adapter = new GenAdapter(getContext(),movieResult);
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