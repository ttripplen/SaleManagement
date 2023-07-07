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
public class Administrator extends Employee {
    private double allowance;
    
    public Administrator() {
        
    }

    public Administrator(String name, String code, Gender gender, LocalDate birthdate, double basicSalary, int yearOfWork, double allowance) {
        super(name, code, gender, birthdate, basicSalary, yearOfWork);
        this.allowance = allowance;
        calculateRealSalary(); 
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
        calculateRealSalary();
    }
    
    @Override
    public void setBasicSalary(double basicSalary) {
        super.setBasicSalary(basicSalary);
        calculateRealSalary();
    }
    
    @Override
    public void setYearOfWork(int yearOfWork) {
        super.setYearOfWork(yearOfWork);
        calculateRealSalary();
    }
    
    @Override 
    public void calculateRealSalary() {
        realSalary = basicSalary * salaryIndex + allowance;
    }

    @Override
    public String toString() {
        return "Administrator{" + super.toString() + "allowance=" + allowance + '}';
    }
    
    
}
