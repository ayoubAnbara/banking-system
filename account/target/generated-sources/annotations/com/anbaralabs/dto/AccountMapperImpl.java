package com.anbaralabs.dto;

import com.anbaralabs.entities.Account;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T14:09:35+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountResponseDto accountToAccountResponseDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountResponseDto.AccountResponseDtoBuilder accountResponseDto = AccountResponseDto.builder();

        accountResponseDto.id( account.getId() );
        accountResponseDto.balance( account.getBalance() );
        accountResponseDto.currency( account.getCurrency() );
        accountResponseDto.type( account.getType() );
        accountResponseDto.createdDate( account.getCreatedDate() );

        return accountResponseDto.build();
    }

    @Override
    public Account accountRequestDtoToAccount(AccountRequestDto accountRequestDto) {
        if ( accountRequestDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setBalance( accountRequestDto.getBalance() );
        account.setCurrency( accountRequestDto.getCurrency() );
        account.setType( accountRequestDto.getType() );

        return account;
    }
}
