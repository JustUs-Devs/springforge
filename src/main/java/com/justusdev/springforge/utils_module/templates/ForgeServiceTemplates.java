package com.justusdev.springforge.utils_module.templates;

public class ForgeServiceTemplates {

    public static final String SERVICE_TEMPLATE =
                    "import {packageName}.model.dto.{ModelName}Dto;\n" +
                    "import {packageName}.repositories.{ModelName}Repository;\n" +
                    "import {packageName}.mappers.{ModelName}Mapper;\n" +
                    "import {packageName}.model.entity.{ModelName}Entity;\n" +
                    "import org.springframework.beans.factory.annotation.Autowired;\n" +
                    "import lombok.RequiredArgsConstructor;\n" +
                    "import org.springframework.stereotype.Service;\n" +
                    "\n" +
                    "import java.io.IOException;\n" +
                    "import java.util.List;\n" +
                    "\n" +
                    "@Service\n" +
                    "@RequiredArgsConstructor\n" +
                    "public class {ModelName}Service {\n" +
                    "\n" +
                    "    @Autowired\n" +
                    "    private final {ModelName}Mapper {modelNameLower}Mapper;\n" +
                    "\n" +
                    "    @Autowired\n" +
                    "    private final {ModelName}Repository {modelNameLower}Repository;\n" +
                    "\n" +
                    "    public List<{ModelName}Dto> getAll() {\n" +
                    "        // Logic to retrieve all {ModelName}\n" +
                    "        return {modelNameLower}Mapper.getAll();\n" +
                    "    }\n" +
                    "\n" +
                    "    public {ModelName}Dto getById(Long id) {\n" +
                    "        // Logic to retrieve a {ModelName} by ID\n" +
                    "        return {modelNameLower}Mapper.getById(id);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void create({ModelName}Entity {modelNameLower}) {\n" +
                    "        // Logic to create a new {ModelName}\n" +
                    "        {modelNameLower}Repository.save({modelNameLower});\n" +
                    "    }\n" +
                    "\n" +
                    "    public void update(Long id, {ModelName}Entity {modelNameLower}) {\n" +
                    "        // Logic to update an existing {ModelName}\n" +
                    "    }\n" +
                    "\n" +
                    "    public void delete(Long id) {\n" +
                    "        // Logic to delete a {ModelName}\n" +
                    "        {modelNameLower}Repository.deleteById(id);\n" +
                    "    }\n" +
                    "}\n";
}
