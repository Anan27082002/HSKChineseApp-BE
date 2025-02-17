package com.example.AnAn_Chinese.DAO;

import com.example.AnAn_Chinese.Entity.Grammar;
import com.example.AnAn_Chinese.Entity.Lesson;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LessonDAO extends DAO {

    public List<Lesson> getAllLessons() {
        return entityManager.createQuery("SELECT l FROM Lesson l", Lesson.class).getResultList();
    }

    public Lesson getLessonById(Integer id) {
        return entityManager.find(Lesson.class, id);
    }

    public List<Lesson> getAllLessonByLessonId(int lessonId) {
        String jpql = "SELECT c FROM Lesson c WHERE c.lesson_id = :lessonId";
        TypedQuery<Lesson> query = entityManager.createQuery(jpql, Lesson.class);
        query.setParameter("lessonId", lessonId);
        return query.getResultList();
    }

    @Transactional
    public Lesson createLesson(Lesson lesson) {
        entityManager.persist(lesson);
        return lesson;
    }

    @Transactional
    public Lesson updateLesson(Integer id, Lesson updatedLesson) {
        updatedLesson.setId(id);
        return entityManager.merge(updatedLesson);
    }

    @Transactional
    public void deleteLesson(Integer id) {
        Lesson lesson = entityManager.find(Lesson.class, id);
        if (lesson != null) {
            entityManager.remove(lesson);
        }
    }
}
