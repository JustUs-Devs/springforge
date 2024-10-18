package com.justusdev.springforge.utils_module.templates.exception;


public class ExceptionModelTemplate {

    public static final String EXCEPTION_MODEL_CLASS =
            "package {packageName};\n\n" +
            "\n" +
            "import lombok.AllArgsConstructor;\n" +
                    "import lombok.Data;\n" +
                    "import java.time.LocalDateTime;\n" +
                    "import org.springframework.http.HttpStatus;\n" +
                    "\n" +
                    "@Data\n" +
                    "@AllArgsConstructor\n" +
                    "public class ExceptionModel {\n" +
                    "    private final String message;\n" +
                    "    private final HttpStatus httpStatus;\n" +
                    "    private final int errorCode;\n" +
                    "    private final LocalDateTime timestamp;\n" +
                    "    private final String additionalDetails;\n" +
                    "}\n";
}
