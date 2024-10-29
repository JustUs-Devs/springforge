#!/bin/bash
# springforge.sh - SpringForge CLI wrapper script

JAR_URL="https://github.com/JustUs-Devs/springforge/releases/download/v0.1.0/springforge.jar"
JAR_FILE="springforge.jar"

# Check if the JAR file already exists; if not, download it
if [ ! -f "$JAR_FILE" ]; then
    echo "Downloading SpringForge JAR..."
    curl -L -o "$JAR_FILE" "$JAR_URL"
fi

# Execute the JAR file with all provided arguments
java -jar "$JAR_FILE" "$@"
