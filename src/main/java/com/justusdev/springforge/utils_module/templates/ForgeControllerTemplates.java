package com.justusdev.springforge.utils_module.templates;

public class ForgeControllerTemplates {

    public static final String CONTROLLER_METHODS =
            "import {packageName}.model.dto.{ModelName}Dto;\n" +
                    "import {packageName}.model.entity.{ModelName}Entity;\n" +
                    "import {packageName}.services.{ModelName}Service;\n" +
                    "import {packageName}.utils.exceptions.GlobalException;\n" + // Added GlobalException import
                    "import org.springframework.http.HttpStatus;\n" +
                    "import org.springframework.http.ResponseEntity;\n" +
                    "import org.springframework.web.bind.annotation.*;\n" +
                    "import org.springframework.beans.factory.annotation.Autowired;\n" +
                    "import lombok.RequiredArgsConstructor;\n" +
                    "import java.util.List;\n" +
                    "\n" +
                    "@RequiredArgsConstructor\n" +
                    "@RestController\n" +
                    "@CrossOrigin\n" +
                    "@RequestMapping(\"/api/v1/{modelNameLower}\")\n" +
                    "public class {ModelName}Controller {\n" +
                    "\n" +
                    "    @Autowired\n" +
                    "    private final {ModelName}Service {modelNameLower}Service;\n" +
                    "\n" +
                    "    @GetMapping\n" +
                    "    public ResponseEntity<List<{ModelName}Dto>> getAll(@RequestParam(defaultValue = \"0\") int page,\n" +
                    "        @RequestParam(defaultValue = \"10\") int size) {\n" +
                    "        try {\n" +
                    "            return ResponseEntity.ok({modelNameLower}Service.getAll(page, size));\n" +
                    "        } catch (Exception e) {\n" +
                    "            throw new GlobalException(\"Error retrieving data\", HttpStatus.INTERNAL_SERVER_ERROR, 1001);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    @GetMapping(\"/{id}\")\n" +
                    "    public ResponseEntity<{ModelName}Dto> getById(@PathVariable Long id) {\n" +
                    "        try {\n" +
                    "            return ResponseEntity.ok({modelNameLower}Service.getById(id));\n" +
                    "        } catch (GlobalException e) {\n" + // Handle GlobalException separately
                    "            throw e;\n" + // Re-throw GlobalException
                    "        } catch (Exception e) {\n" +
                    "            throw new GlobalException(\"Error retrieving record with ID: \" + id, HttpStatus.NOT_FOUND, 1002);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    @PostMapping\n" +
                    "    public ResponseEntity<String> create(@RequestBody {ModelName}Entity model) {\n" +
                    "        try {\n" +
                    "            {modelNameLower}Service.create(model);\n" +
                    "            return ResponseEntity.ok(\"Created Successfully\");\n" +
                    "        } catch (Exception e) {\n" +
                    "            throw new GlobalException(\"Error creating {ModelName}\", HttpStatus.BAD_REQUEST, 1003);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    @PutMapping(\"/{id}\")\n" +
                    "    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody {ModelName}Entity model) {\n" +
                    "        try {\n" +
                    "            {modelNameLower}Service.update(id, model);\n" +
                    "            return ResponseEntity.ok(\"Updated Successfully\");\n" +
                    "        } catch (GlobalException e) {\n" + // Handle GlobalException separately
                    "            throw e;\n" + // Re-throw GlobalException
                    "        } catch (Exception e) {\n" +
                    "            throw new GlobalException(\"Error updating {ModelName} with ID: \" + id, HttpStatus.BAD_REQUEST, 1004);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    @DeleteMapping(\"/{id}\")\n" +
                    "    public ResponseEntity<String> delete(@PathVariable Long id) {\n" +
                    "        try {\n" +
                    "            {modelNameLower}Service.delete(id);\n" +
                    "            return ResponseEntity.ok(\"Deleted Successfully\");\n" +
                    "        } catch (GlobalException e) {\n" + // Handle GlobalException separately
                    "            throw e;\n" + // Re-throw GlobalException
                    "        } catch (Exception e) {\n" +
                    "            throw new GlobalException(\"Error deleting {ModelName} with ID: \" + id, HttpStatus.NOT_FOUND, 1005);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n";
}
