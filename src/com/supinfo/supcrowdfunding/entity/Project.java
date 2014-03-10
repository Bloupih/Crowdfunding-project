package com.supinfo.supcrowdfunding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "projects")
@XmlRootElement
public class Project {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	
	@Column(columnDefinition="TEXT")
	private String content;
	private float price;
	private int creator;
	private String dateStart;
	private String dateEnd;
	private int idCategory;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getContributedPrice() {
	    return	TransactionDao.getContributedValueByProject(this.id);
	}

	public int getNumberOfContributions()
	{
		return TransactionDao.transactionsCountByProject(this.id);
	}
	
	public String getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	
	public String getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	public Category getCategory() {
		return CategoryDao.findCategoryById(this.idCategory);
	}
	
	public void setCategory(Category category) {
		this.idCategory = category.getId();
	}
	
	public void setCreator(int creator)
	{
		this.creator = creator;
	}
	
	public int getCreator()
	{
		return this.creator;
	}
	
	public String getPseudoCreator()
	{
		String username = UserDao.findUserById(this.creator).getPseudo();
		return username;
	}
	
	public int getCreatorId(){
		return this.creator;
	}
	
	public String getMiniDescription()
	{
		int description_length = this.content.length();
		String description_truncated ;
		if(description_length > 110)
		{
			description_truncated = this.content.substring(0, 107)+ "..." ;
		}
		else
		{
			description_truncated = this.content ;
		}
		return description_truncated;
	}

	public int getNumberOfContributors()
	{
		return TransactionDao.getNumberOfContributorsByProject(id);
	}
}
