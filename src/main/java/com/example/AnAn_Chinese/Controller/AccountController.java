package com.example.AnAn_Chinese.Controller;

import com.example.AnAn_Chinese.DAO.AccountDAO;
import com.example.AnAn_Chinese.Entity.Account;
import com.example.AnAn_Chinese.Request.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountDAO accountDAO;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccount();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Integer id) {
        return accountDAO.getAccountById(id);
    }

    @PostMapping("/login")
    public Account getAccountByInfo(@RequestBody AccountRequest accountRequest) {
        System.out.println("username: " + accountRequest.getUsername());
        System.out.println("password: " + accountRequest.getPassword());
        return accountDAO.getAccountByInfo(accountRequest);
    }

    @PostMapping("/register")
    public Account createAccountByInfo(@RequestBody Account account) {
        return accountDAO.createAccountIfUnique(account);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountDAO.createAccount(account);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Integer id, @RequestBody Account updatedAccount) {
        return accountDAO.updateAccount(id, updatedAccount);
    }

    @PutMapping("/lesson/{id}")
    public Account updateLessonAccount(@PathVariable Integer id, @RequestBody Account updatedAccount) {
        return accountDAO.updateAccount(id, updatedAccount);
    }

    @PutMapping("/level/{id}")
    public Account updateLevelAccount(@PathVariable Integer id, @RequestBody Account updatedAccount) {
        return accountDAO.updateAccount(id, updatedAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        accountDAO.deleteAccount(id);
    }
}
