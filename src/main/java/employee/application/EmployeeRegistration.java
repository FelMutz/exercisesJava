package employee.application;


import employee.entities.Employee;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

@Service
public class EmployeeRegistration {
    public static void employeeRegistration() {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.print("How many employee will be registered?");
        int numbEmployee = scan.nextInt();


        var listEmployee = new ArrayList<Employee>();

        for(int i=1; i<=numbEmployee; i++){
            System.out.printf("Employee #%d:",i);
            System.out.println();
            System.out.print("Id: ");
            int id = scan.nextInt();

            System.out.print("Name: ");
            String name = scan.nextLine();

            System.out.print("Salary: ");
            double salary = scan.nextDouble();

            listEmployee.add(Employee.builder()
                    .id(id)
                    .name(name)
                    .salary(salary).build());

        }
        System.out.println("--------------------------");

        /*for (Employee t:listEmployee) {
            System.out.printf(t.toString());

        }*/

        listEmployee.stream().forEach(x -> System.out.println(x.toString()));
        System.out.println();
        System.out.print("Enter the employee id that will have salary increase : ");
        int id = scan.nextInt();

        Employee emp = listEmployee.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if(emp == null){
            System.out.println("This Id does not exist!");
        }else{
            System.out.printf("Enter the percentage:");
            double percent = scan.nextDouble();
            emp.increaseSalary(percent);
        }
        System.out.println("--------------------------");

        /*for (Employee t:listEmployee) {
            System.out.printf(t.toString());

        }*/
        listEmployee.stream().forEach(x -> System.out.println(x.toString()));

        scan.close();
    }
}
