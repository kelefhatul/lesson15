package com.javarush.test.level31.lesson15.big01;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
        //1
        try (ZipOutputStream zout = new ZipOutputStream(Files.newOutputStream(zipFile));) {
            //2
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            //3
            zout.putNextEntry(zipEntry);
            //4.1
            try (InputStream fin = Files.newInputStream(source);) {
                //4.2
                int inData;
                while ((inData = fin.read()) != -1) {
                    zout.write(inData);
                }
            }
            zout.closeEntry();
        }




    }
}
