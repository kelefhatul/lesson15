package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by root on 11/23/2016.
 */
public class ConsoleHelper {
    private static BufferedReader keybordIn = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String inData ="";
        inData = keybordIn.readLine();
        return inData;
    }

    public static int readInt() throws IOException {
        int result = 0;
        result = Integer.parseInt(readString());
        return result;
    }
}
