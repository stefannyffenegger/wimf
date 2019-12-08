package main.java.ch.wimf.api;

import com.google.gson.Gson;
import main.java.ch.wimf.usermanagement.dao.UserDao;
import main.java.ch.wimf.usermanagement.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/")
public class Services {

    @GET
    @Path("/all")
    public Response getWins() {

        UserDao userDao = new UserDao();
        List<User> listUser = userDao.getAllUser();

        if(listUser == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Users found in Database").build();
        }

        Gson gson = new Gson();
        String json = gson.toJson(listUser);

        return Response.ok(json, MediaType.APPLICATION_JSON).build();


    }

    @GET
    @Path("/{uuid}")
    public Response getWins(@PathParam("uuid") String uuid) {

        if(uuid == null || uuid.trim().length() == 0) {
            return Response.serverError().entity("UUID cannot be blank").build();
        }

        UserDao userDao = new UserDao();

        User userByUuid = userDao.getUser( Integer.parseInt(uuid) );
        if(userByUuid == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found for UUID: " + uuid).build();
        }

        Gson gson = new Gson();
        String userJson = gson.toJson(userByUuid);
        return Response.ok(userJson, MediaType.APPLICATION_JSON).build();

    }

}

