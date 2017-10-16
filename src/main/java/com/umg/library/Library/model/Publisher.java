package com.umg.library.Library.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Cristian Ramírez on 10/12/17.
 * UMG
 * cristianramirezgt@gmail.com
 */
@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {

    private static final long serialVersionUID = -3800086519091135833L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPublisher;

    @Column(name = "name")
    private String name;

    public Publisher() {
    }

    public Publisher(String name) {
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
        return String.format("[PublisherController[id=%d, name=%s]",
                idPublisher, name);
    }
}
