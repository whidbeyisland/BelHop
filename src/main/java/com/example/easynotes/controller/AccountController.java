package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Account;
import com.example.easynotes.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/accounts")
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable(value = "id") Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
    }

    //EXPERIMENTAL
    /*
    @GetMapping("/accounts/email")
    public @ResponseBody GridModel getAccountByEmail(
    @RequestParam String email) {
        return accountRepository.findAll().
    }
    */

    @PutMapping("/accounts/{id}")
    public Account updateAccount(@PathVariable(value = "id") Long accountId,
                                           @Valid @RequestBody Account accountDetails) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        /*
        account.setTitle(accountDetails.getTitle());
        account.setContent(accountDetails.getContent());
        */

        //doesn't set relationships to other objects yet!
        account.setEmail(accountDetails.getEmail());
        account.setPassword(accountDetails.getPassword());
        account.setOwner(accountDetails.isOwner());
        account.setFirstName(accountDetails.getFirstName());
        account.setMiddleName(accountDetails.getMiddleName());
        account.setLastName(accountDetails.getLastName());
        account.setAddress(accountDetails.getAddress());
        account.setAddressPart2(accountDetails.getAddressPart2());
        account.setCity(accountDetails.getCity());
        account.setState(accountDetails.getState());
        account.setZip(accountDetails.getZip());
        account.setZipPlus4(accountDetails.getZipPlus4());

        Account updatedAccount = accountRepository.save(account);
        return updatedAccount;
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        accountRepository.delete(account);

        return ResponseEntity.ok().build();
    }
}
