package com.api.pagegen;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class MarkdownManager {
	private static MarkdownManager instance;
	
	private MarkdownManager() {}
	
	public static MarkdownManager getInstance() {
		if (instance == null)
		{
			instance = new MarkdownManager();
		}
		
		return instance;
	}
	
	public void generateApiDetailsPage(Language language, Api api, ClientLibrary clientLib) throws Exception {
		HashMap<String, Object> scopes = new HashMap<String, Object>();
		scopes.put("displayName", api.getDisplayName());
		scopes.put("language", language.getName());
		scopes.put("description", api.getDescription());
		scopes.put("overviewUrl", api.getOverviewUrl());
		scopes.put("gettingStartedUrl", api.getGettingStartedUrl());
		scopes.put("sourceUrl", clientLib.getSourceUrl());
		scopes.put("apiExplorerUrl", api.getApiExplorerUrl());
		
		scopes.put("libName", clientLib.getName());
		scopes.put("packageManager", language.getPackageManager());
		scopes.put("packageManagerUrl", language.getPackageManagerUrl());
		scopes.put("installation", clientLib.getInstallation());
		
		scopes.put("apiReferenceUrl", clientLib.getApiReferenceUrl());
		
		MustacheFactory mf = new DefaultMustacheFactory();
	    Mustache mustache = mf.compile("./resources/api_details_template.mustache");
	    
	    String fileName = language.getName() + "_" + api.getName() + "_details_page.md";
	    File file = new File("./out/" + fileName);
	    mustache.execute(new PrintWriter(file), scopes).flush();
	}
}
