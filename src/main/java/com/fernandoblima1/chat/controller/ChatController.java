package com.fernandoblima1.chat.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.fernandoblima1.chat.domain.ChatMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for handling chat-related functionality.
 */

@Slf4j
@Controller
public class ChatController {
  private final Map<String, String> userSessions = new ConcurrentHashMap<>();

  @MessageMapping("/chat.register")
  @SendTo("/topic/public")
  public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
    log.info("Received registration: " + chatMessage.getSender());
    headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
    userSessions.put(headerAccessor.getSessionId(), chatMessage.getSender());

    return chatMessage;
  }

  @MessageMapping("/chat.send")
  @SendTo("/topic/public")
  public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    return chatMessage;
  }

  @MessageMapping("/chat.users")
  @SendTo("/topic/public")
  public Map<String, Object> getConnectedUsers() {
    Map<String, Object> response = new ConcurrentHashMap<>();
    response.put("type", "USERS_LIST");
    response.put("users", userSessions.values());
    return response;
  }

  public Map<String, String> getUserSessions() {
    return userSessions;
  }
}
