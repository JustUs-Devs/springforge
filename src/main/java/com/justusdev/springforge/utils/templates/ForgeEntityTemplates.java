package com.justusdev.springforge.utils.templates;

public class ForgeEntityTemplates {

    public static final String ENTITY_TEMPLATE =
            "package {packageName}.model.entity;\n\n" +
                    "import {packageName}.model.dto.{ModelName}Dto;\n" +
                    "import jakarta.persistence.*;\n" +
                    "import lombok.AllArgsConstructor;\n" +
                    "import lombok.Builder;\n" +
                    "import lombok.Data;\n" +
                    "import lombok.NoArgsConstructor;\n" +
                    "import java.util.Date;\n\n" +

                    "@Entity\n" +
                    "@EqualsAndHashCode(callSuper = true)\n" +
                    "@Data\n" +
                    "@NoArgsConstructor\n" +
                    "@AllArgsConstructor\n" +
                    "@EntityListeners(EntityListeners.class)\n" +
                    "@Table(name = \"{tableName}\")\n" +
                    "public class {ModelName}Entity extends BaseEntity {\n\n" +  // Extend Auditable

                    "    @Id\n" +
                    "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n" +
                    "    private Long id;\n\n" +

                    "    @Builder\n" +
                    "    public {ModelName}Entity({ModelName}Dto dto) {\n" +
                    "        super();\n" +  // Call to Auditable constructor if needed
                    "        this.id = dto.getId();\n" +
                    "    }\n" +
                    "}\n";
}
