package com.anbaralabs.dto;

import com.anbaralabs.entities.AccountType;
import com.anbaralabs.entities.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * @author Ayoub Anbara
 */
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class AccountResponseDto {
    private Long id;
    private BigDecimal balance;
    private Currency currency;
    private AccountType type;
    private Date createdDate;

}
