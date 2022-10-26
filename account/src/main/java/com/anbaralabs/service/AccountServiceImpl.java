package com.anbaralabs.service;

import com.anbaralabs.dto.AccountMapper;
import com.anbaralabs.dto.AccountRequestDto;
import com.anbaralabs.dto.AccountResponseDto;
import com.anbaralabs.entities.Account;
import com.anbaralabs.repositories.AccountRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ayoub Anbara
 */
@Service
@Slf4j
//@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepo accountRepo, AccountMapper accountMapper) {
        this.accountRepo = accountRepo;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountResponseDto> getAccounts() { // Pageable pageable
        return accountRepo.findAll().stream().map(accountMapper::accountToAccountResponseDto).collect(Collectors.toList());
      // Page<AccountResponseDto> accountResponseDtos = accountRepo.findAllByType(keyword, PageRequest.of(page, limit));

    }


    @Override
    public AccountResponseDto getAccountById(Long id) {
        Account account = findEntityById(id);
        return accountMapper.accountToAccountResponseDto(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepo.deleteById(id);
    }


    @Override
    public AccountResponseDto addAccount(AccountRequestDto accountDto) {
        Account accountAdded = accountRepo.save(accountMapper.accountRequestDtoToAccount(accountDto));
        return accountMapper.accountToAccountResponseDto(accountAdded);
    }

    @Override
    public AccountResponseDto updateAccount(Long id, AccountRequestDto accountRequestDto) {
        Account account = findEntityById(id);
        BeanUtils.copyProperties(accountRequestDto, account);// todo validation
        Account accountUpdated = accountRepo.save(account);
        return accountMapper.accountToAccountResponseDto(accountUpdated);
    }

    @Override
    public Account findEntityById(Long id) {
        return accountRepo.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Account %s not found", id)));
    }
}
