package com.grsu;

import java.util.List;
import java.util.Random;

public class Predict {
    public String createPredict(String type) {
        String predict;
        switch (type) {
            case "1":
                predict = getRandomValueForPredict(ReadFromFile.fileRead("src/main/java/com/grsu/Horoscope.txt"));
                break;
            case "2":
                predict = getRandomValueForPredict(ReadFromFile.fileRead("src/main/java/com/grsu/Weather.txt"));
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
