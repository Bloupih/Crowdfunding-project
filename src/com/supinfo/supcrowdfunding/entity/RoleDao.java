package com.supinfo.supcrowdfunding.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RoleDao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private static EntityManager em;
	
	public static void openEM(){
		em = emf.createEntityManager();
	}	
	
	public static Role getRoleNameById(int id){
		openEM();
		Query query = em.createQuery("SELECT r FROM Role AS r WHERE id = :id");
		query.setParameter("id", id);
		List<Role> roles = query.getResultList();
		em.close();
		try{
			return roles.get(0);
		}
		catch(IndexOutOfBoundsException ex)
		{
			return null;
		}
		
	}
	
	public static void instanciateTable(){
		
		openEM();
		em.getTransaction().begin();
		Role r1 = new Role();
		r1.setId(0);
		r1.setTitre("Admin");
		em.persist(r1);
		em.getTransaction().commit();
		em.clear();

		em.getTransaction().begin();
		Role r2 = new Role();
		r2.setId(1);
		r2.setTitre("User");
		em.persist(r2);
		em.getTransaction().commit();
		em.clear();

		em.getTransaction().begin();
		Role r3 = new Role();
		r3.setId(2);
		r3.setTitre("Banned");
		em.persist(r3);
		em.getTransaction().commit();
		em.clear();
		em.close();
	}
}
