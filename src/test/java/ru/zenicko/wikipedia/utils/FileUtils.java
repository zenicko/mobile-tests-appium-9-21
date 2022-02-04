package ru.zenicko.wikipedia.utils;

import org.junit.jupiter.api.Assertions;

import java.io.File;

public class FileUtils {

    public static String getAbsolutePath(String path) {
        File file = new File(path);
        Assertions.assertTrue(file.exists(), path + " not found");

        return file.getAbsolutePath();
    }
}
