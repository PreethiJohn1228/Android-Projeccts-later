import java.util.LinkedHashMap;
import java.util.Set;
public class SalCalculator {
    public void calculateSalary(LinkedHashMap<Employee,Integer> employeeHashMap){
        double pf,gross,net;
        Set<Employee> employeeSet = employeeHashMap.keySet();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-8s | %-15s | %-30s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "NAME", "DEPARTMENT","DESIGNATION","SALARY","ALLOWANCE","GROSS","PF","NET");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Employee employee : employeeSet) {
            pf = (10 * employee.getSal())/100;
            gross = employee.getSal()+employee.initialSalary();
            net = gross - pf;
            System.out.print(employee.toString());
            System.out.printf(" %-10s | %-10s | %-10s | %-10s |",String.format("%.2f", employee.initialSalary()),String.format("%.2f",gross),String.format("%.2f",pf),String.format("%.2f",net));
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}