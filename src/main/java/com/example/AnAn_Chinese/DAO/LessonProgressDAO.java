package com.example.AnAn_Chinese.DAO;

import com.example.AnAn_Chinese.Entity.Lesson;
import com.example.AnAn_Chinese.Entity.LessonProgress;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LessonProgressDAO extends DAO {

    public List<LessonProgress> getAllLessonProgress() {
        return entityManager.createQuery("SELECT lp FROM LessonProgress lp", LessonProgress.class).getResultList();
    }

    public LessonProgress getLessonProgressById(Integer id) {
        return entityManager.find(LessonProgress.class, id);
    }

    public List<LessonProgress> getLessonProgressByAccountId(Integer accountId) {
        String jpql = "SELECT lp FROM LessonProgress lp WHERE lp.id_account = :accountId";
        TypedQuery<LessonProgress> query = entityManager.createQuery(jpql, LessonProgress.class);
        query.setParameter("accountId", accountId);
        return query.getResultList();
    }

    public List<LessonProgress> getLessonProgressByLessonId(Integer lessonId) {
        String jpql = "SELECT lp FROM LessonProgress lp WHERE lp.id_lesson = :lessonId";
        TypedQuery<LessonProgress> query = entityManager.createQuery(jpql, LessonProgress.class);
        query.setParameter("lessonId", lessonId);
        return query.getResultList();
    }

    public LessonProgress getLessonProgressByAccountIdAndLessonId(Integer accountId, Integer lessonId) {
        String jpql = "SELECT lp FROM LessonProgress lp WHERE lp.id_account = :accountId AND lp.id_lesson = :lessonId";
        TypedQuery<LessonProgress> query = entityManager.createQuery(jpql, LessonProgress.class);
        query.setParameter("accountId", accountId);
        query.setParameter("lessonId", lessonId);
        return query.getSingleResult();
    }

    @Transactional
    public void setOpenNextLesson(Integer idLessonProgress) {
        // Tìm LessonProgress hiện tại
        LessonProgress currentLessonProgress = getLessonProgressById(idLessonProgress);
        if (currentLessonProgress == null) {
            throw new IllegalArgumentException("LessonProgress with id " + idLessonProgress + " not found");
        }

        // Tìm Lesson hiện tại
        Lesson currentLesson = entityManager.find(Lesson.class, currentLessonProgress.getId_lesson());
        if (currentLesson == null) {
            throw new IllegalArgumentException("Lesson with id " + currentLessonProgress.getId_lesson() + " not found");
        }

        // Tìm bài học tiếp theo có number lớn hơn và thuộc cùng of_level
        String jpql = "SELECT l FROM Lesson l WHERE l.of_level = :ofLevel AND l.number > :currentNumber ORDER BY l.number ASC";
        TypedQuery<Lesson> query = entityManager.createQuery(jpql, Lesson.class);
        query.setParameter("ofLevel", currentLesson.getOf_level());
        query.setParameter("currentNumber", currentLesson.getNumber());
        query.setMaxResults(1); // Chỉ lấy bài học tiếp theo

        List<Lesson> nextLessons = query.getResultList();
        if (!nextLessons.isEmpty()) {
            Lesson nextLesson = nextLessons.get(0);

            // Tìm LessonProgress tương ứng với bài học tiếp theo và mở khóa nó
            String progressJpql = "SELECT lp FROM LessonProgress lp WHERE lp.id_lesson = :lessonId AND lp.id_account = :accountId";
            TypedQuery<LessonProgress> progressQuery = entityManager.createQuery(progressJpql, LessonProgress.class);
            progressQuery.setParameter("lessonId", nextLesson.getId());
            progressQuery.setParameter("accountId", currentLessonProgress.getId_account());

            List<LessonProgress> nextLessonProgressList = progressQuery.getResultList();
            if (!nextLessonProgressList.isEmpty()) {
                LessonProgress nextLessonProgress = nextLessonProgressList.get(0);
                nextLessonProgress.set_open(true);
                entityManager.merge(nextLessonProgress);
            } else {
                throw new IllegalArgumentException("LessonProgress for the next lesson not found");
            }
        } else {
            throw new IllegalArgumentException("No next lesson found in the same level");
        }
    }


    @Transactional
    public LessonProgress createLessonProgress(LessonProgress lessonProgress) {
        entityManager.persist(lessonProgress);
        return lessonProgress;
    }

    @Transactional
    public LessonProgress updateLessonProgress(Integer id, LessonProgress updatedLessonProgress) {
        updatedLessonProgress.setId(id);
        return entityManager.merge(updatedLessonProgress);
    }

    @Transactional
    public void deleteLessonProgress(Integer id) {
        LessonProgress lessonProgress = entityManager.find(LessonProgress.class, id);
        if (lessonProgress != null) {
            entityManager.remove(lessonProgress);
        }
    }
}
