package com.anbaralabs.api;

import com.anbaralabs.dto.AccountRequestDto;
import com.anbaralabs.dto.AccountResponseDto;
import com.anbaralabs.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ayoub Anbara
 */
@RestController
@RequestMapping("api/v1/accounts")
//@AllArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> allAccounts() { // int page, int limit, String keyword
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping("/{id}")
//    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AccountResponseDto> account(@PathVariable Long id) {
        return ResponseEntity
                .ok(accountService.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountResponseDto> addAccount(@RequestBody AccountRequestDto account) {
        return new ResponseEntity<>(accountService.AddAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseDto> update(@PathVariable Long id, @RequestBody AccountRequestDto accountRequestDto) {
        return ResponseEntity.ok(accountService.updateAccount(id, accountRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
