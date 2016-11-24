package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;
import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by root on 11/23/2016.
 */
public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Deleting...");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Source for deleting");
            Path sourceForDeleting = Paths.get(ConsoleHelper.readString());
            zipFileManager.removeFile(sourceForDeleting);

            ConsoleHelper.writeMessage("File was deleted.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Неверный путь для распаковки.");
        }

    }
}
