package com.example.AnAn_Chinese.DAO;

import com.example.AnAn_Chinese.Entity.Conversation;
import com.example.AnAn_Chinese.Entity.Grammar;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GrammarDAO extends DAO {

    public List<Grammar> getAllGrammars() {
        return entityManager.createQuery("SELECT g FROM Grammar g", Grammar.class).getResultList();
    }

    public Grammar getGrammarById(Integer id) {
        return entityManager.find(Grammar.class, id);
    }
    public List<Grammar> getListGrammarByLessonId(int lessonId) {
        String jpql = "SELECT c FROM Grammar c WHERE c.lesson_id = :lessonId";
        TypedQuery<Grammar> query = entityManager.createQuery(jpql, Grammar.class);
        query.setParameter("lessonId", lessonId);
        return query.getResultList();
    }

    @Transactional
    public Grammar createGrammar(Grammar grammar) {
        entityManager.persist(grammar);
        return grammar;
    }

    @Transactional
    public Grammar updateGrammar(Integer id, Grammar updatedGrammar) {
        updatedGrammar.setId(id);
        return entityManager.merge(updatedGrammar);
    }

    @Transactional
    public void deleteGrammar(Integer id) {
        Grammar grammar = entityManager.find(Grammar.class, id);
        if (grammar != null) {
            entityManager.remove(grammar);
        }
    }
}
