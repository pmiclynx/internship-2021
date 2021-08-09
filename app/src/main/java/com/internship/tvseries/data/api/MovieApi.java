package com.internship.tvseries.data.api;
import com.internship.tvseries.data.model.MoviesList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("tv/{category}")
    Call<MoviesList> listOfMovies(
            @Path("category") String category
    );
    //https://api.themoviedb.org/3/movie/550?api_key=f93778744b7ccdc7a4e6b85cbee2d387
}

