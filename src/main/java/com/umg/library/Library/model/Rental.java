package com.umg.library.Library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Cristian Ramírez on 10/12/17.
 * UMG
 * cristianramirezgt@gmail.com
 */
@Entity
@Table(name = "rental")
public class Rental implements Serializable {

    private static final long serialVersionUID = 96717363612742303L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Customer customer;

    @Column(name = "dateOut")
    private Date dateOut;

    @Column(name = "dateIn")
    private Date dateIn;

    @Column(name = "status")
    private String status;

    public Rental() {
    }

    public Rental(Book book, Customer customer, Date dateOut, Date dateIn, String status) {
        this.book = book;
        this.customer = customer;
        this.dateOut = dateOut;
        this.dateIn = dateIn;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Renta[id=%d, book=%s, customer=%s," +
                "dateIn=%s, dateOut=%s, status=%s",
                id, book.getTitulo(), customer.getFirstName(),
                simpleDateFormat.format(dateIn),
                simpleDateFormat.format(dateOut), status);
    }
}
