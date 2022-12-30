package com.spring.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USERID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "PANCARD")
	private String panCard;

	@Column(name = "AADHARNO")
	private BigInteger aadharNo;

	@Column(name = "PHONENO")
	private BigInteger phoneNo;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private Address address;

	@OneToOne(mappedBy = "user")
	Account account;

	public User() {
	}

	public User(int userId, String firstName, String lastName, String panCard, BigInteger aadharNo, BigInteger phoneNo,
			Address address) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.panCard = panCard;
		this.aadharNo = aadharNo;
		this.phoneNo = phoneNo;
		this.address = address;
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

	public BigInteger getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(BigInteger aadharNo) {
		this.aadharNo = aadharNo;
	}

	public BigInteger getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(BigInteger phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
