package com.Zosh.projectmanagementsystem.controller;

import com.Zosh.projectmanagementsystem.model.Chat;
import com.Zosh.projectmanagementsystem.model.Message;
import com.Zosh.projectmanagementsystem.model.User;
import com.Zosh.projectmanagementsystem.request.CreateMessageRequest;
import com.Zosh.projectmanagementsystem.service.MessageService;
import com.Zosh.projectmanagementsystem.service.ProjectService;
import com.Zosh.projectmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController  {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request)
        throws  Exception{
        User user = userService.findUserById(request.getSenderId());
        Chat chats = projectService.getProjectById(request.getProjectId()).getChat();
        if(chats==null) throw  new Exception("chats not found");
        Message sentMessage = messageService.sendMessage(request.getSenderId(), request.getProjectId(), request.getContent());
        return  ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/chat/ {projectId}")
    public ResponseEntity<List<Message>> getMessagesByChatId(@PathVariable Long projectId)
        throws Exception{
        List<Message> messages =messageService.getMessageByProjectId(projectId);
        return  ResponseEntity.ok(messages);
    }
}
