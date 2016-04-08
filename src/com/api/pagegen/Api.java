package com.api.pagegen;

public class Api {
	private String name;
	private String displayName;
	private String description;
	private String overviewUrl;
	private String gettingStartedUrl;
	private String apiExplorerUrl;
	private String httpReferenceUrl;
	
	public Api() {}
	
	public String getName() {
		return this.name;
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getOverviewUrl() {
		return this.overviewUrl;
	}
	
	public String getGettingStartedUrl() {
		return this.gettingStartedUrl;
	}
	
	public String getApiExplorerUrl() {
		return this.apiExplorerUrl;
	}
	
	public String getHttpReferenceUrl() {
		return this.httpReferenceUrl;
	}
}
