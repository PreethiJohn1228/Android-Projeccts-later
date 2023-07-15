import java.util.ArrayList;
import java.util.Scanner;

public class Sample {
    static ArrayList<Employee> employee = new ArrayList<>();
    static AttendanceMaster attendanceMaster = new AttendanceMaster();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean flag=true;
        while(flag) {
            System.out.println("ENTER THE OPTION\n >>> 1. ADD EMPLOYEE\n >>> 2. ADD ATTENDANCE\n >>> 3. UPDATE ATTENDANCE \n >>> 4. DISPLAY DETAILS \n >>> 5. EXIT \n");
            String choice = sc.nextLine();
            String name, departmentOption, designationOption, salary;
            while (!(choice.matches("[1-5]"))) {
                System.out.println(" ***   ENTER VALID OPTION   ***");
                choice = sc.nextLine();
            }
            switch (choice) {
                case "1": {
                    System.out.println("---------- ENTER EMPLOYEE DETAILS ----------");
                    System.out.println(">>>  EMPLOYEE NAME :  ");
                    name = sc.nextLine();
                    Employee employee1 = new Employee();
                    employee1.setEmpName(name);

                    System.out.println(">>>  ENTER EMPLOYEE DEPARTMENT  ");
                    System.out.println(" 1. Customer Service \n 2. Marketing & Sales \n 3. Resource & Development \n 4. HR");
                    departmentOption = sc.nextLine();
                    employee1.setDept(departmentOption);

                    System.out.println(">>>  ENTER EMPLOYEE DESIGNATION ");
                    System.out.println(" 1. Manager \n 2. Director \n 3. Software Developer \n 4. Quality Analyser");
                    designationOption = sc.nextLine();
                    employee1.setDesg(designationOption);

                    System.out.println(">>>  ENTER EMPLOYEE SALARY ");
                    salary = sc.nextLine();
                    employee1.setSal(salary);

                    employee.add(employee1);
                    break;
                }

                case "2": {
                    attendanceMaster.getAttendance(employee);
                    attendanceMaster.showEligibleList();
                }

                case "3": {

                }
                case "4":{
                    System.out.println("-----------------------------------------------------------------------------");
                    MasterData employees = new MasterData(employee);
                    System.out.println("-----------------------------------------------------------------------------");
                }
                case "5" : {
                    flag=false;
                }

            }
        }

    }
}
