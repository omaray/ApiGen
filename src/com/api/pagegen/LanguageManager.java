package com.api.pagegen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

public class LanguageManager {
	private static LanguageManager instance;
	private LinkedList<Language> languageList;
	private HashMap<String, Language> languageMap;
	
	private LanguageManager() {
		this.languageList = new LinkedList<Language>();
		this.languageMap = new HashMap<String, Language>();
	}
	
	private void initializeFromFile() {
		Gson gson = new Gson();
		String languagesInJson= Util.readFromFile("./resources/languages.json");
		Language[] languages = gson.fromJson(languagesInJson, Language[].class);
		
		this.languageList = new LinkedList<Language>(Arrays.asList(languages));
		
		for (Language language : languages) {
			this.languageMap.put(language.getName(), language);
		}
	}
	
	public static LanguageManager getInstance() {
		if (instance == null)
		{
			instance = new LanguageManager();
			instance.initializeFromFile();
		}
		
		return instance;
	}
	
	public List<Language> getAllLanguageDefinitions() {
		return this.languageList;
	}
	
	public Language getLanguageDefinition(String languageName) {
		return this.languageMap.get(languageName);
	}
	
	public void printAllLanguageDefinitions() {
		List<Language> languages = this.getAllLanguageDefinitions();
		
		for (Language language: languages) {
			System.out.println();
			System.out.println(language.getName());
			System.out.println(language.getPackageManager());
			System.out.println(language.getPackageManagerUrl());
		}
	}
}
