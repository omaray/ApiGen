package com.api.pagegen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;

import com.api.pagegen.model.Api;
import com.api.pagegen.model.Category;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class MustacheTest {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        LinkedList<Category> categories = new LinkedList<Category>();
        
        Api api1 = new Api("Container");
        Api api2 = new Api("AppEngine");
        LinkedList<Api> apis = new LinkedList<Api>();
        apis.add(api1);
        apis.add(api2);
        Category category1 = new Category("Compute", apis);
        
        categories.add(category1);
        
        HashMap<String, Object> scopes = new HashMap<String, Object>();
        scopes.put("categories", categories);
       
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(Constants.API_LANDING_TEMPLATE);
        
        //String fileName = "test.md";
        //File file = new File("./out/" + fileName);
        mustache.execute(new PrintWriter(System.out), scopes).flush();
    }

}
