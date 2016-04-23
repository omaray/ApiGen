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
    public static final String API_HTTP_REFERENCE_URL = "apiHttpReferenceUrl";
    
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
    
    // Landing page related constants for markdown
    public static final String CATEGORIES = "categories";
    
    // Api details page url related constants
    public static final String DETAILS_BASE_URL = "https://github.com/rok987/ApiGen/tree/master/out/";
    public static final String DETAILS_FILE_NAME = "%s_%s_details_page.md";
    public static final String DETAILS_VARIABLES_FILE_NAME = "%s_%s_variables_details_page.md";
    
    // Templates
    public static final String API_PAGE_TEMPLATE = "./resources/api_details_template.mustache";
    public static final String API_VARIABLE_PAGE_TEMPLATE = "./resources/api_details_variables_template.mustache";
    public static final String API_LANDING_TEMPLATE = "./resources/api_landing_template.mustache";
    public static final String API_LANDING_CLOUD_TEMPLATE = "./resources/api_landing_cloud_template.mustache";
    
    // Api Categories
    public static String[] API_CATEGORIES = 
        {"Compute", "Storage", "Networking", "Big Data", "Machine Learning", "Operations", "Tools"};
}
