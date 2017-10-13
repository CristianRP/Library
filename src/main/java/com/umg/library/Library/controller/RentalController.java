package com.umg.library.Library.controller;

import com.umg.library.Library.model.Inventory;
import com.umg.library.Library.model.Rental;
import com.umg.library.Library.repo.InventoryRepository;
import com.umg.library.Library.repo.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian Ramírez on 10/12/17.
 * UMG
 * cristianramirezgt@gmail.com
 */
@RestController
public class RentalController {

    @Autowired
    RentalRepository mRepository;

    @GetMapping(value = "/rentals", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rental> getAll() {
        List<Rental> inventoryList = new ArrayList<>();
        Iterable<Rental> inventories = mRepository.findAll();
        inventories.forEach(inventoryList::add);
        return inventoryList;
    }

    @PostMapping(value = "/rental")
    public Rental postRental(@RequestBody Rental rental) {
        mRepository.save(new Rental(
                rental.getBook(),
                rental.getCustomer(),
                rental.getDateIn(),
                rental.getDateOut(),
                rental.getStatus()
        ));
        return rental;
    }

    @DeleteMapping(value = "/rental/{id}")
    public void deleteRental(@PathVariable long id) {
        mRepository.delete(id);
    }

}
