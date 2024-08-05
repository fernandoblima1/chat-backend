package com.fernandoblima1.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
  private MessageType type;
  private String content;
  private String sender;
  private String timestamp;

  public enum MessageType {
    CHAT, LEAVE, JOIN
  }
}
