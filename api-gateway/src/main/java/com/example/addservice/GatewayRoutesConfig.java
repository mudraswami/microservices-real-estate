package com.example.addservice;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouterFunction<ServerResponse> authRoute() {
        return route("auth-service")
                .GET("/auth/**", http())
                .filter(lb("AUTH-SERVICE"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> propertyRoute() {
        return route("property-service")
                .GET("/properties/**", http())
                .filter(lb("PROPERTY_SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> userRoute() {
        return route("user-service")
                .GET("/users/**", http())
                .filter(lb("USER-SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> visitRoute() {
        return route("visit-service")
                .GET("/visits/**", http())
                .filter(lb("VISIT_SERVICE"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> statusRoute() {
        return route("status-service")
                .GET("/status/**", http())
                .filter(lb("STATUS_SERVICE"))
                .build();
    }
}