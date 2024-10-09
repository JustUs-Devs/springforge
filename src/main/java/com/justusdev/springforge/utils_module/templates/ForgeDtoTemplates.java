package com.justusdev.springforge.utils_module.templates;

public class ForgeDtoTemplates {

    public static final String DTO_TEMPLATE =
            "package {packageName}.model.dto;\n\n" +
                    "import lombok.Data;\n" +
                    "import lombok.NoArgsConstructor;\n" +
                    "import {packageName}.model.entity.{ModelName}Entity;\n" +
                    "import java.util.Date;\n\n" +

                    "@Data\n" +
                    "@NoArgsConstructor\n" +
                    "public class {ModelName}Dto {\n" +

                    "    private Long id;\n\n" +

                    "    public {ModelName}Entity toEntity() {\n" +
                    "        return {ModelName}Entity.builder().dto(this).build();\n" +
                    "    }\n" +
                    "}\n";
}
