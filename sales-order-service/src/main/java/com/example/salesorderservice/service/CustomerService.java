package com.example.salesorderservice.service;

import com.example.salesorderservice.model.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerServiceProxy customerServiceProxy;

    public CustomerService(CustomerServiceProxy customerServiceProxy){
        this.customerServiceProxy = customerServiceProxy;
    }

    @HystrixCommand(fallbackMethod = "defaultCustomerService")
    public Customer getByEmail(String email)
    {
        System.out.println("inside the customerService");
        return customerServiceProxy.getByEmail(email);
    }

    private Customer defaultCustomerService(String email) {
        Customer customer = new Customer();

        System.out.println("Came to default method");

        customer.setEmail(email);
        customer.setId(-1L);

        System.out.println("The default id set is " + customer.getId());
        return customer;
    }
}
