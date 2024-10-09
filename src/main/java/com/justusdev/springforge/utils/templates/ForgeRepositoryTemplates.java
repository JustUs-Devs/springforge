package com.justusdev.springforge.utils.templates;

public class ForgeRepositoryTemplates {

    public static final String REPOSITORY_TEMPLATE =
            "import {packageName}.model.entity.{ModelName}Entity;\n" +
                    "import org.springframework.data.jpa.repository.JpaRepository;\n" +
                    "import org.springframework.stereotype.Repository;\n" +
                    "\n" +
                    "@Repository\n" +
                    "public interface {ModelName}Repository extends JpaRepository<{ModelName}Entity, Long> {\n" +
                    "    // Custom query methods can be defined here if needed\n" +
                    "}\n";
}
