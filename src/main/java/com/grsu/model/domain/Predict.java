package com.grsu.model.domain;

import com.grsu.model.ReadFromJson;

import java.util.List;
import java.util.Random;

public class Predict {
    private ReadFromJson readFromJson = new ReadFromJson();

    public String createPredict(String fileName) {
        return getRandomValueForPredict(readFromJson.fileRead(fileName));
    }

    private String getRandomValueForPredict(List<String> predictsText) {
        Random RANDOM = new Random();
        return predictsText.get(RANDOM.nextInt(predictsText.size()));
    }
}