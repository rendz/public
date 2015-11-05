package com.luxoft.springdata.app;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServerConfiguration {
	@Bean
	public EmbeddedServletContainerFactory undertowFactory() {
		return new UndertowEmbeddedServletContainerFactory();
	}
}
