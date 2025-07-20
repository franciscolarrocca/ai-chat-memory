package com.fl.app.configuration;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.repository.cassandra.CassandraChatMemoryRepository;
import org.springframework.ai.chat.memory.repository.cassandra.CassandraChatMemoryRepositoryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


@Configuration
public class ChatClientConfiguration {
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {
        return builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    @Bean
    public CassandraChatMemoryRepository cassandraChatMemory(CqlSession cqlSession) {
        return CassandraChatMemoryRepository.create(CassandraChatMemoryRepositoryConfig
                .builder()
                .withKeyspaceName("ai_chat_memory_keyspace")
                .withTimeToLive(Duration.ofDays(30))
                .withCqlSession(cqlSession)
                .build());
    }
}
