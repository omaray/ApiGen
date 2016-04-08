package com.api.pagegen;

public class ApiPageGen {
	
	static public void main(String[] args) throws Exception {
		
		ApiManager apiManager = ApiManager.getInstance();
		apiManager.printAllApiDefinitions();
		
		LanguageManager languageManager = LanguageManager.getInstance();
		languageManager.printAllLanguageDefinitions();
		
		ClientLibraryManager clientLibManager = ClientLibraryManager.getInstance();
		clientLibManager.printAllClientLibraryRawDefinitions();
		clientLibManager.printAllClientLibraryDefinitions();
		
		MarkdownManager markdownManager = MarkdownManager.getInstance();
		Language language = languageManager.getLanguageDefinition("Node.js");
		for (Api api : apiManager.getAllApiDefinitions()) {
			ClientLibrary clientLib = clientLibManager.getClientLibrary(language.getName(), api.getName());
			markdownManager.generateApiDetailsPage(language, api, clientLib);
		}
		
		language = languageManager.getLanguageDefinition("Python");
		for (Api api : apiManager.getAllApiDefinitions()) {
			ClientLibrary clientLib = clientLibManager.getClientLibrary(language.getName(), api.getName());
			markdownManager.generateApiDetailsPage(language, api, clientLib);
		}
	}
}
