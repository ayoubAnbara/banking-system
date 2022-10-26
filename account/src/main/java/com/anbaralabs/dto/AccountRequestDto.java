package com.anbaralabs.dto;

import com.anbaralabs.entities.AccountType;
import com.anbaralabs.entities.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author Ayoub Anbara
 */
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class AccountRequestDto {

    @PositiveOrZero
    @DecimalMax(value = "99999999999999999.99")
    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "##,###,###,###,###,###.##")
    private BigDecimal balance;


//    @Size(min = 1, max = 10)
    private Currency currency;


//    @Size(min = 1, max = 20)
    private AccountType type;

}
