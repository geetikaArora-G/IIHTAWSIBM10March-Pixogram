package com.Pixogram.CloudGateway.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Pixogram.CloudGateway.model.JwtRequestValidate;


@FeignClient(name="AuthenticationManager",url="http://localhost:8082")
public interface AuthServiceProxy {
	
	@RequestMapping(method= RequestMethod.POST ,value="/auth/validate")
	public boolean validate(@RequestBody JwtRequestValidate  jwtRequestValidate);
	

}
