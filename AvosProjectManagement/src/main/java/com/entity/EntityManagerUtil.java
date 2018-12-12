package com.entity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;



public class EntityManagerUtil {
  private static final EntityManagerFactory entityManagerFactory;
  static {
    try {
      entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");

    } catch (Throwable ex) {
    	System.err.println("Initial SessionFactory creation failed." + ex);
    	throw new ExceptionInInitializerError(ex);
     }
  }

  public static EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();

  }
}
