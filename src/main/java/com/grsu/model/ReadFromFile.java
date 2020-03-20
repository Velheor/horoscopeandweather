package com.grsu.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFromFile implements ReadFile {
    public List<String> fileRead(String fileName) {
        Set<String> predicts = new LinkedHashSet<String>();
        try {
            Scanner in = new Scanner(new File(fileName));
            while (in.hasNextLine())
                predicts.add(in.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(predicts);
    }
}