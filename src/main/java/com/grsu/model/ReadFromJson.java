package com.grsu.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ReadFromJson implements ReadFile {
    public List<String> fileRead(String fileName) {
        JSONParser jsonParser = new JSONParser();
        Set<String> predicts = new LinkedHashSet<>();
        try (FileReader reader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(reader);

            JSONArray forecastList = (JSONArray) obj;

            forecastList.forEach(forecast -> predicts.add(parseForecastObject((JSONObject) forecast)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>(predicts);
    }

    private String parseForecastObject(JSONObject forecast) {
        JSONObject predictObject = (JSONObject) forecast.get("predict");
        return (String) predictObject.get("text");
    }


}
