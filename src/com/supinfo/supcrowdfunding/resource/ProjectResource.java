package com.supinfo.supcrowdfunding.resource;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.supinfo.supcrowdfunding.entity.Project;
import com.supinfo.supcrowdfunding.entity.ProjectDao;

import java.util.List;


@Path("/project")
public class ProjectResource {
	
    @GET @Path("/all") @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjects() {
        return ProjectDao.getAllProjects();
    }
    
    @GET @Path("/{id}") @Produces(MediaType.APPLICATION_JSON)
    public Project getProjectById(@PathParam("id") int id) {
        return ProjectDao.findProjectById(id);
    }
}

