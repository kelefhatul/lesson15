package com.javarush.test.level31.lesson15.big01;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 11/23/2016.
 */
public class FileManager {
    private Path rootPath;
    private List<Path> fileList;


    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);

    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException{
        //4.1
        if (Files.isRegularFile(path)){
            Path relativePath = rootPath.relativize(path);
            fileList.add(relativePath);
        }
        //4.2
        if (Files.isDirectory(path)){
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                for (Path curPath : directoryStream
                     ) {
                    collectFileList(curPath);
                }
            directoryStream.close();
        }
    }
}
