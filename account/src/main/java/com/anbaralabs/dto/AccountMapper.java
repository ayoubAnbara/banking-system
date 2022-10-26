package com.anbaralabs.dto;

import com.anbaralabs.entities.Account;
import org.mapstruct.Mapper;

/**
 * @author Ayoub Anbara
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountResponseDto accountToAccountResponseDto(Account account);
    Account accountRequestDtoToAccount(AccountRequestDto accountRequestDto );
}
