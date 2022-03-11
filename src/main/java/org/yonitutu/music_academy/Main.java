package org.yonitutu.music_academy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicacademy");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }
}
