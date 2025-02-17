package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.Form4DAO;
import com.example.AnAn_Chinese.Entity.Test.Form4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form4")
public class Form4Controller {

    @Autowired
    private Form4DAO form4DAO;

    @GetMapping
    public List<Form4> getAllForms() {
        return form4DAO.getAllForms();
    }

    @GetMapping("/{id}")
    public Form4 getFormById(@PathVariable Integer id) {
        return form4DAO.getFormById(id);
    }

    @GetMapping("/test/{id_test}")
    public List<Form4> getFormsByIdTest(@PathVariable Integer id_test) {
        return form4DAO.getFormsByIdTest(id_test);
    }

    @PostMapping
    public Form4 createForm(@RequestBody Form4 form4) {
        return form4DAO.createForm(form4);
    }

    @PutMapping("/{id}")
    public Form4 updateForm(@PathVariable Integer id, @RequestBody Form4 updatedForm) {
        return form4DAO.updateForm(id, updatedForm);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Integer id) {
        form4DAO.deleteForm(id);
    }
}
