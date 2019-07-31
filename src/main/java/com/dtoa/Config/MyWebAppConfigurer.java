package com.dtoa.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping( "/**" ).allowedMethods( "PUT", "DELETE", "GET", "POST", "PATCH" ).allowedHeaders( "*" )
                .exposedHeaders( "access-control-allow-headers" );
    }
}
