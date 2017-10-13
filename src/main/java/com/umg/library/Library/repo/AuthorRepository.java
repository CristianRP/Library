package com.umg.library.Library.repo;

import com.umg.library.Library.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Cristian Ramírez on 10/12/17.
 * UMG
 * cristianramirezgt@gmail.com
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
