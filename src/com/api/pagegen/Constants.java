package com.api.pagegen;

public class Constants {
    
	// Path to json data files
    public static final String APIS_JSON_PATH = "./resources/apis.json";
    public static final String CLOUD_JSON_PATH = "./resources/cloud.json";
    public static final String APIARY_JSON_PATH = "./resources/apiary.json";
    public static final String LANGUAGES_JSON_PATH = "./resources/languages.json";
    
    // Api related constants for markdown
    public static final String API_DISPLAY_NAME = "apiDisplayName";
    public static final String API_DESCRIPTION = "apiDescription";
    public static final String API_OVERVIEW_URL = "apiOverviewUrl";
    public static final String API_GETTING_STARTED_URL = "apiGettingStartedUrl";
    public static final String API_EXPLORER_URL = "apiExplorerUrl";
    
    // Language related constants for markdown
    public static final String LANGUAGE_NAME = "languageName";
    public static final String LANGUAGE_PACKAGE_MANAGER = "languagePackageManager";
    public static final String LANGUAGE_PACKAGE_MANAGER_URL = "languagePackageManagerUrl";
    
    // Client library related constants for markdown
    public static final String CLIENT_LIB_SOURCE_URL = "clientLibSourceUrl";
    public static final String CLIENT_LIB_DISPLAY_NAME = "clientLibDisplayName";
    public static final String CLIENT_LIB_INSTALLATION = "clientLibInstallation";
    public static final String CLIENT_LIB_API_REFERENCE_URL = "clientLibApiReferenceUrl";
    public static final String CLIENT_LIB_GENERAL_API_REFERENCE_URL = "clientLibGeneralApiReferenceUrl";
    
    // Templates
    public static final String API_PAGE_TEMPLATE = "./resources/api_details_template.mustache";
}
