package com.grsu.model.domain;

import com.grsu.model.ReadFromFile;

import java.util.List;
import java.util.Random;

public abstract class Predict extends Period {
    private ReadFromFile readFromFile = new ReadFromFile();

    public String createPredict(String fileName) {
        return getRandomValueForPredict(readFromFile.fileRead(fileName));
    }

    private String getRandomValueForPredict(List<String> predictsText) {
        Random RANDOM = new Random();
        return predictsText.get(RANDOM.nextInt(predictsText.size()));
    }
}
