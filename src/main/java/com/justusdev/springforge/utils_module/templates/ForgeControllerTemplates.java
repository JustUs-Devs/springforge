package com.justusdev.springforge.utils_module.templates;

public class ForgeControllerTemplates {

    public static final String CONTROLLER_METHODS =
                    "import {packageName}.model.dto.{ModelName}Dto;\n" +
                    "import {packageName}.model.entity.{ModelName}Entity;\n" +
                    "import {packageName}.services.{ModelName}Service;\n" +
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
                    "    public ResponseEntity<List<{ModelName}Dto>> getAll() {\n" +
                    "        // Logic to retrieve all records\n" +
                    "        return ResponseEntity.ok({modelNameLower}Service.getAll()); // Replace with actual logic\n" +
                    "    }\n" +
                    "\n" +
                    "    @GetMapping(\"/{id}\")\n" +
                    "    public ResponseEntity<{ModelName}Dto> getById(@PathVariable Long id) {\n" +
                    "        // Logic to retrieve a record by ID\n" +
                    "        return ResponseEntity.ok({modelNameLower}Service.getById(id)); // Replace with actual logic\n" +
                    "    }\n" +
                    "\n" +
                    "    @PostMapping\n" +
                    "    public ResponseEntity<String> create(@RequestBody {ModelName}Entity model) {\n" +
                    "        // Logic to create a new record\n" +
                    "        {modelNameLower}Service.create(model);\n" +
                    "        return ResponseEntity.ok(\"Created Successfully\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @PutMapping(\"/{id}\")\n" +
                    "    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody {ModelName}Entity model) {\n" +
                    "        // Logic to update an existing record\n" +
                    "        {modelNameLower}Service.update(id, model);\n" +
                    "        return ResponseEntity.ok(\"Updated Successfully\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @DeleteMapping(\"/{id}\")\n" +
                    "    public ResponseEntity<String> delete(@PathVariable Long id) {\n" +
                    "        // Logic to delete an existing record\n" +
                    "        {modelNameLower}Service.delete(id);\n" +
                    "        return ResponseEntity.ok(\"Deleted Successfully\");\n" +
                    "    }\n" +
                    "}\n";
}
