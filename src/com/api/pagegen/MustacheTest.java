package com.api.pagegen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class MustacheTest {
	
	public void test1() throws IOException {
		HashMap<String, Object> scope = new HashMap<String, Object>();
		scope.put("apiName", "compute");
		scope.put("language", "node");
		scope.put("description", "The Compute Engine API is the best");
		scope.put("overview", "https://something.com");
		
		scope.put("item1", "item1");
		scope.put("item2", "");
		scope.put("item3", "item3");
		
		MustacheFactory mf = new DefaultMustacheFactory();
	    Mustache mustache = mf.compile("./resources/template.mustache");
	    mustache.execute(new PrintWriter(System.out), scope).flush();
	}
	
	public void test2() throws IOException {
		HashMap<String, Object> scope = new HashMap<String, Object>();
		scope.put("displayName", "Compute Engine");
		scope.put("language", "Node.js");
		scope.put("description", "The Compute Engine API is the best.");
		scope.put("overviewUrl", "https://cloud.google.com/compute/docs/");
		scope.put("gettingStartedUrl", "https://cloud.google.com/compute/docs/linux-quickstart");
		scope.put("sourceUrl", "https://github.com/googlecloudplatform/gcloud-node");
		scope.put("apiExplorerUrl", "https://developers.google.com/apis-explorer/#p/compute/v1/");
		
		scope.put("libName", "gcloud-node");
		scope.put("packageManager", "npm");
		scope.put("packageManagerUrl", "https://www.npmjs.com/");
		scope.put("installation", "npm install --save gcloud");
		
		scope.put("apiReferenceUrl", "https://googlecloudplatform.github.io/gcloud-node/#/docs/v0.29.0/gcloud");
		
		MustacheFactory mf = new DefaultMustacheFactory();
	    Mustache mustache = mf.compile("./resources/api_details_template.mustache");
	    mustache.execute(new PrintWriter(System.out), scope).flush();
	}

	static public void main(String[] args) throws IOException {
		MustacheTest mustache = new MustacheTest();
		mustache.test2();
	}
}
