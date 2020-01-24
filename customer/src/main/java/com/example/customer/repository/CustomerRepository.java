package com.example.customer.repository;

import com.example.customer.model.Customer;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findCustomerByEmail(String email);
}

//public interface CustomerRepository extends JpaRepository<Customer, Long> {
//
////    Customer findByEmailAddress(String emailAddress);
//}
