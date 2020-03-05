package com.grsu.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {
    public List<String> fileRead(String fileName) {
        List<String> predicts = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new File(fileName));
            while (in.hasNextLine())
                predicts.add(in.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return predicts;
    }
}
