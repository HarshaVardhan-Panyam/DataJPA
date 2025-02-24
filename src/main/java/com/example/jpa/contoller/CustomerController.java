package com.example.jpa.contoller;

import com.example.jpa.model.Customer;
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
    public Customer postCustomerData(@RequestBody Customer customer){

        return customerService.dataPost(customer);
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
