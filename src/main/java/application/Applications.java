package application;

import currency.application.Currency;
import employee.application.*;
import matriz.application.Matriz;
import orderOfService.application.OrderOfService;
import thread.*;
import toCompare.SimpleParallel;
import withdrawWithTryCatch.application.Bank;

import java.util.Scanner;

public class Applications {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose the application you want");
        System.out.println("1 - Employee Registration");
        System.out.println("2 - Matriz");
        System.out.println("3 - Currency");
        System.out.println("4 - Order Of Service");
        System.out.println("5 - Withdraw With Try Catch");
        System.out.println("6 - Employee with read file and lambda");
        System.out.println("7 - Compare For, Stream and LongStream (Simple and Parallel)");
        System.out.println("8 - Execute two Threads");
        System.out.println("9 - Execute Threads That Compare For, Stream and LongStream (Simple and Parallel)");
        System.out.print("Choose: ");
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
            case 4:
                OrderOfService.orderOfService();
                break;
            case 5:
                Bank.bank();
                break;
            case 6:
                EmployeeLambdaFilter.employeeLambdaFilter();
                break;
            case 7:
                SimpleParallel.simpleParallel();
                break;
            case 8:
                TestTwoThread.testTwoThread();
                break;
            case 9:
                TestThreadStreams.testThreadStreams();
                break;
            default:
                System.out.println("Invalid choise!!");
        }
        scan.close();
    }

}
