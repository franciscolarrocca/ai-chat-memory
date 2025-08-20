# AI Chat Memory POC

![banner](doc/banner.png)

POC application demonstrating AI-powered chat functionality with conversation history persistence using Spring AI and Cassandra.

## Features

- Integration with Ollama LLM
- Persistent chat history using Cassandra
- API for chat interactions

## Requirements

- Java 24
- Docker and Docker Compose

## Getting Started
Start Cassandra & Ollama using Docker Compose:

```bash
docker-compose up -d
```

Build the application:

```bash
mvn clean package
```

Run the application:

```bash
java -jar target/ai-chat-memory-0.0.1-SNAPSHOT.jar
```

## Endpoints

### Send message

```bash
curl --location 'http://localhost:8081/1/chat' \
--header 'Content-Type: application/json' \
--data '{
    "message": "Hello my name is test, how are you?"
}'
```

### Get chat history

```bash
curl --location 'http://localhost:8081/1/history'
```