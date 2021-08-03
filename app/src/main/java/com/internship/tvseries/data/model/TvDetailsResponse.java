package com.internship.tvseries.data.model;

import com.google.gson.annotations.SerializedName;

public class TvDetailsResponse{

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("overview")
	private String overview;

	@SerializedName("number_of_episodes")
	private int numberOfEpisodes;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("name")
	private String name;

	@SerializedName("tagline")
	private String tagline;

	@SerializedName("id")
	private int id;

	@SerializedName("number_of_seasons")
	private int numberOfSeasons;

//	@SerializedName("status")
//	private String status;


	public TvDetailsResponse() {
	}


	public String getBackdropPath() {
		return backdropPath;
	}

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

	public double getVoteAverage(){
		return voteAverage;
	}

	public String getName(){
		return name;
	}

	public String getTagline(){
		return tagline;
	}

	public int getId(){
		return id;
	}

	public int getNumberOfSeasons(){
		return numberOfSeasons;
	}

//	public String getStatus(){
//		return status;
//	}
}