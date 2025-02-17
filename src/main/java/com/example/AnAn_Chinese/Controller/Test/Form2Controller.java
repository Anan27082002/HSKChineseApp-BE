package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.Form2DAO;
import com.example.AnAn_Chinese.Entity.Test.Form2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form2")
public class Form2Controller {

    @Autowired
    private Form2DAO form2DAO;

    @GetMapping
    public List<Form2> getAllForms() {
        return form2DAO.getAllForms();
    }

    @GetMapping("/{id}")
    public Form2 getFormById(@PathVariable Integer id) {
        return form2DAO.getFormById(id);
    }

    @GetMapping("/test/{id_test}")
    public List<Form2> getFormsByIdTest(@PathVariable Integer id_test) {
        return form2DAO.getFormsByIdTest(id_test);
    }

    @PostMapping
    public Form2 createForm(@RequestBody Form2 form2) {
        return form2DAO.createForm(form2);
    }

    @PutMapping("/{id}")
    public Form2 updateForm(@PathVariable Integer id, @RequestBody Form2 updatedForm) {
        return form2DAO.updateForm(id, updatedForm);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Integer id) {
        form2DAO.deleteForm(id);
    }
}
