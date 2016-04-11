package com.api.pagegen.model;

public class Api {
    private String name;
    private String displayName;
    private String description;
    private String category;
    private String overviewUrl;
    private String gettingStartedUrl;
    private String apiExplorerUrl;
    private String httpReferenceUrl;
    private String apiReference;
    
    public Api() {}
    
    public String getName() {
        return this.name;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getCategory() {
        return this.category;
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
    
    public String getApiReference() {
        return this.apiReference;
    }
}
