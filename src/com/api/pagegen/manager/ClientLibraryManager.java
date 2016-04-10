package com.api.pagegen.manager;

import java.util.HashMap;
import java.util.LinkedList;

import com.api.pagegen.dataloader.ClientLibraryDataFileLoader;
import com.api.pagegen.model.Api;
import com.api.pagegen.model.ClientLibrary;

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
    
    private void populateMap(LinkedList<ClientLibrary> clientLibs, 
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

    private void initialize() {
        
        // Load client library data from json file
        ClientLibraryDataFileLoader clientLibLoader = new ClientLibraryDataFileLoader();
        ClientLibraryDataFileLoader.ClientLibraries clientLibs = 
                (ClientLibraryDataFileLoader.ClientLibraries)clientLibLoader.loadData();
        
        this.cloudClientLibList = clientLibs.cloudClientLibList;
        this.apiaryClientLibList = clientLibs.apiaryClientLibList;
        
        populateMap(this.cloudClientLibList, this.cloudClientLibMap);
        populateMap(this.apiaryClientLibList, this.apiaryClientLibMap);
    }
    
    public static ClientLibraryManager getInstance() {
        if (instance == null)
        {
            instance = new ClientLibraryManager();
            instance.initialize();
        }
        
        return instance;
    }
    
    public ClientLibrary getClientLibrary(String languageName, String apiName) {
        
        // Try cloud library first
        HashMap<String, ClientLibrary> apiToClientLib = this.cloudClientLibMap.get(languageName);
        if (apiToClientLib.containsKey(apiName)) {
            return apiToClientLib.get(apiName);
        } else {
            
            // Otherwise revert to apiary client library
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
            System.out.println("Api Ref:      " + clientLib.getGeneralApiReferenceUrl());
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
