package com.justusdev.springforge.utils_module.templates.file_upload;

public class ForgeFileUploadTemplate {
        public static final String FILE_UPLOAD_TEMPLATE =
                "package {packageName};\n\n" +
                "import org.springframework.web.multipart.MultipartFile;\n" +
                "import java.io.IOException;\n" +
                "import java.nio.file.Files;\n" +
                "import java.nio.file.Path;\n" +
                "import java.nio.file.Paths;\n" +
                "import java.util.Objects;\n\n" +
                "private static final long MAX_FILE_SIZE = 3 * 1024 * 1024;\n" +
                        "private static final String UPLOAD_PATH = \"/uploads/\";\n\n" +

                        "public String uploadSingleFile(MultipartFile file, String folderName) throws IOException {\n\n" +
                        "    // Validate file and folder name\n" +
                        "    if (file.isEmpty()) {\n" +
                        "        return \"Failed: No file uploaded.\";\n" +
                        "    }\n\n" +
                        "    if (folderName == null || folderName.trim().isEmpty()) {\n" +
                        "        return \"Failed: Folder name is mandatory.\";\n" +
                        "    }\n\n" +
                        "    if (file.getSize() > MAX_FILE_SIZE) {\n" +
                        "        return \"Failed: File size exceeds the maximum allowed size of 3MB.\";\n" +
                        "    }\n\n" +
                        "    // Construct the actual path where the file will be stored\n" +
                        "    String actualPath = UPLOAD_PATH + folderName + \"/\";\n" +
                        "    Path folderPath = Paths.get(actualPath);\n\n" +
                        "    // Ensure the folder exists, if not create it\n" +
                        "    if (!Files.exists(folderPath)) {\n" +
                        "        Files.createDirectories(folderPath);\n" +
                        "    }\n\n" +
                        "    // Handle the file path\n" +
                        "    Path filePath = folderPath.resolve(Objects.requireNonNull(file.getOriginalFilename()));\n\n" +
                        "    // Write the file to the specified location\n" +
                        "    Files.write(filePath, file.getBytes());\n\n" +
                        "    return \"File saved to local folder successfully: \" + file.getOriginalFilename();\n" +
                        "}\n\n" +

                        "public String uploadMultipleFiles(MultipartFile[] files, String folderName) throws IOException {\n\n" +
                        "    // Validate folder name\n" +
                        "    if (folderName == null || folderName.trim().isEmpty()) {\n" +
                        "        return \"Failed: Folder name is mandatory.\";\n" +
                        "    }\n\n" +
                        "    // Construct the actual path where the files will be stored\n" +
                        "    String actualPath = UPLOAD_PATH + folderName + \"/\";\n" +
                        "    Path folderPath = Paths.get(actualPath);\n\n" +
                        "    // Ensure the folder exists, if not create it\n" +
                        "    if (!Files.exists(folderPath)) {\n" +
                        "        Files.createDirectories(folderPath);\n" +
                        "    }\n\n" +
                        "    StringBuilder result = new StringBuilder();\n\n" +
                        "    // Loop through each file and upload it\n" +
                        "    for (MultipartFile file : files) {\n\n" +
                        "        // Validate the file\n" +
                        "        if (file.isEmpty()) {\n" +
                        "            result.append(\"Failed: No file uploaded for one of the files.\\n\");\n" +
                        "            continue;\n" +
                        "        }\n\n" +
                        "        if (file.getSize() > MAX_FILE_SIZE) {\n" +
                        "            result.append(\"Failed: File size exceeds the maximum allowed size of 3MB for file: \")\n" +
                        "                  .append(file.getOriginalFilename())\n" +
                        "                  .append(\"\\n\");\n" +
                        "            continue;\n" +
                        "        }\n\n" +
                        "        // Handle the file path\n" +
                        "        Path filePath = folderPath.resolve(Objects.requireNonNull(file.getOriginalFilename()));\n\n" +
                        "        // Write the file to the specified location\n" +
                        "        Files.write(filePath, file.getBytes());\n\n" +
                        "        result.append(\"File saved successfully: \").append(file.getOriginalFilename()).append(\"\\n\");\n" +
                        "    }\n\n" +
                        "    return result.toString();\n" +
                        "}\n";

}
