package com.Async.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Async.dao.CustomerDao;
import com.Async.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	
	 public List<Customer> loadAllCustomers() {
	        long start = System.currentTimeMillis();
	        List<Customer> customers = dao.getCustomers();
	        long end = System.currentTimeMillis();
	        System.out.println("Total execution time : " + (end - start));
	        return customers;
	    }

	
	 public Flux<Customer> loadAllCustomersStream() {
	        long start = System.currentTimeMillis();
	        Flux<Customer> customers = dao.getCustomersStream();
	        long end = System.currentTimeMillis();
	        System.out.println("Total execution time : " + (end - start));
	        return customers;
	    }
}
