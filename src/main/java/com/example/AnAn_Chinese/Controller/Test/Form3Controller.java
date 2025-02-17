package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.Form3DAO;
import com.example.AnAn_Chinese.Entity.Test.Form3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form3")
public class Form3Controller {

    @Autowired
    private Form3DAO form3DAO;

    @GetMapping
    public List<Form3> getAllForms() {
        return form3DAO.getAllForms();
    }

    @GetMapping("/{id}")
    public Form3 getFormById(@PathVariable Integer id) {
        return form3DAO.getFormById(id);
    }

    @GetMapping("/test/{id_test}")
    public List<Form3> getFormsByIdTest(@PathVariable Integer id_test) {
        return form3DAO.getFormsByIdTest(id_test);
    }

    @PostMapping
    public Form3 createForm(@RequestBody Form3 form3) {
        return form3DAO.createForm(form3);
    }

    @PutMapping("/{id}")
    public Form3 updateForm(@PathVariable Integer id, @RequestBody Form3 updatedForm) {
        return form3DAO.updateForm(id, updatedForm);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Integer id) {
        form3DAO.deleteForm(id);
    }
}
