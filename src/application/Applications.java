package application;

import officialRegistration.application.EmployeeRegistration;
import matriz.application.Matriz;
import officialRegistration.obj.Employee;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Applications {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Choose the application you want");
        System.out.println("1 - Employee Registration");
        System.out.println("2 - Matriz");

        int choice = scan.nextInt();

        switch (choice){
            case 1:
                EmployeeRegistration.employeeRegistration();
                break;
            case 2:
                Matriz.matriz();
                break;
            default:
                System.out.println("Invalid choise!!");
        }
        scan.close();
    }

    public static void printElement(String valor) {
        System.out.println(valor);
    }

    public static void printElement(Double valor) {
        System.out.println(valor);
    }
}
