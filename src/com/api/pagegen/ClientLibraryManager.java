package com.api.pagegen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import com.google.gson.Gson;

public class ClientLibraryManager {
	private static ClientLibraryManager instance;
	private LinkedList<ClientLibrary> cloudClientLibList;
	private LinkedList<ClientLibrary> apiaryClientLibList;
	private HashMap<String, HashMap<String, ClientLibrary>> cloudClientLibMap;
	private HashMap<String, HashMap<String, ClientLibrary>> apiaryClientLibMap;
	
	
	private ClientLibraryManager() {
		this.cloudClientLibList = new LinkedList<ClientLibrary>();
		this.apiaryClientLibList = new LinkedList<ClientLibrary>();
		this.cloudClientLibMap = new HashMap<String, HashMap<String, ClientLibrary>>();
		this.apiaryClientLibMap = new HashMap<String, HashMap<String, ClientLibrary>>();
	}
	
	private void populateMap(ClientLibrary[] clientLibs, 
			HashMap<String, HashMap<String, ClientLibrary>> languageToClientLibMap) {
		
		for (ClientLibrary clientLib : clientLibs) {
			HashMap<String, ClientLibrary> apiToClientLib = new HashMap<String, ClientLibrary>();
			
			if (clientLib.getApis().size() == 1 && clientLib.getApis().get(0).getName().equals("all")) {
				ApiManager apiManager = ApiManager.getInstance();
				for (Api api : apiManager.getAllApiDefinitions()) {
					apiToClientLib.put(api.getName(), clientLib);
				}
			} else {
				for (Api api : clientLib.getApis()) {
					apiToClientLib.put(api.getName(), clientLib);
				}
			}
			
			if (languageToClientLibMap.containsKey(clientLib.getLanguage()))
			{
				HashMap<String, ClientLibrary> previousApiToClientLib = 
						languageToClientLibMap.get(clientLib.getLanguage());
				
				for (String apiName : apiToClientLib.keySet()) {
					previousApiToClientLib.put(apiName, apiToClientLib.get(apiName));
				}
				
			} else{
				languageToClientLibMap.put(clientLib.getLanguage(), apiToClientLib);
			}
		}
	}

	private void initializeFromFile() {
		Gson gson = new Gson();
		String cloudLibsInJson= Util.readFromFile("./resources/cloud.json");
		String apiaryLibsInJson= Util.readFromFile("./resources/apiary.json");
		
		ClientLibrary[] cloudClientLibs = gson.fromJson(cloudLibsInJson, ClientLibrary[].class);
		ClientLibrary[] apiaryClientLibs = gson.fromJson(apiaryLibsInJson, ClientLibrary[].class);
		
		this.cloudClientLibList = new LinkedList<ClientLibrary>(Arrays.asList(cloudClientLibs));
		this.apiaryClientLibList = new LinkedList<ClientLibrary>(Arrays.asList(apiaryClientLibs));
		
		populateMap(cloudClientLibs, this.cloudClientLibMap);
		populateMap(apiaryClientLibs, this.apiaryClientLibMap);
	}
	
	public static ClientLibraryManager getInstance() {
		if (instance == null)
		{
			instance = new ClientLibraryManager();
			instance.initializeFromFile();
		}
		
		return instance;
	}
	
	public ClientLibrary getClientLibrary(String languageName, String apiName) {
		HashMap<String, ClientLibrary> apiToClientLib = this.cloudClientLibMap.get(languageName);
		if (apiToClientLib.containsKey(apiName)) {
			return apiToClientLib.get(apiName);
		} else {
			apiToClientLib = this.apiaryClientLibMap.get(languageName);
			return apiToClientLib.get(apiName);
		}
	}
	
	private void printAllClientLibraryDefinitionsHelper(
			HashMap<String, HashMap<String, ClientLibrary>> clientLibraryMap) {
		
		for (String language : clientLibraryMap.keySet()) {
			System.out.println("For language: " + language);
			
			HashMap<String, ClientLibrary> apiToClientLibrary = clientLibraryMap.get(language);
			for (String api : apiToClientLibrary.keySet()) {
				ClientLibrary clientLib = apiToClientLibrary.get(api);
				System.out.print(api + " is covered by library: ");
				System.out.println(clientLib.getName());
			}
			
			System.out.println();
		}
	}
	
	public void printAllClientLibraryDefinitions() {
		System.out.println("Printing APIARY mappings");
		this.printAllClientLibraryDefinitionsHelper(this.apiaryClientLibMap);
		
		System.out.println();
		System.out.println("Printing CLOUD mappings");
		this.printAllClientLibraryDefinitionsHelper(this.cloudClientLibMap);
	}
	
	private void printAllClientLibraryRawDefinitionsHelper(LinkedList<ClientLibrary> clientLibraryList) {
		for (ClientLibrary clientLib : clientLibraryList) {
			System.out.println("Name:         " + clientLib.getName());
			System.out.println("Language:     " + clientLib.getLanguage());
			System.out.println("Source:       " + clientLib.getSourceUrl());
			System.out.println("Sample:       " + clientLib.getSampleUrl());
			System.out.println("Api Ref:      " + clientLib.getApiReferenceUrl());
			System.out.println("Installation: " + clientLib.getInstallation());
			for (Api api : clientLib.getApis()) {
				System.out.println("    api: " + api.getName());
			}
			
			System.out.println();
		}
	}
	
	public void printAllClientLibraryRawDefinitions() {
		System.out.println();
		System.out.println("Printing APIARY raw definitions");
		printAllClientLibraryRawDefinitionsHelper(this.apiaryClientLibList);
		
		System.out.println("Printing CLOUD raw definitions");
		printAllClientLibraryRawDefinitionsHelper(this.cloudClientLibList);
		System.out.println();
	}
}
