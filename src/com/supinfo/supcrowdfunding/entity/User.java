package com.supinfo.supcrowdfunding.entity;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "users")
@XmlRootElement
public class User {
	
	@Id
	@GeneratedValue
	private int id;

	private String  pseudo;
	
	private String  password;
	
	private int role;
	
	private String mail;

	private String name;
	
	private String firstname;
	
	
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getPseudo()
	{
		return this.pseudo;
		
	}
	
	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo ;
		
	}
	public String getPassword()
	{
		return this.password;
		
	}
	
	public void setPassword(String password)
	{
		this.password = passwordToMd5(password) ;
		
	}
	
	 public static String passwordToMd5(String password){
	        String digest = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] hash = md.digest(password.getBytes("UTF-8"));
	           
	            //converting byte array to Hexadecimal String
	           StringBuilder sb = new StringBuilder(2*hash.length);
	           for(byte b : hash){
	               sb.append(String.format("%02x", b&0xff));
	           }
	          
	           digest = sb.toString();
	          
	        } catch (UnsupportedEncodingException ex) {
	        } catch (NoSuchAlgorithmException ex) {
	        }
	        return digest;
	    }
	
	public int getRole(){
		return this.role;
	}
	
	public String getRoleName(){
		return RoleDao.getRoleNameById(this.role).getTitre();
	}
	
	public void setRole(int role){
		this.role = role;
	}
	
	
	
	public String getMail(){
		return this.mail;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
		
	
	
	public String getFirstname(){
		return this.firstname;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}	
	
	
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int countproject(){
		int count = ProjectDao.findProjectsByCreators(this.id).size();
		return count;
	}
	
	public float moneyEngaged(){
		return TransactionDao.getContributedValueByUser(this.id);
	}
	
}
