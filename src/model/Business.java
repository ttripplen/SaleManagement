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
public class Business extends Employee {
    //Properties of employee 
    private double revenue;
    private double comission;
    
    public Business() {
        
    }

    public Business(String name, String code, Gender gender, LocalDate birthdate, double basicSalary, int yearOfWork, double revenue) {
        super(name, code, gender, birthdate, basicSalary, yearOfWork);
        this.revenue = revenue;
        calculateRealSalary();
        //vì không có logic bên trong nên gọi ở hàm con
        calculateComission();
    }                          //khi người dùng muốn getRealSalary()

    private void calculateComission() {
        int a = 5000000;
        int b = 10000000;
        int c = 20000000;
        if (revenue < 5000000) 
            this.comission = 0; //this.comission để lấy property của comission của Business Class
        else if (revenue >= a && revenue < b) this.comission = 0.05;
        else if (revenue >= b && revenue < c) this.comission = 0.1;
        else this.comission = 0.2;
    }
    
    public double getComission() {
        return comission;
    }

    @Override
    public void setYearOfWork(int yearOfWork) {
        super.setYearOfWork(yearOfWork);
        calculateRealSalary();
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
        calculateRealSalary();
    }

    @Override
    public void setBasicSalary(double basicSalary) {
        super.setBasicSalary(basicSalary);
        calculateRealSalary();
    }
    
    @Override
    public void calculateRealSalary() {
       realSalary = basicSalary * salaryIndex + revenue * comission; 
    }

    @Override
    public String toString() {
        return "Business{" + super.toString() + "revenue=" + revenue + ", comission=" + comission + '}';
    }

    

   
    
    
    
}
