package com.cg.spring_boot_microservice_3_api_gateway.request;

import feign.codec.Encoder;
import feign.codec.Decoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;

import feign.form.spring.SpringFormEncoder;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.converter.HttpMessageConverter;

@Configuration
public class FeignConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(
            @Value("${service.security-secure-key-username}") String username,
            @Value("${service.security-secure-key-password}") String password) {
        return new BasicAuthRequestInterceptor(username, password);
    }

    @Bean
    @Primary
    public Encoder multipartFormEncoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }
    
    public Decoder feignDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new ResponseEntityDecoder(new SpringDecoder(messageConverters));
    }
}

