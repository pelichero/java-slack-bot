package edu.cvc.javabot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class WebConfiguration {

    @Autowired
    private RestTemplateRequestLoggerInterceptor restTemplateRequestLoggerInterceptor;

    @Bean
    public RestTemplate gwGitLabRestTemplate() {
	RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(clientHttpRequestFactory()));
	restTemplate.setInterceptors(Collections.singletonList(restTemplateRequestLoggerInterceptor));
	return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
	SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	requestFactory.setConnectTimeout(20000);
	requestFactory.setReadTimeout(20000);
	return requestFactory;
    }

}
