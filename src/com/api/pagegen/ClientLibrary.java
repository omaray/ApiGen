package com.api.pagegen;

import java.util.ArrayList;

public class ClientLibrary {
	private String name;
	private String language;
	private String sourceUrl;
	private String sampleUrl;
	private String apiReferenceUrl;
	private String installation;
	ArrayList<Api> apis;
	
	public ClientLibrary() {}
	
	public String getName() {
		return this.name;
	}
	
	public String getLanguage() {
		return this.language;
	}
	
	public String getSourceUrl() {
		return this.sourceUrl;
	}
	
	public String getSampleUrl() {
		return this.sampleUrl;
	}
	
	public String getApiReferenceUrl() {
		return this.apiReferenceUrl;
	}
	
	public String getInstallation() {
		return this.installation;
	}
	
	public ArrayList<Api> getApis() {
		return this.apis;
	}
}
