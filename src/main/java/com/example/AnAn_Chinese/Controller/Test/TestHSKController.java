package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.TestHSKDAO;
import com.example.AnAn_Chinese.Entity.Test.TestHSK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testhsk")
public class TestHSKController {

    @Autowired
    private TestHSKDAO testHSKDAO;

    @GetMapping
    public List<TestHSK> getAllTests() {
        return testHSKDAO.getAllTests();
    }

    @GetMapping("/{id}")
    public TestHSK getTestById(@PathVariable Integer id) {
        return testHSKDAO.getTestById(id);
    }

    @GetMapping("/level/{ofLevel}")
    public List<TestHSK> getTestsByLevel(@PathVariable Integer ofLevel) {
        return testHSKDAO.getListTestByOfLevel(ofLevel);
    }

    @PostMapping
    public TestHSK createTest(@RequestBody TestHSK testHSK) {
        return testHSKDAO.createTest(testHSK);
    }

    @PutMapping("/{id}")
    public TestHSK updateTest(@PathVariable Integer id, @RequestBody TestHSK updatedTest) {
        return testHSKDAO.updateTest(id, updatedTest);
    }

    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable Integer id) {
        testHSKDAO.deleteTest(id);
    }
}
