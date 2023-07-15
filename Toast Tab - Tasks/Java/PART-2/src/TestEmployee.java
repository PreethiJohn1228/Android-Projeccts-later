import java.util.ArrayList;
import java.util.Scanner;
public class TestEmployee {
    static ArrayList<Employee> employee = new ArrayList<>();
    static AttendanceMaster attendanceMaster = new AttendanceMaster();
    static MasterData masterData = new MasterData(employee);
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean flag=true;
        while(flag) {
            System.out.println("<<< PAYROLL MANAGEMENT SYSTEM >>>\n ENTER THE OPTION\n >>> 1. ADD EMPLOYEE\n >>> 2. ADD ATTENDANCE\n >>> " +
                    "3. UPDATE ATTENDANCE \n >>> 4. SORT \n >>> 5. DISPLAY DETAILS \n >>> 6. EXIT \n");
            String choice = sc.nextLine();
            String name, departmentOption, designationOption, salary;
            while (!(choice.matches("[1-6]"))) {
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
                    System.out.println("--------------------------------------------");
                    break;
                }
                case "2": {
                    if(employee.isEmpty()){
                        System.out.println("--------------------------------------------");
                        System.out.println("THE EMPLOYEE LIST IS EMPTY. \n >>> TO ADD THE EMPLOYEE DETAILS ENTER OPTION 1\n");
                        System.out.println("--------------------------------------------");
                        break;
                    }
                    else {
                        attendanceMaster.getAttendance(employee);
                        attendanceMaster.showEligibleList();
                        break;
                    }
                }
                case "3": {
                    if(!(attendanceMaster.employeeMap.isEmpty())){
                        attendanceMaster.updateAttendance();
                        break;
                    }
                    else {
                        System.out.println("THE EMPLOYEE LIST MAYBE EMPTY OR ATTENDANCE IS NOT ADDED \n " +
                                " KINDLY PRESS OPTION 1 ADD EMPLOYEE DETAIILS" +
                                " OR PRESS OPTION 2 TO ADD ATTENDANCE");
                        break;
                    }
                }
                case "4":{
                    if(employee.isEmpty()){
                        System.out.println("THE EMPLOYEE LIST IS EMPTY. \n >>> TO ADD THE EMPLOYEE DETAILS ENTER OPTION 1\n");
                        break;
                    }
                    System.out.println("## SORTING ## \n 1. ID Sorting\n 2. Name Sorting\n 3. Department Sorting\n 4. Designation Sorting\n 5. Salary Sorting\n" +
                            " ENTER THE OPTION \n");
                    String option = sc.nextLine();
                    while (!(option.matches("[1-5]"))) {
                        System.out.println(" >>> ENTER VALID OPTION\n");
                        option = sc.nextLine();
                    }
                    masterData.quick_sort(employee, 0, employee.size()-1, option);
                    for (int i = 0; i < employee.size(); i++) {
                        employee.get(i).toString();
                    }
                }
                case "5":{
                    System.out.println("-----------------------------------------------------------------------------");
                    MasterData masterData = new MasterData(employee);
                    System.out.println("-----------------------------------------------------------------------------");
                    break;
                }
                case "6" : {
                    flag=false;
                }
            }
        }
    }
}