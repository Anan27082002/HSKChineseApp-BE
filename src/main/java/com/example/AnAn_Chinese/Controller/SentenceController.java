package com.example.AnAn_Chinese.Controller;

import com.example.AnAn_Chinese.DAO.SentenceDAO;
import com.example.AnAn_Chinese.Entity.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sentence")
public class SentenceController {

    @Autowired
    private SentenceDAO sentenceDAO;

    @GetMapping
    public List<Sentence> getAllSentences() {
        return sentenceDAO.getAllSentences();
    }

    @GetMapping("/{id}")
    public Sentence getSentenceById(@PathVariable Integer id) {
        return sentenceDAO.getSentenceById(id);
    }

    @GetMapping ("/conversation/{id}")
    public List<Sentence> getSentencesByConversationId(@PathVariable Integer id) {
        return sentenceDAO.getSentencesByConversationId(id);
    }

    @PostMapping
    public Sentence createSentence(@RequestBody Sentence sentence) {
        return sentenceDAO.createSentence(sentence);
    }

    @PutMapping("/{id}")
    public Sentence updateSentence(@PathVariable Integer id, @RequestBody Sentence updatedSentence) {
        return sentenceDAO.updateSentence(id, updatedSentence);
    }

    @DeleteMapping("/{id}")
    public void deleteSentence(@PathVariable Integer id) {
        sentenceDAO.deleteSentence(id);
    }
}
