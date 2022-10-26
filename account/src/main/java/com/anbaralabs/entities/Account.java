package com.anbaralabs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ayoub Anbara
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Where(clause = "deleted=false")
public class Account extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ColumnDefault("0")
    @PositiveOrZero
    @DecimalMax(value = "99999999999999999.99")
    @Column(nullable = false, insertable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "##,###,###,###,###,###.##")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
   // @Size(min = 1, max = 10)
    @Column(length = 10)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    //@Size(min = 1, max = 30)
    @Column(length = 30)
    private AccountType type;

    private boolean deleted = Boolean.FALSE;

    @ManyToOne
    private Customer customer;

    public Account(Long id, BigDecimal balance, Currency currency, AccountType type) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
    }
    public Account(Long id, BigDecimal balance, Currency currency, AccountType type, Date createdDate) {
       this(id,balance,currency,type);
       super.createdDate=createdDate;
    }
}
