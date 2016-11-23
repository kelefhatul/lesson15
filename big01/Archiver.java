package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by root on 11/22/2016.
 */
public class Archiver {
    public static void main(String[] args) throws Exception {
        String fullPath = "";
        System.out.println("Input full file path for archive: ");
        BufferedReader keybord = new BufferedReader(new InputStreamReader(System.in));
        try {
            fullPath = keybord.readLine();
        } catch (IOException e) {
            /*NOP*/
        }

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fullPath));
        System.out.println("Input full file path to file: ");
        String filePath ="";
        try {
            filePath = keybord.readLine();
            zipFileManager.createZip(Paths.get(filePath));
        } catch (Exception e) {
            /*NOP*/
        }


        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
