package com.supinfo.supcrowdfunding.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProjectDao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");;
	private static EntityManager em = emf.createEntityManager();;
	
	public ProjectDao(){}
	
	public static void openEM(){
		em = emf.createEntityManager();
	}
	
	public static void addProject(Project project){
		openEM();
		em.getTransaction().begin();
		em.persist(project);
		em.getTransaction().commit();
		
		em.close();

	}
	
	public static void removeProject(Project project){
		int id = project.getId();
		openEM();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Project WHERE id = :id");
		Query query2 = em.createQuery("DELETE FROM Transaction WHERE idProject = :id");
		
		query.setParameter("id", id);
		query2.setParameter("id", id);
		
		query.executeUpdate();
		query2.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
	}
	
	public static void removeProject(int id){
		Project project = findProjectById(id);
		removeProject(project);
	}
	
	public static Project findProjectById(int projectId){
		openEM();
		Project project = em.find(Project.class, projectId);
		em.close();
		
		return project;
	}
	
	public static List<Project> getAllProjects(){
		openEM();
		Query query = em.createQuery("SELECT p FROM Project AS p");
		List<Project> projects = query.getResultList();
		
		em.close();
		return projects;
	}
	
	public static int getCountProjects(){
		return getAllProjects().size();
	}
	
	public static void contributeToProject(int idProj, int idUser, float contributed_price){
		openEM();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		
		Transaction transaction = new Transaction();
		transaction.setContributedValue(contributed_price);
		transaction.setIdProject(idProj);
		transaction.setIdUser(idUser);
		transaction.setDate(dateFormat.format(date));
		TransactionDao.addTransaction(transaction);
	}
	
	public static void editProject(Project project){

		openEM();
		em.getTransaction().begin();
		Query query = em.createQuery("UPDATE Project p SET p.content = :content , p.name = :titre , p.creator = :creator , p.price = :price , p.dateEnd = :dateEnd , p.dateStart = :dateStart , p.idCategory = :categoryid  WHERE p.id = :id");
		query.setParameter("id", project.getId());
		query.setParameter("creator", project.getCreatorId());
		query.setParameter("content", project.getContent());
		query.setParameter("titre", project.getName());
		query.setParameter("price", project.getPrice());
		query.setParameter("dateEnd", project.getDateEnd());
		query.setParameter("dateStart", project.getDateStart());
		query.setParameter("categoryid", project.getCategory().getId() );
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
	}
	
	public static List<Project> findProjectsByCreators(int id)
	{		
		
		openEM();
		Query query = em.createQuery("SELECT p FROM Project AS p WHERE creator = :id");
		query.setParameter("id", id);
		List<Project> projects = query.getResultList();
		em.close();
		try{
			return projects;
		}
		catch( IndexOutOfBoundsException e )
		{
			return null;
		}
	}

	
	
}
