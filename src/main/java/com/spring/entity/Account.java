package com.spring.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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


	@Column(name="ACCOUNTTYPE")
	protected String accountType;
	
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    protected User user;

	public Account() {

	}
    
	public Account(long accountNo, BigDecimal balance, Date openingDate, String accountType) {
		this.accountNo = accountNo;
		this.balance = balance;
		this.openingDate = openingDate;
		this.accountType=accountType;
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
	
    public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
	public abstract BigDecimal getInrestRate();
	

}
