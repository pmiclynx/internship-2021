package com.internship.tvseries.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Configuration{

	@SerializedName("images")
	private Images images;

	@SerializedName("change_keys")
	private List<String> changeKeys;

	public Images getImages(){
		return images;
	}

	public List<String> getChangeKeys(){
		return changeKeys;
	}
}