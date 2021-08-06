package com.internship.tvseries.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
@Entity(tableName = "favorites")
public class TvDetailsResponse{

	@SerializedName("backdrop_path")
	private String backdropPath;

	@ColumnInfo(name = "release_date")
	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("overview")
	private String overview;

	@SerializedName("number_of_episodes")
	private int numberOfEpisodes;

	@ColumnInfo(name = "poster")
	@SerializedName("poster_path")
	private String posterPath;

	@ColumnInfo(name = "rating")
	@SerializedName("vote_average")
	private double voteAverage;

	@ColumnInfo(name = "name")
	@SerializedName("name")
	private String name;

	@SerializedName("tagline")
	private String tagline;

	@PrimaryKey
	@ColumnInfo(name = "id")
	@SerializedName("id")
	private int id;

	@SerializedName("number_of_seasons")
	private int numberOfSeasons;

	@SerializedName("status")
	private String status;


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

	public String getStatus(){
		return status;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setNumberOfEpisodes(int numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumberOfSeasons(int numberOfSeasons) {
		this.numberOfSeasons = numberOfSeasons;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}