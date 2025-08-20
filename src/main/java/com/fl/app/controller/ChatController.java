package com.fl.app.controller;

import com.fl.app.domain.ChatRequest;
import com.fl.app.service.ChatService;
import org.springframework.ai.chat.messages.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/{userId}/chat")
    public String chat(@PathVariable String userId, @RequestBody ChatRequest chatRequest) {
        return chatService.chat(userId, chatRequest.message());
    }

    @GetMapping("/{userId}/history")
    public List<Message> getHistory(@PathVariable String userId) {
        return chatService.getHistory(userId);
    }
}
