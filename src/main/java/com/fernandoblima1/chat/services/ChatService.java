package com.fernandoblima1.chat.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fernandoblima1.chat.domain.ChatMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

  private final RabbitTemplate rabbitTemplate;

  public void sendMessage(ChatMessage chatMessage) {
    rabbitTemplate.convertAndSend("chatQueue", chatMessage);
  }
}
