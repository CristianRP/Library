package com.umg.library.Library.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Cristian Ramírez on 10/12/17.
 * UMG
 * cristianramirezgt@gmail.com
 */
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    private static final long serialVersionUID = -7720540316994048190L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Book book;

    @Column(name = "quantity")
    private int quantity;

    public Inventory() {
    }

    public Inventory(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("InventoryRepository[id=%d, book=%s",
                id, book.getTitulo());
    }
}
