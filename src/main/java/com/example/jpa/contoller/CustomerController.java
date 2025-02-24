package com.example.jpa.contoller;

import com.example.jpa.model.Customer;
import com.example.jpa.model.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jpa.service.*;

import java.util.List;

@RestController
public class CustomerController {

   CustomerService customerService;

   public CustomerController(CustomerService customerService){
       this.customerService = customerService;
   }

    @PostMapping("/post")
    public ResponseEntity<Customer> postCustomerData(@RequestBody CustomerDTO customerDTO){

        Customer customer = customerService.dataPost(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @GetMapping("/getAllData")
    public List<Customer> getListOfCustomerData(){

        return customerService.getData();
    }

    @GetMapping("/getBy/{id}")
    public Customer getCustomerData(@PathVariable int id) {

        return customerService.getDataById(id);
    }
    @GetMapping("/get/")
    public Customer getCustomerData1(@RequestParam int id){

       return customerService.getDataById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
       customerService.deleteById(id);
       return "Deleted successfully";
    }
}
