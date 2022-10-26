package com.anbaralabs.initData;

import com.anbaralabs.config.AppConstants;
import com.anbaralabs.dto.AccountRequestDto;
import com.anbaralabs.dto.CustomerRequestDto;
import com.anbaralabs.entities.AccountType;
import com.anbaralabs.entities.Currency;
import com.anbaralabs.entities.Customer;
import com.anbaralabs.service.AccountService;
import com.anbaralabs.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * @author Ayoub Anbara
 */
@Component
@Profile({AppConstants.PROFILE_DEVELOPMENT})
@RequiredArgsConstructor
public class Initializer {

    private final AccountService accountService;
    private final CustomerService customerService;


    public void initData(){

        Stream.of("Ahmed","Ali","Ayoub","Hanane").forEach(name-> {
            CustomerRequestDto customerRequestDto= new CustomerRequestDto(name);
            customerService.addCustomer(customerRequestDto);

        });

        customerService.getCustomers().forEach(customerResponseDto -> {

        });

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
