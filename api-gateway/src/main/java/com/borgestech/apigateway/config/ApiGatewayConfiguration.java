package com.borgestech.apigateway.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		Function<PredicateSpec, Buildable<Route>> 
				route = r -> r.path("/conversion/**")
							  .filters(f -> 
							  			 f.rewritePath
							  			 ("/conversion/(?<segment>.*)", "/currency-conversion/${segment}"))
							  .uri("lb://currency-conversion-service");
		
		return builder.routes().route(route).build();
	}
}
