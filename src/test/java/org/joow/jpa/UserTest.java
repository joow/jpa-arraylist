package org.joow.jpa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Optional;

import static org.junit.Assert.*;

public class UserTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeClass
    public static void initEntityManager() {
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
    }

    @Test
    public void testCreateUser() {
        User user = new User("me").addEmail("me@org.org").addEmail("me@com.com").addEmail("me@net.net");

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.clear();

        User searchedUser = em.createNamedQuery(User.FIND_BY_USERNAME, User.class).setParameter("username", "me")
                .getSingleResult();
        assertEquals(3, searchedUser.getEmails().size());
    }

    @AfterClass
    public static void closeEntityManager() {
        Optional.ofNullable(em).ifPresent(EntityManager::close);
        Optional.ofNullable(emf).ifPresent(EntityManagerFactory::close);
    }
}