package com.supinfo.supcrowdfunding.resource;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.supinfo.supcrowdfunding.entity.Category;
import com.supinfo.supcrowdfunding.entity.CategoryDao;
import com.supinfo.supcrowdfunding.entity.Project;

import java.util.List;


@Path("/category")
public class CategoryResource {
	
    @GET @Path("/all") @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories() {
        return CategoryDao.getAllCategories();
    }
    
    @GET @Path("/{id}") @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryById(@PathParam("id") int id) {
        return CategoryDao.findCategoryById(id);
    }
    
    @GET @Path("/name/{name}") @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryByName(@PathParam("name") String name) {
    	name = name.replace("_", " ");
        return CategoryDao.getCategoryByName(name);
    }
    
    @GET @Path("/projects/{id}") @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getCategoryProjectsById(@PathParam("id") int id) {
        return CategoryDao.getCategoryProjects(id);
    }
}
