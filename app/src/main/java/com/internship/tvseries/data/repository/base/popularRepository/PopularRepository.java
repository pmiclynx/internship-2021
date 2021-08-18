package com.internship.tvseries.data.repository.base.popularRepository;

import com.internship.tvseries.data.api.MovieApi;
import com.internship.tvseries.data.repository.base.BaseTvRepository;

public abstract class PopularRepository extends BaseTvRepository {

    public PopularRepository(MovieApi api) {
        super(api);
    }

//    private static BasePopularRepository instance = null;
//    private final MovieApi api;
//
//    public BasePopularRepository(MovieApi api) {
//        this.api = api;
//    }
//
//    protected static BasePopularRepository getInstance(MovieApi api) {
//        return null;
//    }
//
//    @Override
//    public void getByCategory(String category, Consumer<List<Result>> consumer) {
//        Call<MoviesList> call = api.listOfMovies(category);
//        call.enqueue(new Callback<MoviesList>() {
//            @Override
//            public void onResponse(@NotNull Call<MoviesList> call, @NotNull Response<MoviesList> response) {
//                if (response.code() == 200) {
//                    MoviesList movies = response.body();
//                    if (movies != null) {
//                        consumer.accept(movies.getResults());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(@NotNull Call<MoviesList> call, @NotNull Throwable t) {
//                consumer.accept(new ArrayList<>());
//            }
//        });
//    }
}
