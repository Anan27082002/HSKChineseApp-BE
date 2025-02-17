package com.example.AnAn_Chinese.DAO;

import com.example.AnAn_Chinese.Entity.Conversation;
import com.example.AnAn_Chinese.Entity.Sentence;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SentenceDAO extends DAO {

    public List<Sentence> getAllSentences() {
        return entityManager.createQuery("SELECT s FROM Sentence s", Sentence.class).getResultList();
    }

    public Sentence getSentenceById(Integer id) {
        return entityManager.find(Sentence.class, id);
    }
    public List<Sentence> getSentencesByConversationId(int conservationId) {
        String jpql = "SELECT s FROM Sentence s WHERE s.conversation_id = :conservationId";
        TypedQuery<Sentence> query = entityManager.createQuery(jpql, Sentence.class);
        query.setParameter("conservationId", conservationId);
        return query.getResultList();
    }

    @Transactional
    public Sentence createSentence(Sentence sentence) {
        entityManager.persist(sentence);
        return sentence;
    }

    @Transactional
    public Sentence updateSentence(Integer id, Sentence updatedSentence) {
        updatedSentence.setId(id);
        return entityManager.merge(updatedSentence);
    }

    @Transactional
    public void deleteSentence(Integer id) {
        Sentence sentence = entityManager.find(Sentence.class, id);
        if (sentence != null) {
            entityManager.remove(sentence);
        }
    }
}
