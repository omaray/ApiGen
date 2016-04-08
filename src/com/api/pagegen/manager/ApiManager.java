package com.api.pagegen.manager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.api.pagegen.dataloader.ApiDataFileLoader;
import com.api.pagegen.model.Api;

public class ApiManager {
	private static ApiManager instance;
	private LinkedList<Api> apiList;
	private HashMap<String, Api> apiMap;
	
	private ApiManager() {
		this.apiList = new LinkedList<Api>();
		this.apiMap = new HashMap<String, Api>();
	}
	
	@SuppressWarnings("unchecked")
	private void initialize() {
		// Load api data from json file
		ApiDataFileLoader apiLoader = new ApiDataFileLoader();
		this.apiList = (LinkedList<Api>)apiLoader.loadData();
		
		for (Api api : this.apiList) {
			this.apiMap.put(api.getName(), api);
		}
	}
	
	public static ApiManager getInstance() {
		if (instance == null)
		{
			instance = new ApiManager();
			instance.initialize();
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
