package com.justusdev.springforge.utils_module.templates;

public class ForgeServiceTemplates {

    public static final String SERVICE_TEMPLATE =
            "import {packageName}.model.dto.{ModelName}Dto;\n" +
                    "import {packageName}.repositories.{ModelName}Repository;\n" +
                    "import {packageName}.mappers.{ModelName}Mapper;\n" +
                    "import {packageName}.model.entity.{ModelName}Entity;\n" +
                    "import {packageName}.utils.exceptions.GlobalException;\n" + // Added GlobalException import
                    "import org.springframework.beans.factory.annotation.Autowired;\n" +
                    "import lombok.RequiredArgsConstructor;\n" +
                    "import org.springframework.http.HttpStatus;\n" + // Added HttpStatus import
                    "import org.springframework.stereotype.Service;\n" +
                    "\n" +
                    "import java.io.IOException;\n" +
                    "import java.util.List;\n" +
                    "\n" +
                    "@Service\n" +
                    "@RequiredArgsConstructor\n" +
                    "public class {ModelName}Service {\n" +
                    "\n" +
                    "    private static final String NOT_FOUND_MESSAGE = \"No {ModelNameLower} with ID: \";\n" + // Added NOT_FOUND_MESSAGE constant
                    "\n" +
                    "    @Autowired\n" +
                    "    private final {ModelName}Mapper {modelNameLower}Mapper;\n" +
                    "\n" +
                    "    @Autowired\n" +
                    "    private final {ModelName}Repository {modelNameLower}Repository;\n" +
                    "\n" +
                    "    public List<{ModelName}Dto> getAll(int page, int size) {\n" +
                    "        // Logic to retrieve all {ModelName}\n" +
                    "        int pageSet = page * size;\n" +
                    "        return {modelNameLower}Mapper.getAll(pageSet, size);\n" +
                    "    }\n" +
                    "\n" +
                    "    public {ModelName}Dto getById(Long id) {\n" +
                    "        // Logic to retrieve a {ModelName} by ID\n" +
                    "        {ModelName}Entity existed{ModelName} = {modelNameLower}Mapper.getById(id) != null ? {modelNameLower}Mapper.getById(id).toEntity() : null;\n" +
                    "\n" +
                    "        if (existed{ModelName} == null) {\n" +
                    "            throw new GlobalException(NOT_FOUND_MESSAGE + id, HttpStatus.NOT_FOUND, 1002);\n" +
                    "        }\n" +
                    "\n" +
                    "        return {modelNameLower}Mapper.getById(id);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void create({ModelName}Entity {modelNameLower}) {\n" +
                    "        // Logic to create a new {ModelName}\n" +
                    "        {modelNameLower}Repository.save({modelNameLower});\n" +
                    "    }\n" +
                    "\n" +
                    "    public void update(Long id, {ModelName}Entity {modelNameLower}) {\n" +
                    "        {ModelName}Entity existed{ModelName} = {modelNameLower}Mapper.getById(id) != null ? {modelNameLower}Mapper.getById(id).toEntity() : null;\n" +
                    "\n" +
                    "        if (existed{ModelName} == null) {\n" +
                    "            throw new GlobalException(NOT_FOUND_MESSAGE + id, HttpStatus.NOT_FOUND, 1002);\n" +
                    "        }\n" +
                    "\n" +
                    "        {modelNameLower}Repository.save(existed{ModelName});\n" + // Saving updated entity
                    "    }\n" +
                    "\n" +
                    "    public void delete(Long id) {\n" +
                    "        // Logic to delete a {ModelName}\n" +
                    "        {ModelName}Entity existed{ModelName} = {modelNameLower}Mapper.getById(id) != null ? {modelNameLower}Mapper.getById(id).toEntity() : null;\n" +
                    "\n" +
                    "        if (existed{ModelName} == null) {\n" +
                    "            throw new GlobalException(NOT_FOUND_MESSAGE + id, HttpStatus.NOT_FOUND, 1002);\n" +
                    "        }\n" +
                    "\n" +
                    "        {modelNameLower}Repository.deleteById(id);\n" +
                    "    }\n" +
                    "}\n";
}
