package com.grsu.model.domain;

import com.grsu.model.ReadFromDB;

import java.util.List;
import java.util.Random;

public class Predict {
    private ReadFromDB readFromDB = new ReadFromDB();

    public String createPredict(String fileName) {
        return getRandomValueForPredict(readFromDB.fileRead(fileName));
    }

    private String getRandomValueForPredict(List<String> predictsText) {
        Random RANDOM = new Random();
        return predictsText.get(RANDOM.nextInt(predictsText.size()));
    }
}