package com.okta.webflux.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ReactiveRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ReactiveHandler handler) {

        return RouterFunctions
            .route(RequestPredicates
                .GET("/")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello);
    }
}
