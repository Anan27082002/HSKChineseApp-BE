package com.example.AnAn_Chinese.Controller;

import com.example.AnAn_Chinese.DAO.LessonProgressDAO;
import com.example.AnAn_Chinese.Entity.LessonProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson-progress")
public class LessonProgressController {

    @Autowired
    private LessonProgressDAO lessonProgressDAO;

    @GetMapping
    public List<LessonProgress> getAllLessonProgress() {
        return lessonProgressDAO.getAllLessonProgress();
    }

    @GetMapping("/{id}")
    public LessonProgress getLessonProgressById(@PathVariable Integer id) {
        return lessonProgressDAO.getLessonProgressById(id);
    }

    @GetMapping("/account/{accountId}/lesson/{lessonId}")
    public LessonProgress getLessonProgressByAccountIdAndLessonId(@PathVariable Integer accountId, @PathVariable Integer lessonId) {
        return lessonProgressDAO.getLessonProgressByAccountIdAndLessonId(accountId, lessonId);
    }

    @PostMapping
    public LessonProgress createLessonProgress(@RequestBody LessonProgress lessonProgress) {
        return lessonProgressDAO.createLessonProgress(lessonProgress);
    }

    @PutMapping("/{id}")
    public LessonProgress updateLessonProgress(@PathVariable Integer id, @RequestBody LessonProgress updatedLessonProgress) {
        return lessonProgressDAO.updateLessonProgress(id, updatedLessonProgress);
    }

    @PutMapping("/next/{id}")
    public ResponseEntity<String> setOpenNextLesson(@PathVariable Integer id) {
         lessonProgressDAO.setOpenNextLesson(id);
         return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/{id}")
    public void deleteLessonProgress(@PathVariable Integer id) {
        lessonProgressDAO.deleteLessonProgress(id);
    }
}
