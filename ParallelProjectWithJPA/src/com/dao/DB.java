package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {
	public EntityManager getConnection()
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bala");
		EntityManager em=emf.createEntityManager();
		return em;
	}
}
