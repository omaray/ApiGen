package com.api.pagegen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LanguageManager {
	private static LanguageManager instance;
	private LinkedList<Language> languageList;
	private HashMap<String, Language> languageMap;
	
	private LanguageManager() {
		this.languageList = new LinkedList<Language>();
		this.languageMap = new HashMap<String, Language>();
	}
	
	@SuppressWarnings("unchecked")
	private void initializeFromFile() {
		// Load language data from json file
		LanguageDataFileLoader languageLoader = new LanguageDataFileLoader();
		this.languageList = (LinkedList<Language>)languageLoader.loadData();
		
		for (Language language : this.languageList) {
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
