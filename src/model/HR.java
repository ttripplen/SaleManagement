/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import util.Validation;

/**
 *
 * @author ADMIN
 */
public class HR {

    private ArrayList<Employee> employees;

    public HR() {
        employees = new ArrayList<>();
    }

    private String addName() {
        String name;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input name: ");
            name = scanner.nextLine().trim();
            if (name.length() > 0 && name.length() < 50) {
                return name;
            } else {
                System.out.println("The name cannot be left blank and must be up to 50 characters in length. Try again!");
            }
        }
    }

    private String addCode() {
        String code;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input code: ");
            code = scanner.nextLine().trim().toUpperCase();
            if (Validation.testCode(code)) {
                Employee x = searchAnEmployee(code);
                if (x == null) {
                    break;
                } else {
                    System.out.println("ID duplication! Try with another one");
                }
            } else {
                System.out.println("Code format is not correct. Try again!");
            }
        }
        return code;
    }

    private Gender addGender() {
        Gender gender;
        Scanner scanner = new Scanner(System.in);
        while (true) { //lặp vô tận              
            try {
                System.out.println("Input gender (TRUE[male] or FALSE[female]: ");
                gender = Gender.valueOf(scanner.nextLine().toUpperCase());
                break; //ĐÚNG THÌ THOÁT LẶP
            } catch (Exception e) {
                System.out.println("Gender format is not correct, please input in the format TRUE or FALSE. Try again!");
            }
        }
        return gender;
    }

    private LocalDate addBirthdate() {
        LocalDate birthdate;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input birthdate(dd/mm/yyyy): ");
                String birthdateStr = scanner.nextLine();
                birthdate = LocalDate.parse(birthdateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("Birthdate format is not correct, please input in the format dd/mm/yyyy . Try again!");
            }

        }
        return birthdate;
    }

    private double addBasicSalary() {
        double basicSalary;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input basic salary: ");
                basicSalary = Double.parseDouble(scanner.nextLine());
                if (basicSalary > 0) {
                    break;
                } else {
                    System.out.println("Basic Salary is invalid. Basic Salary must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("The data type of Basic Salary is not correct. Try again!");
            }
        }
        return basicSalary;
    }

    private int addYearOfWork() {
        int yearOfWork;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input year of work: ");
                yearOfWork = Integer.parseInt(scanner.nextLine());
                if (yearOfWork > 0) {
                break;
                } else {
                    System.out.println("Year Of Work is invalid. Year Of Work must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Year of work must be integer. Try again!");
            }
        }
        return yearOfWork;
    }

    private double addRevenue() {
        double revenue;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input revenue: ");
                revenue = Double.parseDouble(scanner.nextLine());

                if (revenue >= 0) {
                    break;
                } else {
                    System.out.println("Revenue is invalid. Revenue must be greater than or equal to 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("The data type of Revenue is not correct. Try again!");
            }
        }
        return revenue;
    }

    private double addAllowance() {
        double allowance;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input allowance: ");
                allowance = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The data type of Allowance is not correct. Try again!");
            }
        }
        return allowance;
    }

    public void addBusinessEmployee() {
        System.out.println("Input Business employees profile:");

        String name = addName();
        String code = addCode();
        Gender gender = addGender();
        LocalDate birthdate = addBirthdate();
        double basicSalary = addBasicSalary();
        int yearOfWork = addYearOfWork();
        double revenue = addRevenue();

        employees.add(new Business(name, code, gender, birthdate, basicSalary, yearOfWork, revenue));
        System.out.println("Add a new Business employee successfully!");
    }

    public void addAdministratorEmployee() {
        System.out.println("Input Administrator employee profile:");

        String name = addName();
        String code = addCode();
        Gender gender = addGender();
        LocalDate birthdate = addBirthdate();
        double basicSalary = addBasicSalary();
        int yearOfWork = addYearOfWork();
        double allowance = addAllowance();

        employees.add(new Administrator(name, code, gender, birthdate, basicSalary, yearOfWork, allowance));
        System.out.println("Add a new Administrator employee successfully!");

    }

    public void printEmployeeList() { //(2)
        if (employees.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("The list have " + employees.size() + " employee(s)");
        printAllBussiness();
        printAllAdministrator();

    }

    public void printAllBussiness() {
        for (Employee employee : employees) {
            if (employee instanceof Business) {
                System.out.println(employee);
            }
        }
    }

    public void printAllAdministrator() {
        for (Employee employee : employees) {
            if (employee instanceof Administrator) {
                System.out.println(employee.toString());
            }
        }
    }

    public void calculateAverageSalary() {
        double totalSalary = 0;
        double averageSalary;
        for (Employee employee : employees) {
            totalSalary += employee.getRealSalary();
        }

        averageSalary = totalSalary / employees.size();
        System.out.println("The average salary of the entire company is: " + averageSalary);
    }

    public void searchHighestSalary() {
        double maxSalary = employees.get(0).getRealSalary();
        int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getRealSalary() > maxSalary) {
                maxSalary = employees.get(i).getRealSalary();
                index = i;
            }
        }
        System.out.println("The highest salary in the entire company is: " + maxSalary);
        System.out.println("The profile of the employee with the highest salary in the company is: ");
        System.out.println(employees.get(index).toString());

    }

    public void searchLowestSalary() {
        double minSalary = employees.get(0).getRealSalary();
        int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getRealSalary() < minSalary) {
                minSalary = employees.get(i).getRealSalary();
                index = i;
            }
        }
        System.out.println("The lowest salary in the entire company is: " + minSalary);
        System.out.println("The profile of the employee with the lowest salary in the company is: ");
        System.out.println(employees.get(index).toString());
    }

    public Employee searchAnEmployee(String code) { //Hàm search code 
        if (employees.isEmpty()) {
            return null;
        }

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode().equalsIgnoreCase(code)) {
                return employees.get(i);
            }
        }

        return null;
    }

    public void searchAnEmployee() {
        Scanner scanner = new Scanner(System.in);
        String code;
        System.out.println("Input code to search a profile: ");
        code = scanner.nextLine();
        Employee x = searchAnEmployee(code);

        if (x == null) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("EMPLOYEE FOUND!");
            System.out.println("Here he/she is");
            System.out.println(x.toString());
        }
    }

    public void sortEmployeeList() {
        System.out.println("The employee list before sorting: ");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }

        for (int i = 0; i < employees.size() - 1; i++) {
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(i).getName().compareTo(employees.get(j).getName()) > 0) { //tăng dần theo tên 
                    Employee temp = employees.get(i);
                    employees.set(i, employees.get(j));
                    employees.set(j, temp);
                } else if (employees.get(i).getName().compareTo(employees.get(j).getName()) == 0) {
                    if (employees.get(i).getRealSalary() < employees.get(j).getRealSalary()) { //giảm dần theo lương
                        Employee temp = employees.get(i);
                        employees.set(i, employees.get(j));
                        employees.set(j, temp);
                    }
                }
            }
        }
        System.out.println("The employee list after sorting: "); 
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public void removeAnEmployee() {
        Scanner scanner = new Scanner(System.in);
        String code;
        System.out.println("Input code to remove a profile: ");
        code = scanner.nextLine();
        Employee x = searchAnEmployee(code);

        if (x == null) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("EMPLOYEE FOUND! ");
            employees.remove(x);
            System.out.println("Employee removed successfully!");
            System.out.println("The employee list after updated: ");
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }

        }

    }

    public void updateAnEmployee() {
//        String name = addName();
//        Gender gender = addGender();
//        LocalDate birthdate = addBirthdate();
//        double basicSalary = addBasicSalary();
//        int yearOfWork = addYearOfWork();
//        double revenue = addRevenue();
//        double allowance = addAllowance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input code to update a profile: ");
        String code = scanner.nextLine();
        Employee x = searchAnEmployee(code);
        if (x == null) {
            System.out.println("NOT FOUND! No employee to updated.");
        } else {
            System.out.println("EMPLOYEE FOUND!");
            System.out.println("Here he/she is before updating.");
            System.out.println(x.toString());
            System.out.println("Please update all the information:");
            if (x instanceof Business) {
                x.setName(addName());
                x.setBasicSalary(addBasicSalary());
                x.setYearOfWork(addYearOfWork());
                ((Business) x).setRevenue(addRevenue());
            } else {
                x.setName(addName());
                x.setBasicSalary(addBasicSalary());
                x.setYearOfWork(addYearOfWork());
            }
            System.out.println("Update completed successfully.");
            System.out.println("The information has been successfully updated:");
            System.out.println(x.toString());
        }
    }

}
