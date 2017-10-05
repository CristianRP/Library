package com.umg.library.Library.controller;

import com.umg.library.Library.model.Customer;
import com.umg.library.Library.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Cristian Ramírez on 5/10/2017.
 * UMG
 * cristianramirezgt@gmail.com
 */

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository mRepository;

    @GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        Iterable<Customer> customers = mRepository.findAll();
        customers.forEach(customerList::add);
        return customerList;
    }

    @PostMapping(value = "/customer")
    public Customer postCustomer(@RequestBody Customer customer) {
        mRepository.save(new Customer(customer.getFirstName(),
                customer.getLastName(), customer.getCarne(),
                customer.getUserName(), customer.getPassword()));
        return customer;
    }

    @GetMapping(value = "/customer/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> findByLastName(@PathVariable String lastName) {
        List<Customer> customerList = mRepository.findByLastName(lastName);
        return customerList;
    }

    @DeleteMapping(value = "/customer/{id}")
    public void deleteCustomer(@PathVariable long id) {
        mRepository.delete(id);
    }
}
