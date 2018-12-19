package withdrawWithTryCatch.application;

import org.springframework.stereotype.Service;
import withdrawWithTryCatch.entities.Account;
import withdrawWithTryCatch.exception.DomainException;

import javax.xml.stream.Location;
import java.util.Locale;
import java.util.Scanner;
@Service
public class Bank {

    public static void bank() {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter account data");

        System.out.print("Number: ");
        int number = scan.nextInt();

        System.out.print("Holder: ");
        scan.nextLine();
        String holder = scan.nextLine();

        System.out.print("Initial balance: ");
        Double balance = scan.nextDouble();

        System.out.print("Withdraw limit: ");
        Double withdrawLimit = scan.nextDouble();

        System.out.println();
        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.print("Enter amount for withdraw: ");
        Double withdraw = scan.nextDouble();


        try {
            acc.withdraw(withdraw);
            System.out.printf("New balance: %.2f%n", acc.getBalance());
        }
        catch (DomainException e){
            System.out.println("Error: " + e.getMessage());
        }

        scan.close();
    }
}
