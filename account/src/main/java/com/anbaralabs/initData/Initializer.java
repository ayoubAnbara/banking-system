package com.anbaralabs.initData;

import com.anbaralabs.config.AppConstants;
import com.anbaralabs.dto.AccountRequestDto;
import com.anbaralabs.entities.AccountType;
import com.anbaralabs.entities.Currency;
import com.anbaralabs.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Ayoub Anbara
 */
@Component
@Profile({AppConstants.PROFILE_DEVELOPMENT})
//@RequiredArgsConstructor
public class Initializer {

    private final AccountService accountService;

    public Initializer(AccountService accountService) {
        this.accountService = accountService;
    }

    public void initData(){
        accountService.addAccount(new AccountRequestDto(BigDecimal.valueOf(2000), Currency.EUR, AccountType.SAVING));
        accountService.addAccount(new AccountRequestDto(BigDecimal.valueOf(4000), Currency.MAD, AccountType.SAVING));
        accountService.addAccount(new AccountRequestDto(BigDecimal.valueOf(6700), Currency.USD, AccountType.CURRENT));
        accountService.addAccount(new AccountRequestDto(BigDecimal.valueOf(25500), Currency.EUR, AccountType.CURRENT));
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            initData();
        };
    }

}
