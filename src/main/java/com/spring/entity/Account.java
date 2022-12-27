package com.spring.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
	
	@Id
	@Column(name="ACCOUNTNO")
	protected long accountNo;
	
	@Column(name="BALANCE")
	protected BigDecimal balance;
	
	@Column(name="OPENINGDATE")
	protected Date openingDate;
	
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    protected User user;

	public Account() {

	}
    
	public Account(long accountNo, BigDecimal balance, Date openingDate) {
		this.accountNo = accountNo;
		this.balance = balance;
		this.openingDate = openingDate;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	
	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public abstract BigDecimal getInrestRate();
	

}
