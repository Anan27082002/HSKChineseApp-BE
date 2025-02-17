package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.Form1DAO;
import com.example.AnAn_Chinese.Entity.Test.Form1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form1")
public class Form1Controller {

    @Autowired
    private Form1DAO form1DAO;

    @GetMapping
    public List<Form1> getAllForms() {
        return form1DAO.getAllForms();
    }

    @GetMapping("/{id}")
    public Form1 getFormById(@PathVariable Integer id) {
        return form1DAO.getFormById(id);
    }

    @GetMapping("/test/{id_test}")
    public List<Form1> getFormsByIdTest(@PathVariable Integer id_test) {
        return form1DAO.getFormsByIdTest(id_test);
    }

    @PostMapping
    public Form1 createForm(@RequestBody Form1 form1) {
        return form1DAO.createForm(form1);
    }

    @PutMapping("/{id}")
    public Form1 updateForm(@PathVariable Integer id, @RequestBody Form1 updatedForm) {
        return form1DAO.updateForm(id, updatedForm);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Integer id) {
        form1DAO.deleteForm(id);
    }
}
