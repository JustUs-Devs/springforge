package com.justusdev.springforge.utils_module.templates;

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
                    "    @Select(\"SELECT * FROM your_table LIMIT #{limit} OFFSET #{offset}\")\n" +
                    "    List<{ModelName}Dto> getAll(@Param(\"offset\") int offset, @Param(\"limit\") int limit);\n" +
                    "\n" +
                    "    @Select(\"SELECT * FROM your_table WHERE id = #{id}\")\n" +
                    "    {ModelName}Dto getById(@Param(\"id\") Long id);\n" +
                    "}\n";


}
