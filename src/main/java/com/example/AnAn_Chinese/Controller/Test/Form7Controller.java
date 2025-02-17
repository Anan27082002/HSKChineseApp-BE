package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.Form7DAO;
import com.example.AnAn_Chinese.Entity.Test.Form7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form7")
public class Form7Controller {

    @Autowired
    private Form7DAO form7DAO;

    @GetMapping
    public List<Form7> getAllForms() {
        return form7DAO.getAllForms();
    }

    @GetMapping("/{id}")
    public Form7 getFormById(@PathVariable Integer id) {
        return form7DAO.getFormById(id);
    }

    @GetMapping("/test/{id_test}")
    public List<Form7> getFormsByIdTest(@PathVariable Integer id_test) {
        return form7DAO.getFormsByIdTest(id_test);
    }

    @PostMapping
    public Form7 createForm(@RequestBody Form7 form7) {
        return form7DAO.createForm(form7);
    }

    @PutMapping("/{id}")
    public Form7 updateForm(@PathVariable Integer id, @RequestBody Form7 updatedForm) {
        return form7DAO.updateForm(id, updatedForm);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Integer id) {
        form7DAO.deleteForm(id);
    }
}
