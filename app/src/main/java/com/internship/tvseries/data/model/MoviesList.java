package com.internship.tvseries.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;




public class MoviesList implements Serializable {



    @SerializedName("results")
    public List<Result> results = null;



    private final static long serialVersionUID = 7334358210326409107L;


    public MoviesList() {
    }

    public MoviesList(List<Result> results) {
        super();
        this.results = results;
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




}