package com.api.pagegen.model;

import java.util.ArrayList;

public class ClientLibrary {
    private String name;
    private String displayName;
    private String language;
    private String sourceUrl;
    private String sampleUrl;
    private String generalApiReferenceUrl;
    private String installation;
    ArrayList<Api> apis;
    
    public ClientLibrary() {}
    
    public String getName() {
        return this.name;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public String getLanguage() {
        return this.language;
    }
    
    public String getSourceUrl() {
        return this.sourceUrl;
    }
    
    public String getSampleUrl() {
        return this.sampleUrl;
    }
    
    public String getGeneralApiReferenceUrl() {
        return this.generalApiReferenceUrl;
    }
    
    public String getInstallation() {
        return this.installation;
    }
    
    public ArrayList<Api> getApis() {
        return this.apis;
    }
    
    public String getApiReferenceUrl(String apiName) {
        for (Api api : this.apis) {
            if (api.getName().equals(apiName)) {
                return api.getApiReference();
            }
        }
        
        return null;
    }
}
