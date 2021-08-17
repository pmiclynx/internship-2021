package com.internship.tvseries.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Images{

	@SerializedName("poster_sizes")
	private List<String> posterSizes;

	@SerializedName("secure_base_url")
	private String secureBaseUrl;

	@SerializedName("backdrop_sizes")
	private List<String> backdropSizes;

	@SerializedName("base_url")
	private String baseUrl;

	@SerializedName("logo_sizes")
	private List<String> logoSizes;

	@SerializedName("still_sizes")
	private List<String> stillSizes;

	@SerializedName("profile_sizes")
	private List<String> profileSizes;

	public List<String> getPosterSizes(){
		return posterSizes;
	}

	public String getSecureBaseUrl(){
		return secureBaseUrl;
	}

	public List<String> getBackdropSizes(){
		return backdropSizes;
	}

	public String getBaseUrl(){
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public List<String> getLogoSizes(){
		return logoSizes;
	}

	public List<String> getStillSizes(){
		return stillSizes;
	}

	public List<String> getProfileSizes(){
		return profileSizes;
	}
}