package com.grsu.io;

import java.util.Scanner;

public class IOConsole implements InputOutput {
    public void writeMessage(String message) {
        System.out.println(message);
    }

    public String getAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}