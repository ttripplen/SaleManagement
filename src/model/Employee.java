/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public abstract class Employee {
    protected String name;
    protected String code;
    protected Gender gender;
    protected LocalDate birthdate;
    protected double basicSalary;
    protected int salaryIndex;
    protected double realSalary;
    protected int yearOfWork;

    public Employee() {
        
    }
    
    public Employee(String name, String code, Gender gender, LocalDate birthdate, double basicSalary, int yearOfWork) {
        this.name = name;
        this.code = code;
        this.gender = gender;
        this.birthdate = birthdate;
        this.basicSalary = basicSalary;
        this.yearOfWork = yearOfWork;
        calculateSalaryIndex();
     
    }
    
    private void calculateSalaryIndex() {
        salaryIndex = 1 + yearOfWork / 5;
    }
    
    public void setYearOfWork(int yearOfWork) {
        this.yearOfWork = yearOfWork;
        calculateSalaryIndex();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public abstract void calculateRealSalary();
    
    public double getRealSalary() {
        return realSalary;
    }

    @Override
    public String toString() {
        return "name=" + name + ", code=" + code + ", gender=" + gender + ", birthday=" + birthdate + ", basicSalary=" + basicSalary + ", salaryIndex=" + salaryIndex + ", realSalary=" + realSalary + ", yearOfWork=" + yearOfWork;
    }
    
    
    
}
