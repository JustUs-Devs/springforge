
package com.justusdev.springforge.utils_module.templates.exception;

public class GlobalExceptionTemplate {

        public static final String GLOBAL_EXCEPTION_CLASS =
                "package {packageName};\n\n" +
                "import lombok.AllArgsConstructor;\n" +
                        "import lombok.Data;\n" +
                        "import java.time.LocalDateTime;\n" +
                        "import org.springframework.http.HttpStatus;\n" +
                        "\n" +
                        "@Data\n" +
                        "@AllArgsConstructor\n" +
                        "public class GlobalException extends RuntimeException {\n" +
                        "\n" +
                        "    private final String message;\n" +
                        "    private final HttpStatus httpStatus;\n" +
                        "    private final int errorCode;\n" +
                        "    private final LocalDateTime timestamp;\n" +
                        "    private final String additionalDetails;\n" +
                        "\n" +
                        "    public GlobalException(String message, HttpStatus httpStatus, int errorCode) {\n" +
                        "        this(message, httpStatus, errorCode, LocalDateTime.now(), null);\n" +
                        "    }\n" +
                        "\n" +
                        "    public GlobalException(String message, HttpStatus httpStatus, int errorCode, String additionalDetails) {\n" +
                        "        this(message, httpStatus, errorCode, LocalDateTime.now(), additionalDetails);\n" +
                        "    }\n" +
                        "\n" +
                        "    public GlobalException(String message, Throwable cause, HttpStatus httpStatus, int errorCode) {\n" +
                        "        super(cause);\n" +
                        "        this.message = message;\n" +
                        "        this.httpStatus = httpStatus;\n" +
                        "        this.errorCode = errorCode;\n" +
                        "        this.timestamp = LocalDateTime.now();\n" +
                        "        this.additionalDetails = null;\n" +
                        "    }\n" +
                        "}\n";


}
