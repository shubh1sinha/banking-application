package com.spring.service;

import com.spring.dto.UserDTO;
import com.spring.entity.Transaction;

public interface AdminServiceDAO {
	
	public String openAccount(UserDTO user);
	
	public String generateTransaction(Transaction tr);
}
