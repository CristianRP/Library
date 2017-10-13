package com.umg.library.Library.controller;

import com.umg.library.Library.model.Book;
import com.umg.library.Library.model.Customer;
import com.umg.library.Library.repo.BookRepository;
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
public class BookController {

    @Autowired
    BookRepository mRepository;

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();
        Iterable<Book> books = mRepository.findAll();
        books.forEach(bookList::add);
        return bookList;
    }

    @PostMapping(value = "/book")
    public Book postBook(@RequestBody Book book) {
        mRepository.save(new Book(book.getTitulo(), book.getAnioPublicacion(),
                book.getIsbn(), book.getEdicion(), book.getPublisher(),
                book.getAuthor()));
        return book;
    }

    @DeleteMapping(value = "/book/{id}")
    public void deleteBook(@PathVariable long id) {
        mRepository.delete(id);
    }


}
