package com.spring.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.spring.dto.UserDTO;
import com.spring.entity.Account;
import com.spring.entity.FDAccount;
import com.spring.entity.SavingsAccount;
import com.spring.entity.User;
import com.spring.repo.AccountRepository;
import com.spring.repo.FDAccountRepository;
import com.spring.repo.SavingsAccountRepository;
import com.spring.repo.UserRepository;

@Service
public class AdminServce implements AdminServiceDAO {
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SavingsAccountRepository savingsAccountRepo;
	
	@Autowired
	private FDAccountRepository fdAccountRepo;

	@Override
	/***
	 * @author shusinha5
	 * {@summary User is registered and at the same time either FD or RD account is created}
	 */
	public String openAccount(UserDTO user) {
		User setUser = new User();
		setUser.setFirstName(user.getFirstName());
		setUser.setLastName(user.getLastName());
		setUser.setAadharNo(user.getAadharNo());
		setUser.setAccountType(user.getAccountType());
		setUser.setPanCard(user.getPanCard());
		setUser.setPhoneNo(user.getPhoneNo());
		setUser.setAddress(user.getAddress());
		if(userRepo.getNullUserId() == null) {
			setUser.setUserId(1);
		}
		else {
			setUser.setUserId(userRepo.getMaxUserId()+1);
		}
		
		userRepo.save(setUser);
		if(user.getAccountType().equals("Savings")) {
			Account savingsAccount = new SavingsAccount();
			SavingsAccount account = (SavingsAccount)savingsAccount;
			account.setBalance(BigDecimal.valueOf(500));
			account.setUser(setUser);
			account.setOpeningDate(getCurrentDate());
			account.getInrestRate();
			if(accountRepo.getNullAccountNo() == null) {
				account.setAccountNo(12101L);
			}
			else {
				account.setAccountNo(accountRepo.getMaxAccountNo()+1);
			}
			
			accountRepo.save(account);
		
			return "Savings Account with accountNo= "+account.getAccountNo()+" Created!";
			
		}
		else {
			Account fdAccount = new FDAccount();
			FDAccount account = (FDAccount)fdAccount;
			account.setBalance(BigDecimal.valueOf(25000));
			account.setOpeningDate(getCurrentDate());
			account.setUser(setUser);
			account.getInrestRate();
			account.setMaturityDate(getMaturityDate());
			if(accountRepo.getNullAccountNo() == null) {
				account.setAccountNo(120101L);
			}
			else {
				account.setAccountNo(accountRepo.getMaxAccountNo()+1);
			}
			
			accountRepo.save(account);
		
			return "FD Account with accountNo= "+account.getAccountNo()+" Created!";
		}
	}

	public Date getMaturityDate() {
		Calendar calender = Calendar.getInstance();
		calender.setTime(getCurrentDate());
		calender.add(Calendar.YEAR, 3);
		java.util.Date date = calender.getTime();
		Date sqldate = new Date(date.getTime());
		return sqldate;
	}
	
	public Date getCurrentDate() {
		java.util.Date date = new java.util.Date();
		Date sqlDate = new Date(date.getTime());
		return sqlDate;
		
	}
	
	

}
