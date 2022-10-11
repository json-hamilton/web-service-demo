package com.kainos.ea.core;

import java.util.Objects;

public class Employee implements Comparable<Employee>{

    public static final int MIN_SALARY = 7_000;
    private int deliveryEmpID;
    protected String dName;
    private float salary;
    private String bankNo;
    private String nin;
    private String bio;
    private String image;
    private String favTech;
    private String phoneNumber;


    public Employee(int deliveryEmpID, String dName, float salary, String bankNo, String nin, String bio, String image, String favTech, String phoneNumber) {
        this.deliveryEmpID = deliveryEmpID;
        this.dName = dName;
        this.salary = salary;
        this.bankNo = bankNo;
        this.nin = nin;
        this.bio = bio;
        this.image = null;
        this.favTech = favTech;
        this.phoneNumber = phoneNumber;
    }

    public float getSalary()
    {
        return salary;
    }
    public void setSalary(float salary) {
            this.salary = salary;
    }

    public float calcPay()
    {
        return salary/12;
    }
    public String getName(){
        return dName;
    }
    public void setName(String name){
        dName = name;
    }
    public boolean equals(Employee emp)
    {
        return Objects.equals(dName, emp.dName);
    }
    public String toString()
    {
        return String.format("Employee %d: %s, £%,.2f." +"Monthly gross pay: £%,.2f.",deliveryEmpID, getName(),getSalary(),calcPay());
    }


    @Override
    public int compareTo(Employee x){
        return Float.compare(this.getSalary(), x.getSalary());
    }

    public int getDeliveryEmpID() {
        return deliveryEmpID;
    }

    public void setDeliveryEmpID(int deliveryEmpID) {
        this.deliveryEmpID = deliveryEmpID;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = null;
    }

    public String getFavTech() {
        return favTech;
    }

    public void setFavTech(String favTech) {
        this.favTech = favTech;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public int compareTo(Employee emp) {
//        return getName().split(" ")[1].compareTo(emp.getName().split(" ")[1]);
//    }
}
