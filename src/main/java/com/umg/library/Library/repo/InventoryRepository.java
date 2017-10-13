package com.umg.library.Library.repo;

import com.umg.library.Library.model.Inventory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Cristian Ramírez on 10/12/17.
 * UMG
 * cristianramirezgt@gmail.com
 */
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
