package com.grsu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReadFromFile {
    public static List<String> fileRead(String fileName) {
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
