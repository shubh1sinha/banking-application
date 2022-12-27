package com.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.UserDTO;
import com.spring.entity.Account;
import com.spring.entity.User;
import com.spring.service.AdminServiceDAO;

@RestController
public class AdminRestController {
	
	@Autowired
	AdminServiceDAO adminService;
	
	
	@PostMapping("/admin/user")
	public ResponseEntity<String> createAccount(@RequestBody UserDTO user){
		String response =  adminService.openAccount(user);
		return ResponseEntity.ok(response);
	}
	

}
