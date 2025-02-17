package com.example.AnAn_Chinese.Controller.Test;

import com.example.AnAn_Chinese.DAO.Test.TestProgressDAO;
import com.example.AnAn_Chinese.Entity.Test.TestProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testprogress")
public class TestProgressController {

    @Autowired
    private TestProgressDAO testProgressDAO;

    @GetMapping
    public List<TestProgress> getAllTestProgresses() {
        return testProgressDAO.getAllTestProgresses();
    }

    @GetMapping("/{id}")
    public TestProgress getTestProgressById(@PathVariable Integer id) {
        return testProgressDAO.getTestProgressById(id);
    }

    @GetMapping("/test/{idTest}/account/{idAccount}")
    public TestProgress getTestProgressByIdTestAndIdAccount(@PathVariable Integer idTest, @PathVariable Integer idAccount) {
        return testProgressDAO.getTestProgressByIdTestAndIdAccount(idTest, idAccount);
    }

    @PostMapping
    public TestProgress createTestProgress(@RequestBody TestProgress testProgress) {
        return testProgressDAO.createTestProgress(testProgress);
    }

    @PutMapping("/{id}")
    public TestProgress updateTestProgress(@PathVariable Integer id, @RequestBody TestProgress updatedTestProgress) {
        return testProgressDAO.updateTestProgress(id, updatedTestProgress);
    }

    @PutMapping("/next/{id}")
    public ResponseEntity<String> setOpenNextLesson(@PathVariable Integer id) {
        testProgressDAO.setOpenNextTest(id);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/{id}")
    public void deleteTestProgress(@PathVariable Integer id) {
        testProgressDAO.deleteTestProgress(id);
    }
}
