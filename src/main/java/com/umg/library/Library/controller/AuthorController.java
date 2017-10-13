package com.umg.library.Library.controller;

import com.umg.library.Library.model.Author;
import com.umg.library.Library.repo.AuthorRepository;
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
public class AuthorController {

    @Autowired
    AuthorRepository mRepository;

    @GetMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> getAll() {
        List<Author> authorList = new ArrayList<>();
        Iterable<Author> authors = mRepository.findAll();
        authors.forEach(authorList::add);
        return authorList;
    }

    @PostMapping(value = "/author")
    public Author postAuthor(@RequestBody Author author) {
        mRepository.save(new Author(author.getName()));
        return author;
    }

    @DeleteMapping(value = "/author/{id}")
    public void deleteAuthor(@PathVariable long id) {
        mRepository.delete(id);
    }

}
