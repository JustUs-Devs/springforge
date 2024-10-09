package com.justusdev.springforge.utils_module.templates;

public class ForgeBaseEntityTemplate {

        public static final String BASE_ENTITY_TEMPLATE =
                        "import lombok.Getter;\n" +
                        "import lombok.NoArgsConstructor;\n" +
                        "import lombok.Setter;\n" +
                        "import lombok.EqualsAndHashCode;\n" +
                        "\n" +
                        "import jakarta.persistence.*;\n" +
                        "import java.time.LocalDateTime;\n" +
                        "\n" +
                        "@MappedSuperclass\n" +
                        "@Getter\n" +
                        "@Setter\n" +
                        "@NoArgsConstructor\n" +
                        "@EqualsAndHashCode\n"+
                        "public abstract class BaseEntity {\n" +
                        "\n" +
                        "    @Column(name = \"created_at\", nullable = false, updatable = false)\n" +
                        "    private LocalDateTime createdAt;\n" +
                        "\n" +
                        "    @Column(name = \"updated_at\")\n" +
                        "    private LocalDateTime updatedAt;\n" +
                        "\n" +
                        "    @Column(name = \"created_by\", nullable = false, updatable = false)\n" +
                        "    private String createdBy;\n" +
                        "\n" +
                        "    @Column(name = \"updated_by\")\n" +
                        "    private String updatedBy;\n" +
                        "\n" +
                        "    @PrePersist\n" +
                        "    protected void onCreate() {\n" +
                        "        createdAt = LocalDateTime.now();\n" +
                        "        createdBy = \"system\"; // Example; replace with actual user retrieval logic\n" +
                        "    }\n" +
                        "\n" +
                        "    @PreUpdate\n" +
                        "    protected void onUpdate() {\n" +
                        "        updatedAt = LocalDateTime.now();\n" +
                        "        updatedBy = \"system\"; // Example; replace with actual user retrieval logic\n" +
                        "    }\n" +
                        "}\n";


}
