package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.FileProperties;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.util.List;

/**
 * Created by root on 11/23/2016.
 */
public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        List<FileProperties> tmp = zipFileManager.getFilesList();
        int tmpListSize = tmp.size();
        for (int i = 0; i < tmpListSize ; i++) {
            ConsoleHelper.writeMessage(tmp.get(i).toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");

    }
}
