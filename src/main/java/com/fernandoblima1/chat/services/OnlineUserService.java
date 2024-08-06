package com.fernandoblima1.chat.services;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OnlineUserService {
  private final Map<String, String> userSessions = new ConcurrentHashMap<>();

  public void addUser(String username) {
    userSessions.put(username, username);
  }

  public void removeUser(String username) {
    userSessions.remove(username);
  }

  public Map<String, String> getOnlineUsers() {
    return userSessions;
  }
}
