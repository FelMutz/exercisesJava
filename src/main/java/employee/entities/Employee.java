package employee.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Double salary;



    public void increaseSalary(double percentage){
        salary += salary*percentage/100;
    }


    public String toString(){
        return id
                +", Name: "
                +name
                +", Salary: "
                +String.format("%.2f",salary)
                +"%n";
    }
}
