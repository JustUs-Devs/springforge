package com.justusdev.springforge.files;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class PomChecker {

    public static boolean containsDependency(String pomFilePath, String groupId, String artifactId) {
        try {
            // Parse the XML file
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

    public static void main(String[] args) {
        String pomFilePath = "/Users/abdulhalim.hafidh/Documents/workspace/Personal/springforge/pom.xml";
        String groupId = "org.springframework.boot";
        String artifactId = "spring-boot-starter";

        boolean exists = containsDependency(pomFilePath, groupId, artifactId);
        System.out.println("Dependency exists: " + exists);
    }
}
