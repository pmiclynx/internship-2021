package com.internship.tvseries.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TvDetailsResponse{

	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("overview")
	private String overview;

	@SerializedName("number_of_episodes")
	private int numberOfEpisodes;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("genres")
	private List<GenresItem> genres;

	@SerializedName("popularity")
	private double popularity;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("name")
	private String name;

	@SerializedName("tagline")
	private String tagline;

	@SerializedName("episode_run_time")
	private List<Integer> episodeRunTime;

	@SerializedName("id")
	private int id;

	@SerializedName("number_of_seasons")
	private int numberOfSeasons;

	@SerializedName("next_episode_to_air")
	private Object nextEpisodeToAir;

	@SerializedName("in_production")
	private boolean inProduction;

	@SerializedName("status")
	private String status;

	public String getFirstAirDate(){
		return firstAirDate;
	}

	public String getOverview(){
		return overview;
	}

	public int getNumberOfEpisodes(){
		return numberOfEpisodes;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public List<GenresItem> getGenres(){
		return genres;
	}

	public double getPopularity(){
		return popularity;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public String getName(){
		return name;
	}

	public String getTagline(){
		return tagline;
	}

	public List<Integer> getEpisodeRunTime(){
		return episodeRunTime;
	}

	public int getId(){
		return id;
	}

	public int getNumberOfSeasons(){
		return numberOfSeasons;
	}

	public Object getNextEpisodeToAir(){
		return nextEpisodeToAir;
	}

	public boolean isInProduction(){
		return inProduction;
	}

	public String getStatus(){
		return status;
	}
}