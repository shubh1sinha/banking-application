package com.spring.service;

import com.spring.dto.TransactionDTO;
import com.spring.dto.UserDTO;

public interface AdminServiceDAO {
	
	public String openAccount(UserDTO user);
	
	public String generateTransaction(TransactionDTO tr);
}
