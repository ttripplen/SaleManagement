/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import java.util.Scanner;
import model.HR;

/**
 *
 * @author ADMIN
 */
public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        int departmentChoice;
        Scanner scanner = new Scanner(System.in);
        HR hr = new HR();

        do {
            printMenu();
            System.out.println("----------------------------------------------");

            while (true) {
                try {
                    System.out.print("\nInput your choice from 1 to 11: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please input your choice must be integer from 1 to 11. Try again!");
                }
                scanner.close();
            }

            switch (choice) {
                case 1:
                    while (true) {
                        try {
                            System.out.println("1. Business Department");
                            System.out.println("2. Administrator Department");
                            System.out.println("Please choose the department:");
                            departmentChoice = Integer.parseInt(scanner.nextLine());

                            if (departmentChoice == 1 || departmentChoice == 2) {
                                break; // Thoát khỏi vòng lặp khi người dùng đã chọn phòng ban hợp lệ
                            } else {
                                System.out.println("\nPlease choose 1 or 2!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\nPlease input your choice as an integer (1 or 2). Try again!");
                        }
                    }

                    switch (departmentChoice) {
                        case 1:
                            hr.addBusinessEmployee();
                            break;
                        case 2:
                            hr.addAdministratorEmployee();
                            break;
                    }
                    break;
                case 2:
                    hr.printEmployeeList();
                    break;
                case 3:
                    while (true) {
                        try {
                            System.out.println("1. Business Department");
                            System.out.println("2. Administrator Department");
                            System.out.println("Please choose the department:");
                            departmentChoice = Integer.parseInt(scanner.nextLine());

                            if (departmentChoice == 1 || departmentChoice == 2) {
                                break; // Thoát khỏi vòng lặp khi người dùng đã chọn phòng ban hợp lệ
                            } else {
                                System.out.println("\nPlease choose 1 or 2!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\nPlease input your choice as an integer (1 or 2). Try again!");
                        }
                    }

                    switch (departmentChoice) {
                        case 1:
                            hr.printAllBussiness();
                            break;
                        case 2:
                            hr.printAllAdministrator();
                            break;
                    }
                    break;
                case 4:
                    hr.calculateAverageSalary();
                    break;
                case 5:
                    hr.searchHighestSalary();
                    break;
                case 6:
                    hr.searchLowestSalary();
                    break;
                case 7:
                    hr.searchAnEmployee();
                    break;
                case 8:
                    hr.sortEmployeeList();
                    break;
                case 9:
                    hr.removeAnEmployee();
                    break;
                case 10:
                    hr.updateAnEmployee();
                    break;
                case 11:
                    System.out.println("Bye bye, see you next time");
                    break;
                default:
                    System.out.println("Please choose from 1 to 11!");
                    break;
            }
        } while (choice != 11);

    }

    public static void printMenu() {
        System.out.println("\nWelcome to FPT Information System!");
        System.out.println("Please choose the desired action to perform:");
        System.out.println("1. Add a new employee profile.");
        System.out.println("   1.1.Business Department.");
        System.out.println("   1.2.Administrator Department.");
        System.out.println("2. Print all the employee.");
        System.out.println("3. Print all the employee by department.");
        System.out.println("   3.1.Business Department.");
        System.out.println("   3.2.Administrator Department.");
        System.out.println("4. Display the average salary of the entire company.");
        System.out.println("5. Display the highest earned salary.");
        System.out.println("6. Display the lowest earned salary.");
        System.out.println("7. Search for employees.");
        System.out.println("8. Sort and display employees.");
        System.out.println("9. Remove an employee.");
        System.out.println("10. Update employee information.");
        System.out.println("11. Quit!\n");

    }
}
