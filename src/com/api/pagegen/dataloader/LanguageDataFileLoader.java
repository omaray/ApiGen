package com.api.pagegen.dataloader;

import java.util.Arrays;
import java.util.LinkedList;

import com.api.pagegen.Constants;
import com.api.pagegen.Util;
import com.api.pagegen.model.Language;
import com.google.gson.Gson;

public class LanguageDataFileLoader implements DataLoader {
	public Object loadData() {
		Gson gson = new Gson();
		String languagesInJson= Util.readFromFile(Constants.LANGUAGES_JSON_PATH);
		Language[] languages = gson.fromJson(languagesInJson, Language[].class);
		
		return new LinkedList<Language>(Arrays.asList(languages));
	}
}
