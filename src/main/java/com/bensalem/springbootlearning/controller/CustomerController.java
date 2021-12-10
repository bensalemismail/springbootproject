package com.bensalem.springbootlearning.controller;

import com.bensalem.springbootlearning.model.Customer;
import com.bensalem.springbootlearning.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @GetMapping("/list")
    public List<Customer> listCustomers(){
        return customerService.listAllCustomers();
    }

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/list/{id}")
    public Customer listCustomers(@PathVariable("id") Long id){
        return customerService.findCustomerById(id);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteCustomer(@PathVariable("id") Long id){
        return customerService.deleteCustomerById(id);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

}
