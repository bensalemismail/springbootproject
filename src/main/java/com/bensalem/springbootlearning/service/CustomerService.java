package com.bensalem.springbootlearning.service;

import com.bensalem.springbootlearning.model.Customer;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer findCustomerById(Long id);

    List<Customer> listAllCustomers();

    Customer updateCustomer(Customer customer);

    boolean deleteCustomerById(Long id);
}
