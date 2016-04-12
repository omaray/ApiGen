package com.api.pagegen.model;

import java.util.LinkedList;
import java.util.List;

public class Category {
    String name;
    List<Api> apis;
    
    public Category() { }
    
    public Category(String name) {
        this.name = name;
        this.apis = new LinkedList<Api>();
    }
    
    public Category(String name, List<Api> apis) {
        this.name = name;
        this.apis = apis;
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<Api> getApis() {
        return this.apis;
    }
}