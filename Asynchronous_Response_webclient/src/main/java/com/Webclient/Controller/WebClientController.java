package com.Webclient.Controller;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.Webclient.CustomerRequest;

import reactor.core.publisher.Flux;



@RestController
@RequestMapping("/web-client")
public class WebClientController {

	WebClient webclient;
	
	@PostConstruct
	public void init() {
		webclient = WebClient.builder().baseUrl("http://localhost:8080/customer")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_EVENT_STREAM_VALUE).build();
	}
	
	@GetMapping("/trackCustomer")
	public Flux<CustomerRequest> getAllCustomersStream() {
		return webclient.get().uri("/stream").retrieve().bodyToFlux(CustomerRequest.class);
	}
	
}
