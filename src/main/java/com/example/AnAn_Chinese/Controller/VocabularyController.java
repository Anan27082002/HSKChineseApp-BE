package com.example.AnAn_Chinese.Controller;

import com.example.AnAn_Chinese.DAO.VocabularyDAO;
import com.example.AnAn_Chinese.Entity.Vocabulary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vocabulary")
public class VocabularyController {

    @Autowired
    private VocabularyDAO vocabularyDAO;

    @GetMapping
    public List<Vocabulary> getAllVocabularies() {
        return vocabularyDAO.getAllVocabularies();
    }

    @GetMapping("/{id}")
    public Vocabulary getVocabularyById(@PathVariable Integer id) {
        return vocabularyDAO.getVocabularyById(id);
    }

    @GetMapping("/lesson/{id}")
    public List<Vocabulary> getListVocabularyByLessonId(@PathVariable Integer id) {
        return vocabularyDAO.getListVocabularyByLessonId(id);
    }

    @PostMapping
    public Vocabulary createVocabulary(@RequestBody Vocabulary vocabulary) {
        return vocabularyDAO.createVocabulary(vocabulary);
    }

    @PutMapping("/{id}")
    public Vocabulary updateVocabulary(@PathVariable Integer id, @RequestBody Vocabulary updatedVocabulary) {
        return vocabularyDAO.updateVocabulary(id, updatedVocabulary);
    }

    @DeleteMapping("/{id}")
    public void deleteVocabulary(@PathVariable Integer id) {
        vocabularyDAO.deleteVocabulary(id);
    }
}
