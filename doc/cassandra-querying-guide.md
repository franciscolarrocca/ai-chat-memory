# Cassandra Querying

Commands to explore and query the `ai_chat_memory_keyspace` database using `cqlsh`.

### 1. Access to the cassandra container:

```bash
docker exec -it cassandra cqlsh -u test -p test
```

### 2. To explore keyspaces

List all available keyspaces
```bash
DESCRIBE KEYSPACES;
```

```bash
USE ai_chat_memory_keyspace;
```

### 3. Explore Tables

List all tables in the keyspace
```bash
DESCRIBE TABLES;
```

View the schema of the ai_chat_memory table
```bash
DESCRIBE TABLE ai_chat_memory;
```

### 4. Query Messages

Retrieve messages stored in the table
```bash
SELECT messages FROM ai_chat_memory_keyspace.ai_chat_memory;
```
