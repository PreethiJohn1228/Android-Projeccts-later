import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int choiceCount=1;
        ArrayList<Employee> employee = new ArrayList<>();
        String name,departmentOption, designationOption, salary;

        while(choiceCount==1){
            System.out.println("ENTER EMPLOYEE DETAILS ");
            System.out.println("EMPLOYEE NAME :  ");
            name = sc.nextLine();
            Employee employee1 = new Employee();
            employee1.setEmpName(name);

            System.out.println("ENTER EMPLOYEE DEPARTMENT  ");
            System.out.println("1. Customer Service \n 2. Marketing & Sales \n 3. Resource & Development \n 4. HR");
            departmentOption = sc.nextLine();
            employee1.setDept(departmentOption);

            System.out.println("ENTER EMPLOYEE DESIGNATION ");
            System.out.println("1. Manager \n 2. Director \n 3. Software Developer \n 4. Quality Analyser");
            designationOption = sc.nextLine();
            employee1.setDesg(designationOption);

            System.out.println("ENTER EMPLOYEE SALARY ");
            salary = sc.nextLine();
            employee1.setSal(salary);

            employee.add(employee1);
            System.out.println("Like to add employee details? If yes enter 1 else enter 0");
            choiceCount=sc.nextInt();
            sc.nextLine();
        }
        System.out.println();
        for(int i=0; i<employee.size(); i++) {
            System.out.print(employee.get(i).toString());
            employee.get(i).SetAllowance();
        }
    }
}