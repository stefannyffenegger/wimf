package main.java.ch.wimf.api;

import com.google.gson.Gson;
import main.java.ch.wimf.usermanagement.dao.UserDao;
import main.java.ch.wimf.usermanagement.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/user")
public class UserService {

    @GET
    @Path("/all")
    public Response getAllUsers() {

        UserDao<User> userDao = new UserDao<>(User.class);
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
    public Response getUserById(@PathParam("uuid") String uuid) {

        if(uuid == null || uuid.trim().length() == 0) {
            return Response.serverError().entity("UUID cannot be blank").build();
        }

        UserDao<User> userDao = new UserDao<>(User.class);

        User userByUuid = userDao.getUser( Integer.parseInt(uuid) );
        if(userByUuid == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found for UUID: " + uuid).build();
        }

        Gson gson = new Gson();
        String userJson = gson.toJson(userByUuid);
        return Response.ok(userJson, MediaType.APPLICATION_JSON).build();

    }

}

