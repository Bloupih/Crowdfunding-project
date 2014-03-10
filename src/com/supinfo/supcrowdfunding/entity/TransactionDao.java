package com.supinfo.supcrowdfunding.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class TransactionDao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private static EntityManager em;
	
	public TransactionDao(){}
	
	public static void openEM(){
		em = emf.createEntityManager();
	}
	
	public static void addTransaction(Transaction transaction){
		openEM();
		em.getTransaction().begin();
		em.persist(transaction);
		em.getTransaction().commit();
		em.clear();
		
		em.close();
		
	}
	
	public static void removeTransaction(Transaction transaction){
		int id = transaction.getId();
		openEM();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Transaction WHERE id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		
	}
	
	public static void removeTransaction(int id){
		Transaction transaction = findTransactionById(id);
		removeTransaction(transaction);
	}

	public static int transactionsCount(int id){
		openEM();
		Query query = em.createQuery("SELECT t FROM Transaction t");
		query.setParameter("id", id);
		List<Project> projects = query.getResultList();
		em.close();
		
		return projects.size();
	}

	public static int transactionsCountByProject(int id){
		openEM();
		Query query = em.createQuery("SELECT t FROM Transaction t WHERE idProject = :id");
		query.setParameter("id", id);
		List<Project> projects = query.getResultList();
		em.close();
		return projects.size();
	}
	
	public static boolean isEmpty(int id){
		return !(transactionsCount(id) != 0);
	}
	
	public static Transaction findTransactionById(int id){
		openEM();
		Transaction transaction = em.find(Transaction.class, id);
		em.close();
		return transaction;
		
	}
	
	public static List<Transaction> getAllTransactions(){
		openEM();
		Query query = em.createQuery("SELECT t FROM Transaction AS t ORDER BY t.id DESC");
		List<Transaction> transactions = query.getResultList();
		em.close();
	
		return transactions;
	}
	
	public static List<Transaction> getTransactionByProject(int id){
		openEM();
		Query query = em.createQuery("SELECT t FROM Transaction t WHERE t.idProject = :id");
		query.setParameter("id", id);
		List<Transaction> transactions = query.getResultList();
		
		em.close();
		return transactions;
	}
	
	public static float getContributedValueByProject(int id){
		openEM();
		Query query = em.createQuery("SELECT t FROM Transaction t WHERE t.idProject = :id");
		query.setParameter("id", id);
		List<Transaction> transactions = query.getResultList();
		float contributed = 0 ;
		for(Transaction tr : transactions){
			contributed += tr.getContributedValue();
		}
		
		em.close();
		return contributed;
	}
	
	
	public static int getNumberOfContributorsByProject(int id){
		openEM();
		Query query = em.createQuery("SELECT t FROM Transaction t WHERE t.idProject = :id");
		query.setParameter("id", id);
		List<Transaction> transactions = query.getResultList();
		List<Integer> idUsers = new ArrayList<Integer>();
		for ( Transaction t : transactions){
			if( !idUsers.contains(t.getIdUser()) )
			{
				idUsers.add(t.getIdUser());
			}
		}
		em.close();
		return idUsers.size();
	}
	
	public static float getContributedValueByUser(int id){		
		openEM();
		Query query = em.createQuery("SELECT t FROM Transaction t WHERE t.idUser = :id");
		query.setParameter("id", id);
		List<Transaction> transactions = query.getResultList();
		float contributed = 0 ;
		for(Transaction tr : transactions){
			contributed += tr.getContributedValue();
		}
		
		em.close();
		return contributed;
		
	}
}
