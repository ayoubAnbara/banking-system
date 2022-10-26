package com.anbaralabs.service;

import com.anbaralabs.dto.AccountRequestDto;
import com.anbaralabs.dto.AccountResponseDto;
import com.anbaralabs.entities.Account;

import java.util.List;

/**
 * @author Ayoub Anbara
 */
public interface AccountService {

   // Page<AccountResponseDto> getAccounts();
    List<AccountResponseDto> getAccounts();

    AccountResponseDto getAccountById(Long id);

    AccountResponseDto addAccount(AccountRequestDto accountDto);

    void deleteAccount(Long id);

    AccountResponseDto updateAccount(Long id, AccountRequestDto accountRequestDto);
    Account findEntityById(Long id);
}

