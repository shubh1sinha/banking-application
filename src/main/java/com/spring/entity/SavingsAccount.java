package com.spring.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="SAVINGSACCOUNT")
public class SavingsAccount extends Account{
	
	@Column(name="INTRESTEARNED")
	protected BigDecimal intrestEarned;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(long accountNo, BigDecimal balance, Date openingDate, BigDecimal intrestEarned, String accountType) {
		super(accountNo, balance, openingDate, accountType);
		this.intrestEarned=intrestEarned;
	}

	@Override
	public BigDecimal getInrestRate() {
		final double interestRate= 0.04;
        intrestEarned= balance.multiply(BigDecimal.valueOf(interestRate*30)).divide(BigDecimal.valueOf(365.0),RoundingMode.HALF_UP);
        return intrestEarned;
	}

}
