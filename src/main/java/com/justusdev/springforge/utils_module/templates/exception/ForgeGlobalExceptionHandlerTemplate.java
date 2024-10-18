package com.justusdev.springforge.utils_module.templates.exception;

public class ForgeGlobalExceptionHandlerTemplate {

    public static final String GLOBAL_EXCEPTION_HANDLER =
            "package {packageName};\n\n" +
            "import org.springframework.http.ResponseEntity;\n" +
                    "import org.springframework.web.bind.annotation.ControllerAdvice;\n" +
                    "import org.springframework.web.bind.annotation.ExceptionHandler;\n" +
                    "\n" +
                    "@ControllerAdvice\n" +
                    "public class GlobalExceptionHandler {\n" +
                    "\n" +
                    "    @ExceptionHandler(value = {GlobalException.class})\n" +
                    "    public ResponseEntity<Object> handleGlobalException(GlobalException ex) {\n" +
                    "        ExceptionModel exceptionModel = new ExceptionModel(\n" +
                    "                ex.getMessage(),\n" +
                    "                ex.getHttpStatus(),\n" +
                    "                ex.getErrorCode(),\n" +
                    "                ex.getTimestamp(),\n" +
                    "                ex.getAdditionalDetails()\n" +
                    "        );\n" +
                    "        return new ResponseEntity<>(exceptionModel, ex.getHttpStatus());\n" +
                    "    }\n" +
                    "}\n";
}
