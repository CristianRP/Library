package com.umg.library.Library.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Cristian Ramírez on 10/12/17.
 * UMG
 * cristianramirezgt@gmail.com
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = -1249416885430772526L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "anioPublicacion")
    private int anioPublicacion;

    @Column(name = "isbn")
    private String isbn;

    @Column( name = "edicion" )
    private String edicion;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "idPublisher")
    private Publisher publisher;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "idAuthor")
    private Author author;

    public Book() {
    }

    public Book(String titulo, int anioPublicacion, String isbn, String edicion, Publisher publisher, Author author) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
        this.edicion = edicion;
        this.publisher = publisher;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Book[id=%d, titulo=%s, anioPublicacion=%d," +
                "isbn=%s, publisher=%s, author=%s", id, titulo,
                anioPublicacion, isbn, publisher.getName(), author.getName());
    }
}
