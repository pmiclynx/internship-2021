package com.internship.tvseries.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = null;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    private Object posterPath;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    private final static long serialVersionUID = 5022404097950618891L;


    public Result() {
    }

    /**
     *
     * @param overview
     * @param voteAverage
     * @param genreIds
     * @param originalLanguage
     * @param originalName
     * @param firstAirDate
     * @param popularity
     * @param name
     * @param originCountry
     * @param backdropPath
     * @param id
     * @param voteCount
     * @param posterPath
     */
    public Result(String backdropPath, List<Integer> genreIds, Integer id, String name, List<String> originCountry, String originalLanguage, String originalName, String overview, Double popularity, Object posterPath, Double voteAverage, Integer voteCount, String firstAirDate) {
        super();
        this.backdropPath = backdropPath;
        this.genreIds = genreIds;
        this.id = id;
        this.name = name;
        this.originCountry = originCountry;
        this.originalLanguage = originalLanguage;
        this.originalName = originalName;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.firstAirDate = firstAirDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Result withBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Result withGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Result withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Result withName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public Result withOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
        return this;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Result withOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public Result withOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Result withOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Result withPopularity(Double popularity) {
        this.popularity = popularity;
        return this;
    }

    public Object getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(Object posterPath) {
        this.posterPath = posterPath;
    }

    public Result withPosterPath(Object posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Result withVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Result withVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public Result withFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "backdropPath='" + backdropPath + '\'' +
                ", genreIds=" + genreIds +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", originCountry=" + originCountry +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalName='" + originalName + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", posterPath=" + posterPath +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                ", firstAirDate='" + firstAirDate + '\'' +
                '}';
    }
}

