package com.cybertek.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@MappedSuperclass
public class Account {

    @Id
    private Long id;

    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;

}
