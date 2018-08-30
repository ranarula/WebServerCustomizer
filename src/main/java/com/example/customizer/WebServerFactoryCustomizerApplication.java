package com.example.customizer;

import io.undertow.server.handlers.DisallowedMethodsHandler;
import io.undertow.util.HttpString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.undertow.ConfigurableUndertowWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class WebServerFactoryCustomizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServerFactoryCustomizerApplication.class, args);
	}
}

@Configuration
class UndertowCustomizer implements
		WebServerFactoryCustomizer<ConfigurableUndertowWebServerFactory> {

	@Override
	public void customize(final ConfigurableUndertowWebServerFactory undertowWebServerFactory) {
		undertowWebServerFactory.addDeploymentInfoCustomizers(deploymentInfo ->
				deploymentInfo.addInitialHandlerChainWrapper(handler ->
						new DisallowedMethodsHandler(handler, HttpString.tryFromString(HttpMethod.TRACE.name())))
		);
	}
}