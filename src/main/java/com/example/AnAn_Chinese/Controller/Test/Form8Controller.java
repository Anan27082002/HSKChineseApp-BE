package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.Form8DAO;
import com.example.AnAn_Chinese.Entity.Test.Form8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form8")
public class Form8Controller {

    @Autowired
    private Form8DAO form8DAO;

    @GetMapping
    public List<Form8> getAllForms() {
        return form8DAO.getAllForms();
    }

    @GetMapping("/{id}")
    public Form8 getFormById(@PathVariable Integer id) {
        return form8DAO.getFormById(id);
    }

    @GetMapping("/test/{id_test}")
    public List<Form8> getFormsByIdTest(@PathVariable Integer id_test) {
        return form8DAO.getFormsByIdTest(id_test);
    }

    @PostMapping
    public Form8 createForm(@RequestBody Form8 form8) {
        return form8DAO.createForm(form8);
    }

    @PutMapping("/{id}")
    public Form8 updateForm(@PathVariable Integer id, @RequestBody Form8 updatedForm) {
        return form8DAO.updateForm(id, updatedForm);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Integer id) {
        form8DAO.deleteForm(id);
    }
}
