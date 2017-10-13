package com.umg.library.Library.controller;

import com.umg.library.Library.model.Customer;
import com.umg.library.Library.model.Inventory;
import com.umg.library.Library.repo.CustomerRepository;
import com.umg.library.Library.repo.InventoryRepository;
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
public class InventoryController {

    @Autowired
    InventoryRepository mRepository;

    @GetMapping(value = "/inventories", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Inventory> getAll() {
        List<Inventory> inventoryList = new ArrayList<>();
        Iterable<Inventory> inventories = mRepository.findAll();
        inventories.forEach(inventoryList::add);
        return inventoryList;
    }

    @PostMapping(value = "/inventory")
    public Inventory postInventory(@RequestBody Inventory inventory) {
        mRepository.save(new Inventory(
           inventory.getBook(),
           inventory.getQuantity()
        ));
        return inventory;
    }

    @DeleteMapping(value = "/inventory/{id}")
    public void deleteInventory(@PathVariable long id) {
        mRepository.delete(id);
    }

}
