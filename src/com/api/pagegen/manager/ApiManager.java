package com.api.pagegen.manager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.api.pagegen.Constants;
import com.api.pagegen.dataloader.ApiDataFileLoader;
import com.api.pagegen.model.Api;
import com.api.pagegen.model.Category;
import com.api.pagegen.model.Language;

public class ApiManager {
    private static ApiManager instance;
    private LinkedList<Api> apiList;
    private HashMap<String, Api> apiMap;
    private LinkedList<Category> categories;
    
    private ApiManager() {
        this.apiList = new LinkedList<Api>();
        this.apiMap = new HashMap<String, Api>();
        this.categories = new LinkedList<Category>();
        
        for (String categoryName : Constants.API_CATEGORIES) {
            Category category = new Category(categoryName);
            this.categories.add(category);
        }
    }
        
    private void initializeCategoryList(List<Api> apiList) {
        for (Api api : apiList) {
            String categoryName = api.getCategoryName();       
            
            Category category = null;
            for (Category c : this.categories) {
                if (c.getName().equals(categoryName)) {
                    category = c;
                    break;
                }
            }
            
            if (category == null) {
                System.out.println(String.format("ERROR: Category %s is unknown", categoryName));
            }
            
            category.getApis().add(api);  
        }
    }
    
    @SuppressWarnings("unchecked")
    private void initialize() {
        // Load api data from json file
        ApiDataFileLoader apiLoader = new ApiDataFileLoader();
        this.apiList = (LinkedList<Api>)apiLoader.loadData();
        
        this.initializeCategoryList(this.apiList);
        
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
    
    public List<Category> getCategories() {
        return this.categories;
    }
    
    public void setApiDetailsUrl(Language language) {
        for (Api api : this.apiList) {
            String fileName = String.format(Constants.DETAILS_FILE_NAME, language.getName(), api.getName());
            String apiDetailsUrl = Constants.DETAILS_BASE_URL + language.getName() + "/" + fileName;
            api.setApiDetailsUrl(apiDetailsUrl);
        }
    }
    
    public void printAllApiDefinitions() {
        List<Api> apis = this.getAllApiDefinitions();
        
        for (Api api : apis) {
            System.out.println();
            System.out.println("Api Name:        " + api.getName());
            System.out.println("Display Name:    " + api.getDisplayName());
            System.out.println("Description:     " + api.getDescription());
            System.out.println("Category Name:   " + api.getCategoryName());
            System.out.println("Overview:        " + api.getOverviewUrl());
            System.out.println("Getting Started: " + api.getGettingStartedUrl());
            System.out.println("Api Explorer:    " + api.getApiExplorerUrl());
            System.out.println("Http Reference:  " + api.getHttpReferenceUrl());
        }
    }
}
