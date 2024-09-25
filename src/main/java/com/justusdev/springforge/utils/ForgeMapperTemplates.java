package com.justusdev.springforge.utils;

public class ForgeMapperTemplates {

    public static final String MAPPER_TEMPLATE =
                    "import {packageName}.model.dto.{ModelName}Dto;\n" +
                    "import org.apache.ibatis.annotations.Mapper;\n" +
                    "import org.apache.ibatis.annotations.Param;\n" +
                    "import java.util.List;\n" +
                    "\n" +
                    "@Mapper\n" +
                    "public interface {ModelName}Mapper {\n" +
                    "\n" +
                    "    List<{ModelName}Dto> getAll();\n" +
                    "\n" +
                    "    {ModelName}Dto getById(@Param(\"{modelNameLower}Id\") Long id);\n" +
                    "}\n";

}
