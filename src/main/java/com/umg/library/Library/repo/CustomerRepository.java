package com.umg.library.Library.repo;

import com.umg.library.Library.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Cristian Ramírez on 5/10/2017.
 * UMG
 * cristianramirezgt@gmail.com
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
