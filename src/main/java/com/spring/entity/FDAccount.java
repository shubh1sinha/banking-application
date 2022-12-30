package com.spring.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FDACCOUNT")
public class FDAccount extends Account {

	@Column(name = "RENEWDATE")
	protected boolean renewDate;

	@Column(name = "MATURITYDATE")
	protected Date maturityDate;

	@Column(name = "INTRESTEARED")
	protected BigDecimal intrestEarned;

	public FDAccount() {
		super();
	}

	public FDAccount(boolean renewDate, Date maturityDate, BigDecimal intrestEarned) {
		this.renewDate = renewDate;
		this.maturityDate = maturityDate;
		this.intrestEarned = intrestEarned;
	}

	public boolean isRenewDate() {
		return renewDate;
	}

	public void setRenewDate(boolean renewDate) {
		this.renewDate = renewDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public BigDecimal getIntrestEarned() {
		return intrestEarned;
	}

	public void setIntrestEarned(BigDecimal intrestEarned) {
		this.intrestEarned = intrestEarned;
	}

	@Override
	public BigDecimal getInrestRate() {
		final double interestRate = 0.04;
		intrestEarned = balance.multiply(BigDecimal.valueOf(interestRate * 30)).divide(BigDecimal.valueOf(365.0),
				RoundingMode.HALF_UP);
		return intrestEarned;

	}

}
