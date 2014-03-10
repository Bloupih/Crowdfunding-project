package com.supinfo.supcrowdfunding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "categories")
@XmlRootElement
public class Category {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@Column(columnDefinition="TEXT")
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCountProject()
	{
		return CategoryDao.projectsCount(this.id);
	}
	

}
