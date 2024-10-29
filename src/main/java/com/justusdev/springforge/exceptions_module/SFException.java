package com.justusdev.springforge.exceptions_module;

import com.justusdev.springforge.utils_module.templates.exception.ExceptionModelTemplate;
import com.justusdev.springforge.utils_module.templates.exception.ForgeGlobalExceptionHandlerTemplate;
import com.justusdev.springforge.utils_module.templates.exception.GlobalExceptionTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.justusdev.springforge.utils_module.PathUtil.getPackagePathFromWorkingDirectory;

public class SFException {

    public void createSystemGlobalFile(File baseDir) throws IOException {
        String templateFileName = "GlobalExceptionHandler.java";
        String templateFileName_2 = "ExceptionModel.java";
        String templateFileName_3 = "GlobalException.java";

        File templateFile = new File(baseDir, templateFileName);
        File templateFile_1 = new File(baseDir, templateFileName_2);
        File templateFile_2 = new File(baseDir, templateFileName_3);

        String packagePath = getPackagePathFromWorkingDirectory();
        String convertPath = String.valueOf(baseDir).replace("/",".");
        String replacement = packagePath+"."+convertPath;



        // Check if any of the files already exist
        if (!templateFile.exists() && !templateFile_1.exists() && !templateFile_2.exists()) {
            try (FileWriter writer1 = new FileWriter(templateFile);
                 FileWriter writer2 = new FileWriter(templateFile_1);
                 FileWriter writer3 = new FileWriter(templateFile_2)) {

                writer1.write(ForgeGlobalExceptionHandlerTemplate.GLOBAL_EXCEPTION_HANDLER.replace("{packageName}", replacement ));
                writer2.write(ExceptionModelTemplate.EXCEPTION_MODEL_CLASS.replace("{packageName}", replacement ));
                writer3.write(GlobalExceptionTemplate.GLOBAL_EXCEPTION_CLASS.replace("{packageName}", replacement ));

                System.out.println("Created template files:");
                System.out.println(" - " + templateFile.getAbsolutePath());
                System.out.println(" - " + templateFile_1.getAbsolutePath());
                System.out.println(" - " + templateFile_2.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error writing template files: " + e.getMessage());
            }
        } else {
            System.out.println("One or more template files already exist:");
            if (templateFile.exists()) {
                System.out.println(" - " + templateFile.getAbsolutePath());
            }
            if (templateFile_1.exists()) {
                System.out.println(" - " + templateFile_1.getAbsolutePath());
            }
            if (templateFile_2.exists()) {
                System.out.println(" - " + templateFile_2.getAbsolutePath());
            }
        }
    }

}
