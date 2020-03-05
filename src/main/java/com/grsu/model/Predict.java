package com.grsu.model;

import java.util.List;
import java.util.Random;

public class Predict {
    ReadFromFile readFromFile = new ReadFromFile();

    public String createPredict(String type) {
        String predict = new String();
        switch (type) {
            case "1":
                predict = getRandomValueForPredict(readFromFile.fileRead("src/main/java/com/grsu/predictsText/Horoscope.txt"));
                break;
            case "2":
                predict = getRandomValueForPredict(readFromFile.fileRead("src/main/java/com/grsu/predictsText/Weather.txt"));
                break;
            default:
                predict = "error";
        }
        return predict;
    }

    public String getRandomValueForPredict(List<String> predictsText) {
        Random RANDOM = new Random();
        return predictsText.get(RANDOM.nextInt(predictsText.size()));
    }
}
