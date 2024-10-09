package com.justusdev.springforge.pom_module;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PomDependencyManager {

    public void addDependencies(String baseDirectory) {
        String pomFilePath = baseDirectory + "/pom.xml";
        String gradleFilePath = baseDirectory + "/build.gradle";
        File pomFile = new File(pomFilePath);
        File gradleFile = new File(gradleFilePath);

        if (pomFile.exists()) {
            updateMavenDependencies(pomFile);
        } else if (gradleFile.exists()) {
            updateGradleDependencies(gradleFile);
        } else {
            System.err.println("Error: No build configuration file found (pom.xml or build.gradle).");
        }
    }

    private void updateMavenDependencies(File pomFile) {
        try {
            List<String> lines = Files.readAllLines(pomFile.toPath());
            StringBuilder newPomContent = new StringBuilder();
            Set<String> existingDependencies = new HashSet<>();
            boolean dependenciesSectionFound = false;

            for (String line : lines) {
                newPomContent.append(line).append(System.lineSeparator());

                if (line.contains("<dependencies>")) {
                    dependenciesSectionFound = true;
                }

                if (dependenciesSectionFound && line.contains("<dependency>")) {
                    existingDependencies.add(line.trim());
                }

                if (dependenciesSectionFound && line.contains("</dependencies>")) {
                    addNewMavenDependencies(existingDependencies, newPomContent, pomFile);
                }
            }

            if (!dependenciesSectionFound) {
                int index = newPomContent.lastIndexOf("<properties>");
                newPomContent.insert(index, "\n<dependencies>\n");
                addNewMavenDependencies(existingDependencies, newPomContent, pomFile);
                newPomContent.append("</dependencies>\n");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pomFile))) {
                writer.write(newPomContent.toString());
            }

            System.out.println("Successfully updated pom.xml with necessary dependencies.");
        } catch (IOException e) {
            System.err.println("Error updating pom.xml: " + e.getMessage());
        }
    }
    private void updateMavenDependenciesWithDatabase(File pomFile) {
        try {
            List<String> lines = Files.readAllLines(pomFile.toPath());
            StringBuilder newPomContent = new StringBuilder();
            Set<String> existingDependencies = new HashSet<>();
            boolean dependenciesSectionFound = false;

            for (String line : lines) {
                newPomContent.append(line).append(System.lineSeparator());

                if (line.contains("<dependencies>")) {
                    dependenciesSectionFound = true;
                }

                if (dependenciesSectionFound && line.contains("<dependency>")) {
                    existingDependencies.add(line.trim());
                }

                if (dependenciesSectionFound && line.contains("</dependencies>")) {
                    addNewMavenDependencies(existingDependencies, newPomContent, pomFile);
                }
            }

            if (!dependenciesSectionFound) {
                int index = newPomContent.lastIndexOf("<properties>");
                newPomContent.insert(index, "\n<dependencies>\n");
                addNewMavenDependencies(existingDependencies, newPomContent, pomFile);
                newPomContent.append("</dependencies>\n");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pomFile))) {
                writer.write(newPomContent.toString());
            }

            System.out.println("Successfully updated pom.xml with necessary dependencies.");
        } catch (IOException e) {
            System.err.println("Error updating pom.xml: " + e.getMessage());
        }
    }

    private void addNewMavenDependencies(Set<String> existingDependencies, StringBuilder newPomContent, File pomFile) throws IOException {
        checkAndAddDependency(pomFile, newPomContent, "org.springframework.boot", "spring-boot-starter-data-jpa");
        checkAndAddDependency(pomFile, newPomContent, "org.projectlombok", "lombok");
        checkAndAddDependency(pomFile, newPomContent, "org.springframework.boot", "spring-boot-starter-web");
        checkAndAddDependency(pomFile, newPomContent, "org.springframework.boot", "spring-boot-starter-actuator");
        checkAndAddDependency(pomFile, newPomContent, "org.mybatis.spring.boot", "mybatis-spring-boot-starter");
    }

    private void addNewDatabaseMavenDependencies(Set<String> existingDependencies, StringBuilder newPomContent,
                                                 File pomFile, String dbType) throws IOException {

        switch (dbType.toLowerCase()) {
            case "mysql":
                checkAndAddDependency(pomFile, newPomContent, "mysql", "mysql-connector-java");
                break;
            case "postgres":
                checkAndAddDependency(pomFile, newPomContent, "org.postgresql", "postgresql");
                break;
            case "oracle":
                checkAndAddDependency(pomFile, newPomContent, "com.oracle.database.jdbc", "ojdbc8");
                break;
            default:
                System.out.println("Database Type not found.");
        }

    }

        private void checkAndAddDependency(File pomFile, StringBuilder newPomContent, String groupId, String artifactId) throws IOException {
            if (!dependencyExists(pomFile, groupId, artifactId)) {
                addDependency(newPomContent, groupId, artifactId);
            } else {
                System.out.println("Dependency already exists: " + groupId + ":" + artifactId);
            }
        }

        private boolean dependencyExists(File pomFile, String groupId, String artifactId) {
            return containsDependency(pomFile.getAbsolutePath(), groupId, artifactId);
        }

        public static boolean containsDependency(String pomFilePath, String groupId, String artifactId) {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new File(pomFilePath));

                // Normalize the XML structure
                document.getDocumentElement().normalize();

                // Get all <dependency> elements
                NodeList dependencyList = document.getElementsByTagName("dependency");

                for (int i = 0; i < dependencyList.getLength(); i++) {
                    Node dependencyNode = dependencyList.item(i);

                    if (dependencyNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element dependencyElement = (Element) dependencyNode;

                        String currentGroupId = getChildValue(dependencyElement, "groupId");
                        String currentArtifactId = getChildValue(dependencyElement, "artifactId");

                        // Check if the groupId and artifactId match
                        if (groupId.equals(currentGroupId) && artifactId.equals(currentArtifactId)) {
                            return true; // Dependency found
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false; // Dependency not found
        }

        private static String getChildValue(Element parent, String tagName) {
            NodeList nodeList = parent.getElementsByTagName(tagName);
            if (nodeList.getLength() > 0) {
                Node node = nodeList.item(0);
                return node.getTextContent();
            }
            return null;
        }

        private void addDependency(StringBuilder newPomContent, String groupId, String artifactId) {
            String version = groupId.equals("org.mybatis.spring.boot") ? "3.0.3" : null;
            StringBuilder dependencyBuilder = new StringBuilder();

            dependencyBuilder.append("\t<dependency>\n")
                    .append("\t\t<groupId>").append(groupId).append("</groupId>\n")
                    .append("\t\t<artifactId>").append(artifactId).append("</artifactId>\n");

            if (version != null) {
                dependencyBuilder.append("\t\t<version>").append(version).append("</version>\n");
            }

            dependencyBuilder.append("\t</dependency>");

            newPomContent.insert(newPomContent.lastIndexOf("</dependencies>"), "\n" + dependencyBuilder + "\n");
        }



    private void updateGradleDependencies(File gradleFile) {
        try {
            List<String> lines = Files.readAllLines(gradleFile.toPath());
            Set<String> existingDependencies = new HashSet<>();
            StringBuilder newGradleContent = new StringBuilder();

            for (String line : lines) {
                newGradleContent.append(line).append(System.lineSeparator());

                if (line.contains("implementation") || line.contains("compile")) {
                    existingDependencies.add(line.trim());
                }
            }

            addNewGradleDependencies(existingDependencies, newGradleContent);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(gradleFile))) {
                writer.write(newGradleContent.toString());
            }

            System.out.println("Successfully updated build.gradle with necessary dependencies.");
        } catch (IOException e) {
            System.err.println("Error updating build.gradle: " + e.getMessage());
        }
    }

    private void addNewGradleDependencies(Set<String> existingDependencies, StringBuilder newGradleContent) {
        addGradleDependencyIfNotExists(existingDependencies, newGradleContent, "org.springframework.boot", "spring-boot-starter-data-jpa");
        addGradleDependencyIfNotExists(existingDependencies, newGradleContent, "org.projectlombok", "lombok");
        addGradleDependencyIfNotExists(existingDependencies, newGradleContent, "org.springframework.boot", "spring-boot-starter-web");
        addGradleDependencyIfNotExists(existingDependencies, newGradleContent, "org.springframework.boot", "spring-boot-starter-actuator");
    }

    private void addGradleDependencyIfNotExists(Set<String> existingDependencies, StringBuilder newGradleContent,
                                                String groupId, String artifactId) {
        String dependency = String.format("implementation '%s:%s'", groupId, artifactId).trim();

        // Normalize for comparison
        if (!existingDependencies.contains(dependency)) {
            newGradleContent.append("    ").append(dependency).append(System.lineSeparator());
        }
    }
}
