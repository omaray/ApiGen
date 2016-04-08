package com.api.pagegen.dataloader;

import java.util.Arrays;
import java.util.LinkedList;

import com.api.pagegen.Constants;
import com.api.pagegen.Util;
import com.api.pagegen.model.ClientLibrary;
import com.google.gson.Gson;

public class ClientLibraryDataFileLoader implements DataLoader {
	public Object loadData() {
		Gson gson = new Gson();
		ClientLibraries clientLibs = new ClientLibraries();
		
		String cloudLibsInJson= Util.readFromFile(Constants.CLOUD_JSON_PATH);		
		ClientLibrary[] cloudClientLibs = gson.fromJson(cloudLibsInJson, ClientLibrary[].class);
		clientLibs.cloudClientLibList = new LinkedList<ClientLibrary>(Arrays.asList(cloudClientLibs));
		
		String apiaryLibsInJson= Util.readFromFile(Constants.APIARY_JSON_PATH);
		ClientLibrary[] apiaryClientLibs = gson.fromJson(apiaryLibsInJson, ClientLibrary[].class);
		clientLibs.apiaryClientLibList = new LinkedList<ClientLibrary>(Arrays.asList(apiaryClientLibs));
		
		return clientLibs;
	}
	
	public class ClientLibraries {
		public LinkedList<ClientLibrary> cloudClientLibList;
		public LinkedList<ClientLibrary> apiaryClientLibList;
	}
}
