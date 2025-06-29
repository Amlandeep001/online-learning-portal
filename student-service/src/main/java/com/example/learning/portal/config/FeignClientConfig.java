package com.example.learning.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.learning.portal.handler.CustomErrorDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignClientConfig
{
	@Bean
	ErrorDecoder errorDecoder()
	{
		return new CustomErrorDecoder();
	}
}
