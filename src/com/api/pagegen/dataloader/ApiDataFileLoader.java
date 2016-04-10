package com.api.pagegen.dataloader;

import java.util.Arrays;
import java.util.LinkedList;

import com.api.pagegen.Constants;
import com.api.pagegen.Util;
import com.api.pagegen.model.Api;
import com.google.gson.Gson;

public class ApiDataFileLoader implements DataLoader {
    public Object loadData() {
        Gson gson = new Gson();
        String apisInJson= Util.readFromFile(Constants.APIS_JSON_PATH);
        Api[] apis = gson.fromJson(apisInJson, Api[].class);
        
        return new LinkedList<Api>(Arrays.asList(apis));
    }
}