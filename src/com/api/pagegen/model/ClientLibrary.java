package com.api.pagegen.model;

import java.util.ArrayList;

public class ClientLibrary {
    String name;
    String displayName;
    String language;
    String sourceUrl;
    String sampleUrl;
    String generalApiReferenceUrl;
    String installation;
    ArrayList<Api> apis;
    
    public ClientLibrary() {}
    
    public ClientLibrary(String name) {
        this.name = name;
    }
    
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
