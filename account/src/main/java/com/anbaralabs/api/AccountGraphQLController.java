package com.anbaralabs.api;

import com.anbaralabs.dto.AccountRequestDto;
import com.anbaralabs.dto.AccountResponseDto;
import com.anbaralabs.entities.Account;
import com.anbaralabs.repositories.AccountRepo;
import com.anbaralabs.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Ayoub Anbara
 */
@Controller
@RequiredArgsConstructor
public class AccountGraphQLController {
    private final AccountRepo accountRepo;
    private final AccountService accountService;

    @QueryMapping
    public List<AccountResponseDto> accountsList(){
        return accountService.getAccounts();
    }


    @QueryMapping
    public AccountResponseDto accountById(@Argument Long id){
        return accountService.getAccountById(id);
    }

    @MutationMapping
    public AccountResponseDto addAccount(@Argument AccountRequestDto accountRequestDto){
        return accountService.addAccount(accountRequestDto);

    }
    @MutationMapping
    public AccountResponseDto updateAccount(@Argument Long id,@Argument AccountRequestDto accountRequestDto){
        return accountService.updateAccount(id,accountRequestDto);

    }
    @MutationMapping
    public void deleteAccount(@Argument Long id){
         accountService.deleteAccount(id);
    }
}
/*record AccountDto(BigDecimal balance,
                  String currency,
                  String type){

}*/
