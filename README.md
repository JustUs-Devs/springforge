Sure! Here’s a fully formatted README.md using Markdown, following GitHub standards.

```markdown
# SpringForge

![SpringForge Logo](link_to_your_logo_image) <!-- Optional: Add a logo -->

**SpringForge** is a command-line library designed to simplify the creation of REST APIs using N-Tier Architecture in Spring Boot applications. By automating project setup and file generation, SpringForge allows developers to focus on building features rather than repetitive configuration tasks.

---

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Commands](#commands)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

---

## Features

- **N-Tier Architecture Support**: Encourages clean separation of concerns with distinct layers:
  - **Presentation Layer**: Handles HTTP requests (Controllers).
  - **Business Logic Layer**: Contains services.
  - **Data Access Layer**: Manages repositories.
  - **Model Layer**: Defines entities and DTOs.

- **Automated Directory Structure Initialization**: Creates a standardized folder structure upon initialization:

  ```plaintext
  ├── controller
  ├── service
  ├── repository
  ├── model
  │   ├── entity
  │   └── dto
  ├── utils
      ├── exceptions
      └── response
  ```

- **Generic File Creation**: Allows users to create multiple file types with a single command:
  - **Create-All Command**: Generates controller, service, repository, DTO, and entity files for a specified model.
  
  ```bash
  java -jar springforge.jar create-all User
  ```

- **Dependency Management**: Automatically updates the `pom.xml` file to include essential dependencies:
  - **Spring Boot Starter Web**
  - **Spring Boot Starter Data JPA**
  - **MySQL Connector**

- **Command-Line Interface**: Simple command structure for easy usage:
  - `init`: Initializes the project structure and updates `pom.xml`.
  - `create-all <ModelName>`: Generates all necessary files for a specified model.

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/springforge.git
   cd springforge
   ```

2. Build the project using Maven:
   ```bash
   mvn clean package
   ```

3. Run the application to initialize your project:
   ```bash
   java -jar target/springforge-0.0.1-SNAPSHOT.jar init
   ```

---

## Usage

### Initialize the Project

Run the following command to create the basic directory structure:

```bash
java -jar target/springforge-0.0.1-SNAPSHOT.jar init
```

### Create a New Model with All Files

To generate all necessary files for a new model, use:

```bash
java -jar target/springforge-0.0.1-SNAPSHOT.jar create-all User
```

This command will generate:
- `UserController.java`
- `UserService.java`
- `UserRepository.java`
- `UserEntity.java`
- `UserDTO.java`

---

## Commands

| Command                     | Description                                               |
|-----------------------------|-----------------------------------------------------------|
| `init`                      | Initializes the project structure and updates `pom.xml`. |
| `create-all <ModelName>`    | Generates all necessary files for the specified model.    |

---

## Contributing

Contributions are welcome! If you have suggestions or improvements, please fork the repository and submit a pull request.

1. Fork the repository
2. Create a new branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a pull request

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Acknowledgements

- Thanks to the Spring Boot community for providing the foundation for this project.
- Inspired by various open-source tools aimed at improving developer productivity.

---

For more information, feel free to reach out or check out the documentation.
```

### Key Points:
- **Markdown Formatting**: Proper use of headings, lists, code blocks, and tables for clarity.
- **Section Dividers**: Use of horizontal rules (`---`) for visual separation of sections.
- **Optional Logo**: Placeholder for a logo image to enhance branding.

Feel free to update the logo link, your GitHub username, and any other specific details. Let me know if you need any further modifications!
