package com.example.jpa.service;

import com.example.jpa.model.Customer;
import com.example.jpa.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer dataPost(Customer customerData){

        return customerRepo.save(customerData);
    }

    public List<Customer> getData(){

        return customerRepo.findAll();
    }

    public Customer getDataById(int id){

        return customerRepo.findById(id).orElse(new Customer());
    }

    public void deleteById(int id){

         customerRepo.deleteById(id);
    }
}
