package com.example.AnAn_Chinese.DAO.Test;

import com.example.AnAn_Chinese.Entity.Test.Form6;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Form6DAO extends com.example.AnAn_Chinese.DAO.DAO {

    public List<Form6> getAllForms() {
        return entityManager.createQuery("SELECT f FROM Form6 f", Form6.class).getResultList();
    }

    public Form6 getFormById(Integer id) {
        return entityManager.find(Form6.class, id);
    }

    public List<Form6> getFormsByIdTest(Integer idTest) {
        return entityManager.createQuery("SELECT f FROM Form6 f WHERE f.id_test = :idTest", Form6.class)
                .setParameter("idTest", idTest)
                .getResultList();
    }

    @Transactional
    public Form6 createForm(Form6 form6) {
        entityManager.persist(form6);
        return form6;
    }

    @Transactional
    public Form6 updateForm(Integer id, Form6 updatedForm) {
        updatedForm.setId(id);
        return entityManager.merge(updatedForm);
    }

    @Transactional
    public void deleteForm(Integer id) {
        Form6 form6 = entityManager.find(Form6.class, id);
        if (form6 != null) {
            entityManager.remove(form6);
        }
    }
}
