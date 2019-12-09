package main.java.ch.wimf.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import main.java.ch.wimf.product.Fridge;
import main.java.ch.wimf.usermanagement.dao.UserDao;
import main.java.ch.wimf.usermanagement.model.User;
import org.hibernate.dialect.FrontBaseDialect;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fridge")
public class FridgeService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addNew")
    public Response addFridge(Fridge fridge) {

        if(fridge == null) {
            return Response.serverError().entity("Fridge cannot be blank").build();
        }

        UserDao<Fridge> userDao = new UserDao<>(Fridge.class);
        userDao.saveUser(fridge);

        return Response.status(Response.Status.OK).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllFridges() {

        UserDao<Fridge> userDao = new UserDao<>(Fridge.class);
        List<Fridge> listUser = userDao.getAllUser();

        if(listUser == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No Fridge found in Database").build();
        }

        Gson gson = new Gson();
        String json = gson.toJson(listUser);

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

}
