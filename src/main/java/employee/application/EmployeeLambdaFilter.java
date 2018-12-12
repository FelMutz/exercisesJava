package employee.application;

import employee.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeLambdaFilter {

    public static void employeeLambdaFilter(){
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = scan.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(Employee.builder()
                        .name(fields[0])
                        .email(fields[1])
                        .salary(Double.parseDouble(fields[2])).build());
                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            double salary = scan.nextDouble();

            System.out.printf("Email of people whose salary is more than %.2f%n",salary);

            list.stream().filter(x -> x.getSalary() >salary)
                    .map(x -> x.getEmail())
                    .sorted()
                    .collect(Collectors.toList())
                    .stream()
                    .forEach(x -> System.out.println(x));

            System.out.printf("Sum of salary of people whose name starts with 'M': %.2f",
                    list.stream()
                    .filter(x -> x.getName().toUpperCase().charAt(0) == 'M')
                    .mapToDouble(x -> x.getSalary()).sum());


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            scan.close();
        }
    }
}
