package com.umg.library.Library.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Cristian Ramírez on 5/10/2017.
 * UMG
 * cristianramirezgt@gmail.com
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -281358127679367603L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column( name = "firstName")
    private String firstName;

    @Column( name = "lastName")
    private String lastName;

    @Column( name = "carne")
    private String carne;

    @Column( name = "userName")
    private String userName;

    @Column( name = "password")
    private String password;

    protected Customer() {

    }

    public Customer(String firstName, String lastName, String carne, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.carne = carne;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s, carne='%s', userName='%s, password='%s]",
                id, firstName, lastName, carne, userName, password);
    }
}
