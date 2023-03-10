package com.spring.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.TransactionDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.Account;
import com.spring.entity.FDAccount;
import com.spring.entity.SavingsAccount;
import com.spring.entity.Transaction;
import com.spring.entity.User;
import com.spring.repo.AccountRepository;
import com.spring.repo.TransactionRepo;

@Service
public class AdminServce implements AdminServiceDAO {

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private TransactionRepo transactionRepo;
	
	

	@Override
	/***
	 * @author shusinha5 {@summary User is registered and at the same time either FD
	 *         or RD account is created}
	 */
	public String openAccount(UserDTO user) {
		User setUser = new User();
		setUser.setFirstName(user.getFirstName());
		setUser.setLastName(user.getLastName());
		setUser.setAadharNo(user.getAadharNo());
		setUser.setPanCard(user.getPanCard());
		setUser.setPhoneNo(user.getPhoneNo());
		setUser.setAddress(user.getAddress());
		if (user.getAccountType().equals("Savings")) {
			Account savingsAccount = new SavingsAccount();
			SavingsAccount account = (SavingsAccount) savingsAccount;
			account.setBalance(BigDecimal.valueOf(user.getBalance()));
			account.setUser(setUser);
			account.setOpeningDate(getCurrentDate());
			account.getInrestRate();
			account.setAccountType(user.getAccountType());
			if (accountRepo.getNullAccountNo() == null) {
				account.setAccountNo(12101L);
			} else {
				account.setAccountNo(accountRepo.getMaxAccountNo() + 1);
			}
			accountRepo.save(account);
			return "Savings Account with accountNo= " + account.getAccountNo() + " Created For user="+setUser.getFirstName()+" "+setUser.getLastName();

		} else {
			Account fdAccount = new FDAccount();
			FDAccount account = (FDAccount) fdAccount;
			account.setBalance(BigDecimal.valueOf(user.getBalance()));
			account.setOpeningDate(getCurrentDate());
			account.setUser(setUser);
			account.getInrestRate();
			account.setMaturityDate(getMaturityDate(user.getPeriod()));
			account.setAccountType(user.getAccountType());
			if (accountRepo.getNullAccountNo() == null) {
				account.setAccountNo(120101L);
			} else {
				account.setAccountNo(accountRepo.getMaxAccountNo() + 1);
			}
			account.setRenewDate(true); 
			accountRepo.save(account);
			return "FD Account with accountNo= " + account.getAccountNo() + " Created!";
		}
	}

	@Transactional
	@Override
	public String generateTransaction(TransactionDTO transaction) {
		Optional<Account> toAccount = accountRepo.findById(transaction.getToAccount());
		Optional<Account> fromAccount = accountRepo.findById(transaction.getToAccount());
		Transaction newTransaction = new Transaction();
		if(toAccount.isPresent()) {
		if (fromAccount.get().getAccountType().equals("Savings") && toAccount.get().getAccountType().equals("Savings")) {
			if (fromAccount.get().getBalance().intValue() >= transaction.getAmount().intValue()) {
				accountRepo.toAccountTransaction(transaction.getToAccount(), transaction.getAmount());
				accountRepo.fromAccountTransaction(transaction.getFromAccount(), transaction.getAmount());
				newTransaction.setTransactionDate(getCurrentDate());
				newTransaction.setAmount(transaction.getAmount());
				newTransaction.setFromAccount(transaction.getFromAccount());
				newTransaction.setToAccount(transaction.getToAccount());
				transactionRepo.save(newTransaction);
				return "Transaction with amount= " + transaction.getAmount() + " to Account No.= "
						+ transaction.getToAccount() + " successfull!. Current balance in the account is= "+fromAccount.get().getBalance().subtract(newTransaction.getAmount());
			} else {
				return "Low Balance in the account";
			}

		} else {
			return "Transaction in FD Account is not possible.";
		}
	}
		else {
			return "Account not found!";
		}

	}

	public Date getMaturityDate(int period) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(getCurrentDate());
		calender.add(Calendar.YEAR, period);
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
