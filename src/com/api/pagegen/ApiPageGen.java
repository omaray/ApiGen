package com.api.pagegen;

public class ApiPageGen {
	private ApiManager apiManager;
	private LanguageManager languageManager;
	private ClientLibraryManager clientLibManager;
	private MarkdownManager markdownManager;
	
	public ApiPageGen() {
		this.apiManager = ApiManager.getInstance();
		this.languageManager = LanguageManager.getInstance();
		this.clientLibManager = ClientLibraryManager.getInstance();
		this.markdownManager = MarkdownManager.getInstance();
	}
	
	public void generateApiPages() throws Exception{
		this.generateApiPagesHelper("Node.js");
		this.generateApiPagesHelper("Python");
	}
	
	private void generateApiPagesHelper(String languageName) throws Exception {
		Language language = this.languageManager.getLanguageDefinition(languageName);
		for (Api api : apiManager.getAllApiDefinitions()) {
			ClientLibrary clientLib = clientLibManager.getClientLibrary(language.getName(), api.getName());
			markdownManager.generateApiDetailsPage(language, api, clientLib);
		}
	}
	
	static public void main(String[] args) throws Exception {
		ApiPageGen apiPageGen = new ApiPageGen();
		apiPageGen.generateApiPages();
	}
}
