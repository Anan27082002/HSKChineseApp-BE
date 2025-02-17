package com.example.AnAn_Chinese.DAO;

import com.example.AnAn_Chinese.Entity.Vocabulary;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class VocabularyDAO extends DAO {

    public List<Vocabulary> getAllVocabularies() {
        return entityManager.createQuery("SELECT v FROM Vocabulary v", Vocabulary.class).getResultList();
    }

    public Vocabulary getVocabularyById(Integer id) {
        return entityManager.find(Vocabulary.class, id);
    }

    public List<Vocabulary> getListVocabularyByLessonId(int lessonId) {
        String jpql = "SELECT c FROM Vocabulary c WHERE c.lesson_id = :lessonId";
        TypedQuery<Vocabulary> query = entityManager.createQuery(jpql, Vocabulary.class);
        query.setParameter("lessonId", lessonId);
        return query.getResultList();
    }


    @Transactional
    public Vocabulary createVocabulary(Vocabulary vocabulary) {
        entityManager.persist(vocabulary);
        return vocabulary;
    }

    @Transactional
    public Vocabulary updateVocabulary(Integer id, Vocabulary updatedVocabulary) {
        updatedVocabulary.setId(id);
        return entityManager.merge(updatedVocabulary);
    }

    @Transactional
    public void deleteVocabulary(Integer id) {
        Vocabulary vocabulary = entityManager.find(Vocabulary.class, id);
        if (vocabulary != null) {
            entityManager.remove(vocabulary);
        }
    }
}
