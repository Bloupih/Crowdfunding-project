package com.supinfo.supcrowdfunding.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CategoryDao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private static EntityManager em;
	
	public CategoryDao(){}
	
	public static void openEM(){
		em = emf.createEntityManager();
	}
	
	public static void addCategory(Category category){
		openEM();
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
		em.clear();
		
		em.close();
		
	}
	
	public static void removeCategory(Category category){

		

		int id = category.getId();
		List<Project> projects = getCategoryProjects(id);
		for(Project p : projects){
			ProjectDao.removeProject(p);
		}
		
		openEM();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Category WHERE id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		
	}
	
	public static void removeCategory(int id){
		Category category = findCategoryById(id);
		removeCategory(category);
	}
	
	public static int projectsCount(int id){
		Category category = findCategoryById(id);
		openEM();
		Query query = em.createQuery("SELECT p FROM Project p WHERE idCategory = :id");
		query.setParameter("id", id);
		List<Project> projects = query.getResultList();
		
		em.close();
		
		return projects.size();
	}
	
	public static boolean isEmpty(int id){
		return !(projectsCount(id) != 0);
	}
	
	public static Category findCategoryById(int id){
		openEM();
		Category category = em.find(Category.class, id);
		em.close();
		return category;
		
	}
	
	public static List<Category> getAllCategories(){
		openEM();
		Query query = em.createQuery("SELECT c FROM Category AS c");
		List<Category> categories = query.getResultList();
		em.close();
	
		return categories;
	}
	
	public static int getCountCategories(){
		return getAllCategories().size();
	}
	public static List<Project> getCategoryProjects(int id){
		openEM();
		Query query = em.createQuery("SELECT p FROM Project p WHERE idCategory = :id");
		query.setParameter("id", id);
		List<Project> projects = query.getResultList();
		
		em.close();
		return projects;
	}
	
	public static void editCategory(Category category){
		int id = category.getId();
		openEM();
		em.getTransaction().begin();
		Query query = em.createQuery(" UPDATE Category SET name = :nom, content = :content WHERE id = :id");
		query.setParameter("id", id);
		query.setParameter("nom", category.getName() );
		query.setParameter("content", category.getContent() );
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

	public static Category getCategoryByName(String name) {
		openEM();
		Query query = em.createQuery("SELECT c FROM Category AS c WHERE c.name = :name");
		query.setParameter("name", name);
		List<Category> categories = query.getResultList();
		em.close();
		try{
			return (Category)categories.get(0);
		}
		catch( IndexOutOfBoundsException e )
		{
			return null;
		}
	}	
}
