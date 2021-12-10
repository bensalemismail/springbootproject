package com.bensalem.springbootlearning.repository;

import com.bensalem.springbootlearning.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
