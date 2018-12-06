package application;

import currency.application.Currency;
import employeeRegistration.application.EmployeeRegistration;
import matriz.application.Matriz;

import java.util.Scanner;

public class Applications {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Choose the application you want");
        System.out.println("1 - Employee Registration");
        System.out.println("2 - Matriz");
        System.out.println("3 - Matriz");

        int choice = scan.nextInt();

        switch (choice){
            case 1:
                EmployeeRegistration.employeeRegistration();
                break;
            case 2:
                Matriz.matriz();
                break;
            case 3:
                Currency.currency();
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
