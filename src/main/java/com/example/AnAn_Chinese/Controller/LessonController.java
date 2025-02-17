package com.example.AnAn_Chinese.Controller;

import com.example.AnAn_Chinese.DAO.LessonDAO;
import com.example.AnAn_Chinese.Entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
public class LessonController {

    @Autowired
    private LessonDAO lessonDAO;

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonDAO.getAllLessons();
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Integer id) {
        return lessonDAO.getLessonById(id);
    }

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonDAO.createLesson(lesson);
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Integer id, @RequestBody Lesson updatedLesson) {
        return lessonDAO.updateLesson(id, updatedLesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Integer id) {
        lessonDAO.deleteLesson(id);
    }
}
