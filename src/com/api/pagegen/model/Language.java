package com.api.pagegen.model;

public class Language {
    String name;
    String packageManager;
    String packageManagerUrl;
    
    public Language() {}
    
    public Language(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPackageManager() {
        return this.packageManager;
    }
    
    public String getPackageManagerUrl() {
        return this.packageManagerUrl;
    }
}
