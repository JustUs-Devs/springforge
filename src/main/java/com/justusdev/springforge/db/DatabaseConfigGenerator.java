package com.justusdev.springforge.db;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class DatabaseConfigGenerator {

    public void readProperties(String propertiesPath, String dbType) throws FileNotFoundException {

        Properties properties = new Properties();

        // Load properties from the properties file
        try (InputStream input = new FileInputStream(propertiesPath)) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading properties file1: " + e.getMessage());
            return;
        }

        switch (dbType.toLowerCase()) {
            case "mysql":
                setMysqlProperties(propertiesPath);
                break;
            case "postgres":
                setPostgresProperties(propertiesPath);
                break;
            case "oracle":
                setOracleProperties(propertiesPath);
                break;
            default:
                System.out.println("The supported database is: Mysql, Postgres, Oracle");
                break;
        }

    }


    private static Properties loadProperties(String path) throws FileNotFoundException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
        return properties;
    }

    private static void addPropertyIfNotExists(Properties properties, String key, String value) {
        if (!properties.containsKey(key) || !properties.getProperty(key).equals(value)) {
            properties.setProperty(key, value);
            System.out.println("Added or updated property: " + key + " = " + value);
        } else {
            System.out.println("Property already exists with the same value: " + key + " = " + value);
        }
    }

    private static void writePropertiesToFile(Properties properties, String path) {
        try (OutputStream output = new FileOutputStream(path)) {
            properties.store(output, "Updated properties file with new entries");
            System.out.println("Successfully updated properties file.");
        } catch (IOException e) {
            System.err.println("Error while updating properties file: " + e.getMessage());
        }
    }


    public static void setMysqlProperties(String path) throws FileNotFoundException {
        Properties properties = loadProperties(path);

        // Add MySQL properties only if they don't exist
        addPropertyIfNotExists(properties, "spring.datasource.url", "jdbc:mysql://localhost:3306/your_database_name");
        addPropertyIfNotExists(properties, "spring.datasource.username", "your_username");
        addPropertyIfNotExists(properties, "spring.datasource.password", "your_password");
        addPropertyIfNotExists(properties, "spring.datasource.driver-class-name", "com.mysql.cj.jdbc.Driver");
        addPropertyIfNotExists(properties, "spring.jpa.hibernate.ddl-auto", "update");
        addPropertyIfNotExists(properties, "spring.jpa.show-sql", "true");
        addPropertyIfNotExists(properties, "spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        writePropertiesToFile(properties, path);
    }

    public static void setPostgresProperties(String path) throws FileNotFoundException {
        Properties properties = loadProperties(path);

        // Add PostgreSQL properties only if they don't exist
        addPropertyIfNotExists(properties, "spring.datasource.url", "jdbc:postgresql://localhost:5432/your_database_name");
        addPropertyIfNotExists(properties, "spring.datasource.username", "your_username");
        addPropertyIfNotExists(properties, "spring.datasource.password", "your_password");
        addPropertyIfNotExists(properties, "spring.datasource.initialization-mode", "always");
        addPropertyIfNotExists(properties, "spring.datasource.initialize", "true");
        addPropertyIfNotExists(properties, "spring.datasource.schema", "classpath:/schema.sql");
        addPropertyIfNotExists(properties, "spring.datasource.continue-on-error", "true");
        addPropertyIfNotExists(properties, "spring.jpa.hibernate.ddl-auto", "none");
        addPropertyIfNotExists(properties, "spring.jpa.show-sql", "true");
        addPropertyIfNotExists(properties, "spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        writePropertiesToFile(properties, path);
    }

    public static void setOracleProperties(String path) throws FileNotFoundException {
        Properties properties = loadProperties(path);

        // Add Oracle properties only if they don't exist
        addPropertyIfNotExists(properties, "spring.datasource.url", "jdbc:oracle:thin:@localhost:1521:your_database_name");
        addPropertyIfNotExists(properties, "spring.datasource.username", "your_username");
        addPropertyIfNotExists(properties, "spring.datasource.password", "your_password");
        addPropertyIfNotExists(properties, "spring.datasource.driver-class-name", "oracle.jdbc.OracleDriver");
        addPropertyIfNotExists(properties, "spring.jpa.hibernate.ddl-auto", "update");
        addPropertyIfNotExists(properties, "spring.jpa.show-sql", "true");
        addPropertyIfNotExists(properties, "spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

        writePropertiesToFile(properties, path);
    }


}
