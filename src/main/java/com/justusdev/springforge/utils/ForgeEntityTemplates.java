package com.justusdev.springforge.utils;

public class ForgeEntityTemplates {

    public static final String ENTITY_TEMPLATE =
            "package {packageName}.model.entity;\n\n" +
                    "import javax.persistence.*;\n" +
                    "import lombok.*;\n" +
                    "import org.hibernate.annotations.GenericGenerator;\n" +
                    "import {packageName}.model.dto.{ModelName}Dto;\n" +
                    "import java.util.Date;\n\n" +

                    "@Entity\n" +
                    "@Data\n" +
                    "@NoArgsConstructor\n" +
                    "@AllArgsConstructor\n" +
                    "@EntityListeners(EntityListeners.class)\n" +
                    "@Table(name = \"{tableName}\")\n" +
                    "public class {ModelName}Entity {\n\n" +

                    "    @Id\n" +
                    "    @GeneratedValue(strategy = \"GenerationType.IDENTITY\")\n" +
                    "    private Long id;\n\n" +

                    "    @Builder\n" +
                    "    public {ModelName}Entity({ModelName}Dto dto) {\n" +
                    "        this.id = dto.getId();\n" +
                    "    }\n" +
                    "}\n";

}
