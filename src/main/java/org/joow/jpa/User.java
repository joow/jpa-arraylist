package org.joow.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = User.FIND_BY_USERNAME,
        query = "select distinct u from User u join fetch u.emails where u.username = :username")
public class User {
    public static final String FIND_BY_USERNAME = "findByUsername";

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private ArrayList<Email> emails = new ArrayList<>();

    /**
     * Empty constructor needed by JPA.
     */
    @SuppressWarnings("unused")
    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User addEmail(String email) {
        emails.add(new Email(email, this));
        return this;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }
}
