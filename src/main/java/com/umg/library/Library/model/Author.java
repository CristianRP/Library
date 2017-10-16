package com.umg.library.Library.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Cristian Ramírez on 10/12/17.
 * UMG
 * cristianramirezgt@gmail.com
 */
@Entity
@Table(name = "autor")
public class Author implements Serializable {

    private static final long serialVersionUID = -5680837725903266847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAuthor;

    @Column(name = "name")
    private String name;

    protected Author() {

    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Author[id=%d, name=%s]", idAuthor, name);
    }
}
