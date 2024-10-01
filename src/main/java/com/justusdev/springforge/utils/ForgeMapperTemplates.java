package com.justusdev.springforge.utils;

public class ForgeMapperTemplates {

    public static final String MAPPER_TEMPLATE =
            "import {packageName}.model.dto.{ModelName}Dto;\n" +
                    "import org.apache.ibatis.annotations.Mapper;\n" +
                    "import org.apache.ibatis.annotations.Param;\n" +
                    "import org.apache.ibatis.annotations.Select;\n" +
                    "import java.util.List;\n" +
                    "\n" +
                    "@Mapper\n" +
                    "public interface {ModelName}Mapper {\n" +
                    "\n" +
                    "    @Select(\"SELECT * FROM your_table\")\n" +
                    "    List<{ModelName}Dto> getAll();\n" +
                    "\n" +
                    "    @Select(\"SELECT * FROM your_table WHERE id = #{id}\")\n" +
                    "    {ModelName}Dto getById(@Param(\"id\") Long id);\n" +
                    "}\n";
}
