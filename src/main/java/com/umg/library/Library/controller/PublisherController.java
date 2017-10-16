package com.umg.library.Library.controller;

import com.umg.library.Library.model.Author;
import com.umg.library.Library.model.Publisher;
import com.umg.library.Library.repo.AuthorRepository;
import com.umg.library.Library.repo.PublisherRepository;
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
public class PublisherController {

    @Autowired
    PublisherRepository mRepository;

    @GetMapping(value = "/publishers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Publisher> getAll() {
        List<Publisher> publisherList = new ArrayList<>();
        Iterable<Publisher> authors = mRepository.findAll();
        authors.forEach(publisherList::add);
        return publisherList;
    }

    @PostMapping(value = "/publisher")
    public Publisher postPublisher(@RequestBody Publisher publisher) {
        mRepository.save(new Publisher(publisher.getName()));
        return publisher;
    }

    @DeleteMapping(value = "/publisher/{id}")
    public void deletePublisher(@PathVariable long id) {
        mRepository.delete(id);
    }

}
