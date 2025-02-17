package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.Form6DAO;
import com.example.AnAn_Chinese.Entity.Test.Form6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form6")
public class Form6Controller {

    @Autowired
    private Form6DAO form6DAO;

    @GetMapping
    public List<Form6> getAllForms() {
        return form6DAO.getAllForms();
    }

    @GetMapping("/{id}")
    public Form6 getFormById(@PathVariable Integer id) {
        return form6DAO.getFormById(id);
    }

    @GetMapping("/test/{id_test}")
    public List<Form6> getFormsByIdTest(@PathVariable Integer id_test) {
        return form6DAO.getFormsByIdTest(id_test);
    }

    @PostMapping
    public Form6 createForm(@RequestBody Form6 form6) {
        return form6DAO.createForm(form6);
    }

    @PutMapping("/{id}")
    public Form6 updateForm(@PathVariable Integer id, @RequestBody Form6 updatedForm) {
        return form6DAO.updateForm(id, updatedForm);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Integer id) {
        form6DAO.deleteForm(id);
    }
}
