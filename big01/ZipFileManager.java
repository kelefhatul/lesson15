package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by root on 11/22/2016.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{

        //5.1
        if (Files.notExists(zipFile.getParent())){
            Files.createDirectories(zipFile.getParent());
        }
        //5.2
        try (ZipOutputStream zout = new ZipOutputStream(Files.newOutputStream(zipFile))){
            if (Files.isRegularFile(source)){
                addNewZipEntry(zout,source.getParent(),source.getFileName());
            }
            //5.3
            else if (Files.isDirectory(source)){
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path curPath : fileNames
                        ) {
                    addNewZipEntry(zout, source, curPath);
                }
            } else {        //5.4
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName); //1.1
        try (InputStream inputStream = Files.newInputStream(fullPath)){     //1.1 + 1.5
            ZipEntry zipEntry = new ZipEntry(fileName.toString());          //1.2
            zipOutputStream.putNextEntry(zipEntry);
            //1.3 before this point need realize point 3
            copyData(inputStream, zipOutputStream);
            //1.4
            zipOutputStream.closeEntry();
        }
    }
    //3
    private void copyData(InputStream in, OutputStream out) throws Exception{
        int bufferSize = 1 * 1024;
        byte[] buffer = new byte[bufferSize];
        int count;
        while ((count = in.read(buffer)) != -1){
            out.write(buffer,0, count);
            out.flush();
        }
    }
}
