package org.joow.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Email {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    @ManyToOne(optional = false)
    private User user;

    /**
     * Empty constructor needed by JPA.
     */
    @SuppressWarnings("unused")
    public Email() {
    }

    public Email(String email, User user) {
        this.email = email;
        this.user = user;
    }
}
