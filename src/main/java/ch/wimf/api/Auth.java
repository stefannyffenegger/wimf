package main.java.ch.wimf.api;

import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import main.java.ch.wimf.usermanagement.dao.UserDao;
import main.java.ch.wimf.usermanagement.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import main.java.ch.wimf.authentication.Login;

/**
 * /auth Basic Authentication Service
 *
 * @author Stefan Nyffenegger
 */
@Path("/auth")
public class Auth {

    /**
     * Login, JSON Format: {username:'username', password:'password'}
     *
     * @param auth
     * @param request
     * @return Response
     */
    @POST
    @Path("/{auth}")
    public Response login(@PathParam("auth") String auth, @Context HttpServletRequest request) {
        // Check if Request is empty
        if (auth == null || auth.trim().length() == 0) {
            return Response.serverError().entity("No Credentials received!").build();
        }

        HttpSession session = request.getSession(); // Get Session Attribute
        UserDao userDao = new UserDao();

        Gson gson = new Gson();
        Login authJSON = gson.fromJson(auth, Login.class); // Parse JSON to Login Obj
        User user = userDao.getUser(authJSON.getUsername()); // Search user

        // If user doesn't exist
        if (user == null || !user.getUsername().equals("")) {
            return Response.status(Response.Status.BAD_REQUEST).entity("User " + authJSON.getUsername() + " was not found!").build();
        }

        // Check Password
        if (user.getPassword().equals(authJSON.getPassword())) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Wrong Password!").build();
        }

        session.setAttribute("username", authJSON.getUsername()); // Set Session Attribute
        // Send Status 200 OK
        return Response.status(Response.Status.ACCEPTED).entity("Login Successful!").build();
    }

    /**
     * Logout
     *
     * @param request
     * @return Response
     */
    @POST
    @Path("/logout")
    public Response logout(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(); // Get Session
        session.invalidate(); // Invalidate session
        return Response.status(Response.Status.ACCEPTED).entity("Logout Successful!").build();
    }

    /**
     * Register
     *
     * @param register
     * @return Response
     */
    @POST
    @Path("/register")
    public Response register(@PathParam("register") String register) {
        // Check if Request is empty
        if (register == null || register.trim().length() == 0) {
            return Response.serverError().entity("No Credentials received!").build();
        }

        UserDao userDao = new UserDao();

        Gson gson = new Gson();
        User registerJSON = gson.fromJson(register, User.class); // Parse JSON to Login Obj
        User user = userDao.getUser(registerJSON.getUsername()); // Search user
        
        // If user doesn't exist
        if (user == null || !user.getUsername().equals("")) {
            userDao.saveUser(user); // Save the new user
        }else{
            return Response.status(Response.Status.BAD_REQUEST).entity("User " + registerJSON.getUsername() + " already exists!").build();
        }
        
        return Response.status(Response.Status.ACCEPTED).entity("Register Successful!").build();
    }
}
