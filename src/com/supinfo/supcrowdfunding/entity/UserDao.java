package com.supinfo.supcrowdfunding.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private static EntityManager em;
	
	public UserDao(){}	
	
	public static void openEM(){
		em = emf.createEntityManager();
	}	
	
	public static void addUser(User user){
		openEM();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.clear();
		
		em.close();
		
	}

	public static void editUser(User user){
		int id = user.getId();
		openEM();
		em.getTransaction().begin();
		Query query = em.createQuery(" UPDATE User SET name = :nom, firstname = :prenom, mail = :mail, password = :password WHERE id = :id");
		query.setParameter("id", id);
		query.setParameter("nom", user.getName() );
		query.setParameter("prenom", user.getFirstname() );
		query.setParameter("mail", user.getMail() );
		query.setParameter("password", user.getPassword() );
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	public static void removeUser(User user){
		int id = user.getId();
		openEM();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM User WHERE id = :id");
		query.setParameter("id", id);
		Query query2 = em.createQuery("DELETE FROM Project WHERE creator = :id");
		query2.setParameter("id", id);
		query2.executeUpdate();
		query.executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		
	}
	
	public static void removeUser(int id){
		User user = findUserById(id);
		removeUser(user);
	}
	
	public static User findUserById(int id){
		openEM();
		User user = em.find(User.class, id);
		em.close();
		return user;
	}
	
	public static User findUserByPseudo(String pseudoUser){
		openEM();
		Query query = em.createQuery("SELECT u FROM User AS u WHERE u.pseudo = :pseudo");
		query.setParameter("pseudo", pseudoUser);
		List<User> users = query.getResultList();
		em.close();
		try{
			return (User)users.get(0);
		}
		catch( IndexOutOfBoundsException e )
		{
			return null;
		}
	}
	
	public static List<User> getAllUsers(){
		openEM();
		Query query = em.createQuery("SELECT u FROM User AS u");
		List<User> users = query.getResultList();
		em.close();
	
		return users;
	}
	
	public static int getCountUsers(){
		return getAllUsers().size();
	}

	
	public static void updateRole(User usr, String newrole)
	{
		int r = -1;
		
		switch(newrole)
		{		
			case "admin":
				r = 0;
				break;
				
			case "user":
				r = 1;
				break;
	
			case "banned":
				r = 2;
				break;
		}
		
		int id = usr.getId();
		openEM();
		em.getTransaction().begin();
		Query query = em.createQuery("UPDATE User SET role = :role WHERE id= :id");
		query.setParameter("role", r);
		query.setParameter("id", id);
		query.executeUpdate();
		em.getTransaction().commit();
		
		em.close();
	}
	
	public static void updateRole(int id, String newrole)
	{
		User usr=findUserById(id);
		updateRole( usr , newrole);
	}
	
	public static void instanciateTable(){
		openEM();
		em.getTransaction().begin();
		
		User u = new User();
		u.setPseudo("bob");
		u.setPassword("bob");
		u.setRole(0);
		u.setName("bob");
		u.setFirstname("bob");
		u.setMail("bob@bob.bob");
		
		em.persist(u);
		em.getTransaction().commit();
		em.clear();
		
		em.close();
	}
}
