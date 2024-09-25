package com.justusdev.springforge.utils;

public class ForgeControllerTemplates {

    public static final String CONTROLLER_METHODS =

                    "import org.springframework.http.HttpStatus;\n" +
                    "import org.springframework.http.ResponseEntity;\n" +
                    "import org.springframework.web.bind.annotation.*;" +
                    "import org.springframework.beans.factory.annotation.Autowired;" +
                    "import java.util.List;\n" +
                    "\n\n\n" +
                    "@RestController\n" +
                    "@CrossOrigin()\n" +
                    "@RequestMapping(\"/api/v1/{modelNameLower}\")\n" +
                    "public class {ModelName}Controller {\n" +
                    "\n" +
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
                    "    public ResponseEntity<{ModelName}Dto> create(@RequestBody {ModelName}Entity model) {\n" +
                    "        // Logic to create a new record\n" +
                    "{modelNameLower}Service.create(model);" +
                    "\n" +
                    "        return ResponseEntity.status(201).body(model); // Replace with actual logic\n" +
                    "    }\n" +
                    "\n" +
                    "    @PutMapping(\"/{id}\")\n" +
                    "    public ResponseEntity<{ModelName}Dto> update(@PathVariable Long id, @RequestBody {ModelName}Entity model) {\n" +
                    "        // Logic to update an existing record\n" +
                    "{modelNameLower}Service.update(id, model);" +
                    "\n" +
                    "        return ResponseEntity.ok(model); // Replace with actual logic\n" +
                    "    }\n" +
                    "    @DeleteMapping(\"/{id}\")\n" +
                    "    public ResponseEntity<{ModelName}Dto> delete(@PathVariable Long id) {\n" +
                    "        // Logic to delete an existing record\n" +
                    "{modelNameLower}Service.delete(id);" +
                    "\n" +
                    "        return ResponseEntity.ok(\" Deleted Successfully \"); // Replace with actual logic\n" +
                    "    }\n" +
                    "}\n";
}
