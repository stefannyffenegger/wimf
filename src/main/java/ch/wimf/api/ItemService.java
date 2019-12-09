package main.java.ch.wimf.api;

import com.google.gson.Gson;
import main.java.ch.wimf.product.Fridge;
import main.java.ch.wimf.product.Item;
import main.java.ch.wimf.usermanagement.dao.UserDao;
import main.java.ch.wimf.usermanagement.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/item")
public class ItemService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addItem(Item item) {

        if(item == null) {
            return Response.serverError().entity("Item cannot be blank").build();
        }

        UserDao<Item> userDao = new UserDao<>(Item.class);
        userDao.saveUser(item);

        return Response.status(Response.Status.OK).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllItems() {

        UserDao<Item> userDao = new UserDao<>(Item.class);
        List<Item> listUser = userDao.getAllUser();

        if(listUser == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Items found in Database").build();
        }

        Gson gson = new Gson();
        String json = gson.toJson(listUser);

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

}
