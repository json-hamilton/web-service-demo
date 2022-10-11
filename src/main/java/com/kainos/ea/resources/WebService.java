package com.kainos.ea.resources;

import com.kainos.ea.core.ConnectionDB;
import com.kainos.ea.core.Employee;
import com.kainos.ea.dao.EmployeeDao;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/api")
@Api("Engineering Academy Dropwizard API")
public class WebService {
    @GET
    @Path("/print/{msg}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("msg") String message) {

        //read employeeid from path
        //get employee from db
        //map db fields to employee instance
        //return employee in response body

        //need dependencies
        //connection class
        //dao package
        //select employee based on id
        Message myMessage = new Message("Helo :) I am like the html please: " + message);

//        return Response.status(Response.Status.OK).

        return Response.ok(myMessage).build();
    }

    @GET
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") int id) throws SQLException {
        EmployeeDao dao = new EmployeeDao();
        Employee emp = dao.getEmployee(id,ConnectionDB.getConnection());
        return Response
                .status(Response.Status.OK)
                .entity(emp.toString())
                .build();
    }

    @GET
    @Path("/employee/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() throws SQLException {
        EmployeeDao dao = new EmployeeDao();
        List<Employee> emps = dao.getAllEmployees(ConnectionDB.getConnection());
        return Response
                .status(Response.Status.OK)
                .entity(emps)
                .build();
    }

    @POST
    @Path("/print")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sendMsg(Message message) {
        return "Hello from a jason yeooooooooooooooo lets go i love web service: " + message.getText();
    }

    @POST
    @Path("/emp")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendEmp(Employee emp) throws SQLException {
        EmployeeDao dao = new EmployeeDao();
        dao.insertEmployee(emp,ConnectionDB.getConnection());
        return Response.status(Response.Status.CREATED).build();
    }
}
