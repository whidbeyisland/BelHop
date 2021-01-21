package com.example.easyAccounts.controller;

import com.example.easyAccounts.exception.ResourceNotFoundException;
import com.example.easyAccounts.model.Account;
import com.example.easyAccounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountRepository AccountRepository;

    @GetMapping("/Accounts")
    public List<Account> getAllAccounts() {
        return AccountRepository.findAll();
    }

    @PostMapping("/Accounts")
    public Account createAccount(@Valid @RequestBody Account Account) {
        return AccountRepository.save(Account);
    }

    @GetMapping("/Accounts/{id}")
    public Account getAccountById(@PathVariable(value = "id") Long AccountId) {
        return AccountRepository.findById(AccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", AccountId));
    }

    @PutMapping("/Accounts/{id}")
    public Account updateAccount(@PathVariable(value = "id") Long AccountId,
                                           @Valid @RequestBody Account AccountDetails) {

        Account Account = AccountRepository.findById(AccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", AccountId));

        Account.setTitle(AccountDetails.getTitle());
        Account.setContent(AccountDetails.getContent());

        Account updatedAccount = AccountRepository.save(Account);
        return updatedAccount;
    }

    @DeleteMapping("/Accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long AccountId) {
        Account Account = AccountRepository.findById(AccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", AccountId));

        AccountRepository.delete(Account);

        return ResponseEntity.ok().build();
    }
}
