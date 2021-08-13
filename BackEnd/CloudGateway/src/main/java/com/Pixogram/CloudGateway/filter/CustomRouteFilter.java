package com.Pixogram.CloudGateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import com.Pixogram.CloudGateway.Client.AuthServiceProxy;
import com.Pixogram.CloudGateway.model.JwtRequestValidate;

import reactor.core.publisher.Mono;

@Component
public class CustomRouteFilter extends AbstractGatewayFilterFactory<CustomRouteFilter.Config> {
	
	@Autowired
	AuthServiceProxy authService;
	
	public CustomRouteFilter() {
		super(Config.class);
	}
	 
	@Override
	public GatewayFilter apply(Config config) {
	
		return (exchange, chain) -> {	
            ServerHttpRequest request = exchange.getRequest();
            if (!request.getHeaders().containsKey("Authorization")) {
            	System.out.println("Request Does not contain any authorization");
	
            };
            String authorizationHeader = request.getHeaders().get("Authorization").get(0);
            boolean isValidToken=false;
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            	String jwtToken = authorizationHeader.substring(7);
            	JwtRequestValidate jwtRequest = new JwtRequestValidate();
            	jwtRequest.setToken(jwtToken);
    			isValidToken= authService.validate(jwtRequest);
            }
    		if(!isValidToken){
    			return null;
    		}
    		
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("First post filter");
			}));
		};
	}

	public static class Config {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
}