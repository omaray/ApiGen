package com.api.pagegen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

public class ApiManager {
	private static ApiManager instance;
	private LinkedList<Api> apiList;
	private HashMap<String, Api> apiMap;
	
	private ApiManager() {
		this.apiList = new LinkedList<Api>();
		this.apiMap = new HashMap<String, Api>();
	}
	
	private void initializeFromFile() {
		Gson gson = new Gson();
		String apisInJson= Util.readFromFile("./resources/apis.json");
		Api[] apis = gson.fromJson(apisInJson, Api[].class);
		
		this.apiList = new LinkedList<Api>(Arrays.asList(apis));
		
		for (Api api : apis) {
			this.apiMap.put(api.getName(), api);
		}
	}
	
	public static ApiManager getInstance() {
		if (instance == null)
		{
			instance = new ApiManager();
			instance.initializeFromFile();
		}
		
		return instance;
	}
	
	public List<Api> getAllApiDefinitions() {
		return this.apiList;
	}
	
	public Api getApiDefinition(String apiName) {
		return this.apiMap.get(apiName);
	}
	
	public void printAllApiDefinitions() {
		List<Api> apis = this.getAllApiDefinitions();
		
		for (Api api : apis) {
			System.out.println();
			System.out.println("Api Name:        " + api.getName());
			System.out.println("Display Name:    " + api.getDisplayName());
			System.out.println("Description:     " + api.getDescription());
			System.out.println("Overview:        " + api.getOverviewUrl());
			System.out.println("Getting Started: " + api.getGettingStartedUrl());
			System.out.println("Api Explorer:    " + api.getApiExplorerUrl());
			System.out.println("Http Reference:  " + api.getHttpReferenceUrl());
		}
	}
}
