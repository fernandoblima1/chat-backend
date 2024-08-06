package com.fernandoblima1.chat.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.fernandoblima1.chat.controller.ChatController;
import com.fernandoblima1.chat.domain.ChatMessage;

/**
 * Handles the WebSocket disconnect event.
 * Sends a leave message to the "/topic/public" destination when a user
 * disconnects.
 *
 * param event The SessionDisconnectEvent representing the WebSocket disconnect
 * event.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

  private final SimpMessageSendingOperations messagingTemplate;
  private final ChatController chatController;

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String username = (String) headerAccessor.getSessionAttributes().get("username");
    if (username != null) {
      LocalDateTime timestamp = LocalDateTime.now();
      log.info("user disconnected: {}", username);
      var chatMessage = ChatMessage.builder()
          .type(ChatMessage.MessageType.LEAVE)
          .timestamp(String.valueOf(timestamp))
          .sender(username)
          .build();
      messagingTemplate.convertAndSend("/topic/public", chatMessage);
      chatController.getUserSessions().remove(headerAccessor.getSessionId());
    }
  }
}
