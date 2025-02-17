package com.example.AnAn_Chinese.Controller;

import com.example.AnAn_Chinese.DAO.GrammarDAO;
import com.example.AnAn_Chinese.Entity.Conversation;
import com.example.AnAn_Chinese.Entity.Grammar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grammar")
public class GrammarController {

    @Autowired
    private GrammarDAO grammarDAO;

    @GetMapping
    public List<Grammar> getAllGrammars() {
        return grammarDAO.getAllGrammars();
    }

    @GetMapping("/{id}")
    public Grammar getGrammarById(@PathVariable Integer id) {
        return grammarDAO.getGrammarById(id);
    }
    @GetMapping("/lesson/{id}")
    public List<Grammar> getListGrammarByLessonId(@PathVariable Integer id) {
        return grammarDAO.getListGrammarByLessonId(id);
    }
    @PostMapping
    public Grammar createGrammar(@RequestBody Grammar grammar) {
        return grammarDAO.createGrammar(grammar);
    }

    @PutMapping("/{id}")
    public Grammar updateGrammar(@PathVariable Integer id, @RequestBody Grammar updatedGrammar) {
        return grammarDAO.updateGrammar(id, updatedGrammar);
    }

    @DeleteMapping("/{id}")
    public void deleteGrammar(@PathVariable Integer id) {
        grammarDAO.deleteGrammar(id);
    }
}
