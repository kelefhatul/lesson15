package com.javarush.test.level31.lesson15.big01.command;


import com.javarush.test.level31.lesson15.big01.ConsoleHelper;

/**
 * Created by root on 11/23/2016.
 */
public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
