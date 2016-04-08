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
		scopes.put(Constants.API_DISPLAY_NAME, api.getDisplayName());
		scopes.put(Constants.API_DESCRIPTION, api.getDescription());
		scopes.put(Constants.API_OVERVIEW_URL, api.getOverviewUrl());
		scopes.put(Constants.API_GETTING_STARTED_URL, api.getGettingStartedUrl());
		scopes.put(Constants.API_EXPLORER_URL, api.getApiExplorerUrl());
		
		scopes.put(Constants.LANGUAGE_NAME, language.getName());
		scopes.put(Constants.LANGUAGE_PACKAGE_MANAGER, language.getPackageManager());
		scopes.put(Constants.LANGUAGE_PACKAGE_MANAGER_URL, language.getPackageManagerUrl());
		
		scopes.put(Constants.CLIENT_LIB_SOURCE_URL, clientLib.getSourceUrl());
		scopes.put(Constants.CLIENT_LIB_DISPLAY_NAME, clientLib.getDisplayName());
		scopes.put(Constants.CLIENT_LIB_INSTALLATION, clientLib.getInstallation());
		scopes.put(Constants.CLIENT_LIB_API_REFERENCE_URL, clientLib.getApiReferenceUrl(api.getName()));
		scopes.put(Constants.CLIENT_LIB_GENERAL_API_REFERENCE_URL, clientLib.getGeneralApiReferenceUrl());
		
		MustacheFactory mf = new DefaultMustacheFactory();
	    Mustache mustache = mf.compile(Constants.API_PAGE_TEMPLATE);
	    
	    String fileName = language.getName() + "_" + api.getName() + "_details_page.md";
	    File file = new File("./out/" + language.getName() + "/" + fileName);
	    mustache.execute(new PrintWriter(file), scopes).flush();
	}
}
