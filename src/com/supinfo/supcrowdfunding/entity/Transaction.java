package com.supinfo.supcrowdfunding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "transactions")
@XmlRootElement
public class Transaction {
	
	@Id
	@GeneratedValue
	private int id;
	private int idProject;
	private int idUser;
	private float contributedValue;
	private String date;
	
	public Transaction(){}
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	
	public void setIdProject(int id){
		this.idProject = id;
	}
	
	public int getIdProject(){
		return this.idProject;
	}
	
	public void setIdUser(int id){
		this.idUser = id;
	}
	
	public int getIdUser(){
		return this.idUser;
	}

	public String getNameUser(){
		return UserDao.findUserById(this.idUser).getPseudo();
	}
	
	public String getNameProject(){
		Project project = ProjectDao.findProjectById(this.idProject);
		return project.getName();
	}
	
	public void setContributedValue(float price)
	{
		this.contributedValue = price;
	}
	
	public float getContributedValue()
	{
		return this.contributedValue;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String string) {
		this.date = string;
	}
	
}