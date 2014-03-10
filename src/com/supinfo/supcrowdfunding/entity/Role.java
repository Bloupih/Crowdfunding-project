package com.supinfo.supcrowdfunding.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	private int id;
	private String titre;
	
	public Role(){}
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	
	public void setTitre(String titre){
		this.titre = titre;
	}
	
	public String getTitre(){
		return this.titre;
	}
}
