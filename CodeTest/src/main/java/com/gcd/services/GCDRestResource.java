package com.gcd.services;


import com.gcd.dao.AccountRepository;
import com.gcd.dao.DatabaseService;
import com.gcd.dao.GCDRepository;
import com.gcd.dto.QueueObj;
import com.gcd.utility.QueueUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/gcd/number-queue")
public class GCDRestResource {

    QueueUtility queueUtility;
    private final AccountRepository accountRepository;

    @Autowired
    public GCDRestResource(GCDRepository gcdRepository, AccountRepository accountRepository) {
        this.queueUtility = new QueueUtility(new DatabaseService(gcdRepository));
        this.accountRepository = accountRepository;
    }

    @GET
    @Path("/list/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList(@PathParam("userId") String userId){
        this.validateUser(userId);
        List<QueueObj> listOfValues = queueUtility.getListOfValues();
        GenericEntity<List<QueueObj>> list = new GenericEntity<List<QueueObj>>(listOfValues){};
        // or we can convert obj to json using Gson
        return Response.status(200)
                .entity(list).build();
    }

    @POST
    @Path("/push/{userId}/{integer1}/{integer2}")
    public Response push(@PathParam("userId") String userId,@PathParam("integer1") int integer1  , @PathParam("integer2") int integer2){
        try {
            this.validateUser(userId);
            queueUtility.push(integer1,integer2);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Post unSuccessful" )
                    .build();
        }
        return Response.status(200)
                .entity("Post Successful" )
                .build();
    }

    private void validateUser(String userId) {
        this.accountRepository.findByUsername(userId).orElseThrow(
                () -> new UserNotFoundException(userId));
    }

}
