package com.example.AnAn_Chinese.DAO;

import com.example.AnAn_Chinese.Entity.Conversation;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ConversationDAO extends DAO {

    public List<Conversation> getAllConversations() {
        return entityManager.createQuery("SELECT c FROM Conversation c", Conversation.class).getResultList();
    }

    public Conversation getConversationById(Integer id) {
        return entityManager.find(Conversation.class, id);
    }

    public List<Conversation> getListConversationsByLessonId(int lessonId) {
        String jpql = "SELECT c FROM Conversation c WHERE c.lesson_id = :lessonId";
        TypedQuery<Conversation> query = entityManager.createQuery(jpql, Conversation.class);
        query.setParameter("lessonId", lessonId);
        return query.getResultList();
    }

    @Transactional
    public Conversation createConversation(Conversation conversation) {
        entityManager.persist(conversation);
        return conversation;
    }

    @Transactional
    public Conversation updateConversation(Integer id, Conversation updatedConversation) {
        updatedConversation.setId(id);
        return entityManager.merge(updatedConversation);
    }

    @Transactional
    public void deleteConversation(Integer id) {
        Conversation conversation = entityManager.find(Conversation.class, id);
        if (conversation != null) {
            entityManager.remove(conversation);
        }
    }
}
