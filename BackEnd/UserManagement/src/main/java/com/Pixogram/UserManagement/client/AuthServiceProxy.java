package com.Pixogram.UserManagement.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Pixogram.UserManagement.model.JwtRequest;


@FeignClient(name="AuthenticationManager",url="http://localhost:8082")
public interface AuthServiceProxy {
	
	@RequestMapping(method= RequestMethod.POST ,value="/auth/authenticate")
	public String authenticate(@ModelAttribute JwtRequest jwtRequest);
	

}
