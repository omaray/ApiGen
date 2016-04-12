package com.api.pagegen.model;

public class Api {
    String name;
    String displayName;
    String description;
    String categoryName;
    String overviewUrl;
    String gettingStartedUrl;
    String apiExplorerUrl;
    String httpReferenceUrl;
    String apiDetailsUrl;
    String apiReference;
    
    public Api() {}
    
    public Api(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getCategoryName() {
        return this.categoryName;
    }

    public String getOverviewUrl() {
        return this.overviewUrl;
    }
    
    public String getGettingStartedUrl() {
        return this.gettingStartedUrl;
    }
    
    public String getApiExplorerUrl() {
        return this.apiExplorerUrl;
    }
    
    public String getHttpReferenceUrl() {
        return this.httpReferenceUrl;
    }
    
    public String getApiDetailsUrl() {
        return this.apiDetailsUrl;
    }
    
    public void setApiDetailsUrl(String apiDetailsUrl) {
        this.apiDetailsUrl = apiDetailsUrl;
    }
    
    public String getApiReference() {
        return this.apiReference;
    }
}
