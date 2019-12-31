package com.mycompany.rest_crud;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/login")
public class CRUD {

    private static List<String> list = new ArrayList<>(Arrays.asList("peter", "jason", "john"));

    @GET
    public String list() {
        return new Gson().toJson(list);
    }

    @GET
    @Path("/{id}")
    public String get(@PathParam("id") int id) {
        return new Gson().toJson(list.get(id));
    }

    @POST
    public String add(@FormParam("value") String value) {
        list.add(value);
        return "add ok";
    }

    @PUT
    @Path("/{id}")
    public String update(@PathParam("id") int id, @FormParam("value") String value) {
        list.set(id, value);
        return "update ok";

    }
    
    @DELETE
    @Path("/{id}")
    public String del(@PathParam("id")int id){
    list.remove(id);
    return "delete ok";
    }

}
