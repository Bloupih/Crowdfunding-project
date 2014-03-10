package com.supinfo.supcrowdfunding.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.supinfo.supcrowdfunding.entity.User;
import com.supinfo.supcrowdfunding.entity.UserDao;

@Path("/user")
public class UserResource {

	@GET @Path("/all") @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser() {
        return UserDao.getAllUsers();
    }
	
    @GET @Path("/id/{id}") @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") int id) {
        return UserDao.findUserById(id);
    }
    
    @GET @Path("/pseudo/{pseudo}") @Produces(MediaType.APPLICATION_JSON)
    public User getUserByPseudo(@PathParam("pseudo") String pseudo) {
        return UserDao.findUserByPseudo(pseudo);
    }
}
