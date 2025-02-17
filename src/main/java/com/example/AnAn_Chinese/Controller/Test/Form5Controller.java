package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.Form5DAO;
import com.example.AnAn_Chinese.Entity.Test.Form5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form5")
public class Form5Controller {

    @Autowired
    private Form5DAO form5DAO;

    @GetMapping
    public List<Form5> getAllForms() {
        return form5DAO.getAllForms();
    }

    @GetMapping("/{id}")
    public Form5 getFormById(@PathVariable Integer id) {
        return form5DAO.getFormById(id);
    }

    @GetMapping("/test/{id_test}")
    public List<Form5> getFormsByIdTest(@PathVariable Integer id_test) {
        return form5DAO.getFormsByIdTest(id_test);
    }

    @PostMapping
    public Form5 createForm(@RequestBody Form5 form5) {
        return form5DAO.createForm(form5);
    }

    @PutMapping("/{id}")
    public Form5 updateForm(@PathVariable Integer id, @RequestBody Form5 updatedForm) {
        return form5DAO.updateForm(id, updatedForm);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Integer id) {
        form5DAO.deleteForm(id);
    }
}
