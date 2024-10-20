package com.Zosh.projectmanagementsystem.service;

import com.Zosh.projectmanagementsystem.model.Chat;
import com.Zosh.projectmanagementsystem.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{
    private ChatRepository chatRepository;
    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }
}
