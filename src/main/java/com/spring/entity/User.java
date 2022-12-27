package com.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	@Id
	@Column(name="USERID")
	private int userId;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="PANCARD")
	private String panCard;
	
	@Column(name="AADHARNO")
	private String aadharNo;
	
	@Column(name="PHONENO")
	private String phoneNo;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="ACCOUNTTYPE")
	private String accountType;
	
	
	@OneToOne(mappedBy = "user")
	Account account;
	
	

	public User() {
	}

	public User(int userId, String firstName, String lastName, String panCard, String aadharNo, String phoneNo,
			String address, String accountType) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.panCard = panCard;
		this.aadharNo = aadharNo;
		this.phoneNo = phoneNo;
		this.address = address;
		this.accountType=accountType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
	
}
