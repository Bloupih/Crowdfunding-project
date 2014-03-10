package com.supinfo.supcrowdfunding.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.supinfo.supcrowdfunding.entity.Category;
import com.supinfo.supcrowdfunding.entity.CategoryDao;
import com.supinfo.supcrowdfunding.entity.Transaction;
import com.supinfo.supcrowdfunding.entity.TransactionDao;

@Path("/transaction")
public class TransactionResource {

	@GET @Path("/all") @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getAllTransactions() {
        return TransactionDao.getAllTransactions();
    }
	
    @GET @Path("/project/{id}") @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getTransactionsByIdProject(@PathParam("id") int id) {
        return TransactionDao.getTransactionByProject(id);
    }
}
