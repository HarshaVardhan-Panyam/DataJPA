package com.example.jpa.service;

import com.example.jpa.model.Address;
import com.example.jpa.model.Customer;
import com.example.jpa.model.CustomerDTO;
import com.example.jpa.repository.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Transactional
    public Customer dataPost(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());

        // Set the office address
        Address officeAddress = customerDTO.getOfficeAddress();
        officeAddress.setCustomer(customer);  // Set the customer reference

        // Set the home addresses
        List<Address> homeAddresses = customerDTO.getHomeAddress();
        homeAddresses.forEach(address -> address.setCustomer(customer));  // Set the customer reference

        // Set the customer's addresses
        customer.setOfficeAddress(officeAddress);
        customer.setHomeAddress(homeAddresses);

        return customerRepo.save(customer);
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
