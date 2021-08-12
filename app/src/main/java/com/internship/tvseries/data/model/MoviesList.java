package com.internship.tvseries.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;




public class MoviesList implements Serializable {


    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    public List<Result> results = null;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_results")
    private Integer totalResults;

    private final static long serialVersionUID = 7334358210326409107L;


    public MoviesList() {
    }

    public MoviesList(Integer page, List<Result> results, Integer totalPages, Integer totalResults) {
        super();
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public MoviesList withPage(Integer page) {
        this.page = page;
        return this;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public MoviesList withResults(List<Result> results) {
        this.results = results;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public MoviesList withTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public MoviesList withTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }


}