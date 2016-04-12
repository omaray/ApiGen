package com.api.pagegen;

import java.util.List;

import com.api.pagegen.manager.ApiManager;
import com.api.pagegen.manager.ClientLibraryManager;
import com.api.pagegen.manager.LanguageManager;
import com.api.pagegen.manager.MarkdownManager;
import com.api.pagegen.model.Api;
import com.api.pagegen.model.Category;
import com.api.pagegen.model.ClientLibrary;
import com.api.pagegen.model.Language;

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
        this.generateApiLandingPage("Node.js");
        this.generateApiDetailsPages("Node.js");
    }
    
    private void generateApiLandingPage(String languageName) throws Exception {
        Language language = this.languageManager.getLanguageDefinition(languageName);
        this.apiManager.setApiDetailsUrl(language);
        List<Category> categories = this.apiManager.getCategories();
        markdownManager.generateApiLandingPage(language, categories);
    }
    
    private void generateApiDetailsPages(String languageName) throws Exception {
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
