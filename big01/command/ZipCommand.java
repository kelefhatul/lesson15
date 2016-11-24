package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by root on 11/23/2016.
 */
public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception {

        ConsoleHelper.writeMessage("Input full archive path:");
        String fullZipPathString = ConsoleHelper.readString();
        Path fullZipPath = Paths.get(fullZipPathString);
        ZipFileManager zipFileManager = new ZipFileManager(fullZipPath);

        return zipFileManager;
    }
}
