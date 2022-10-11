package com.kainos.ea.dao;

import com.kainos.ea.core.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public void insertEmployee(Employee emp, Connection c) throws SQLException {
        String insertEmployeeQuery = "insert into Delivery values (?,?,?,?,?,?,?,?,?);";

        PreparedStatement preparedStatement = c.prepareStatement(insertEmployeeQuery);
        preparedStatement.setString(1, String.valueOf(emp.getDeliveryEmpID()));
        preparedStatement.setString(2, emp.getdName());
        preparedStatement.setString(3,  String.valueOf(emp.getSalary()));
        preparedStatement.setString(4, String.valueOf(emp.getBankNo()));
        preparedStatement.setString(5, String.valueOf(emp.getNin()));
        preparedStatement.setString(6, String.valueOf(emp.getBio()));
        preparedStatement.setString(7, "null");
        preparedStatement.setString(8, String.valueOf(emp.getFavTech()));
        preparedStatement.setString(9, String.valueOf(emp.getPhoneNumber()));

        preparedStatement.execute();
    }
    public Employee getEmployee(int empID, Connection c) throws SQLException {
        String selectEmployeeQuery = "select * from Delivery where deliveryEmpId = " + empID;

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(selectEmployeeQuery);

        rs.next();
        return new Employee(rs.getInt("deliveryEmpId"), rs.getString("dName"), Float.parseFloat(rs.getString("salary")), rs.getString("bankNo"), rs.getString("NIN"), rs.getString("bio"), null, rs.getString("favouriteTech"), rs.getString("phoneNo"));
    }
    public List<Employee> getAllEmployees(Connection c) throws SQLException {
        String selectEmployeeQuery = "select * from Delivery;";

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(selectEmployeeQuery);
        List<Employee> emps = new ArrayList<>();

        while (rs.next()){
            emps.add(new Employee(rs.getInt("deliveryEmpId"), rs.getString("dName"), Float.parseFloat(rs.getString("salary")), rs.getString("bankNo"), rs.getString("NIN"), rs.getString("bio"), null, rs.getString("favouriteTech"), rs.getString("phoneNo")));
        }
        return emps;
    }
}

