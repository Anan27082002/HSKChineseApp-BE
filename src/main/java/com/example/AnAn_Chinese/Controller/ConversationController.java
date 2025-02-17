package com.example.AnAn_Chinese.Controller;

import com.example.AnAn_Chinese.DAO.ConversationDAO;
import com.example.AnAn_Chinese.Entity.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversation")
public class ConversationController {

    @Autowired
    private ConversationDAO conversationDAO;

    @GetMapping
    public List<Conversation> getAllConversations() {
        return conversationDAO.getAllConversations();
    }

    @GetMapping("/{id}")
    public Conversation getConversationById(@PathVariable Integer id) {
        return conversationDAO.getConversationById(id);
    }
    @GetMapping("/lesson/{id}")
    public List<Conversation> getListConversationsByLessonId(@PathVariable Integer id) {
        return conversationDAO.getListConversationsByLessonId(id);
    }

    @PostMapping
    public Conversation createConversation(@RequestBody Conversation conversation) {
        return conversationDAO.createConversation(conversation);
    }

    @PutMapping("/{id}")
    public Conversation updateConversation(@PathVariable Integer id, @RequestBody Conversation updatedConversation) {
        return conversationDAO.updateConversation(id, updatedConversation);
    }

    @DeleteMapping("/{id}")
    public void deleteConversation(@PathVariable Integer id) {
        conversationDAO.deleteConversation(id);
    }
}
