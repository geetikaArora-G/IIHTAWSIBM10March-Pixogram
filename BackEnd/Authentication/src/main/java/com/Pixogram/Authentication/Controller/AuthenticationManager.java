package com.Pixogram.Authentication.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Pixogram.Authentication.Util.JwtUtil;
import com.Pixogram.Authentication.model.JwtRequest;
import com.Pixogram.Authentication.model.JwtRequestValidate;


@RestController
@CrossOrigin(origins = "*")
public class AuthenticationManager {
	
	@RequestMapping(value = "/auth/authenticate", method = RequestMethod.POST)
	public String createAuthenticationToken(@RequestBody JwtRequest jwtRequest)
			throws Exception {

        JwtUtil jwtTokenUtil = new JwtUtil();
		final String token = jwtTokenUtil.generateToken(jwtRequest.getUserName());
		return token;
	}
	@RequestMapping(value = "/auth/validate", method = RequestMethod.POST)
	public boolean validateToken(@RequestBody JwtRequestValidate jwtRequestValidate)
			throws Exception {

        JwtUtil jwtTokenUtil = new JwtUtil();
		return jwtTokenUtil.validateToken(jwtRequestValidate.getToken());
	}

}
