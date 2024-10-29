package com.justusdev.springforge.utils_module;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {

    public static String getPackagePathFromWorkingDirectory() {
        // Get the current working directory
        Path workingDir = Paths.get("").toAbsolutePath();

        // Convert the path to a string and find the index of "com/"
        String pathString = workingDir.toString();
        int comIndex = pathString.indexOf("com/");

        if (comIndex == -1) {
            throw new IllegalArgumentException("'com' not found in the current path.");
        }

        // Extract from "com/" onward and replace '/' with '.'
        return pathString.substring(comIndex).replace("/", ".");
    }
}
