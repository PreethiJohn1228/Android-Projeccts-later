import java.util.*;
public class AttendanceMaster {
    LinkedHashMap<Employee, Integer> employeeMap = new LinkedHashMap<>();
    ArrayList<Employee> filteredlist = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Set<Map.Entry<Employee, Integer>> entrySet = employeeMap.entrySet();
    public void getAttendance(ArrayList<Employee> employees) {
        String noOfdays;
        for (Employee employee : employees) {
            if(!(employeeMap.containsKey(employee))){
                if(!(filteredlist.contains(employee))) {
                    System.out.println(">>>  ENTER THE NO OF DAYS OF " + employee.getEmpId());
                    noOfdays = sc.nextLine();
                    while (!(noOfdays.matches("[0-9]+"))) {
                        System.out.println("*** ENTER THE VALID NO OF DAYS ***");
                        noOfdays = sc.nextLine();
                    }
                    int attendance = Integer.parseInt(noOfdays);
                    employeeMap.put(employee, attendance);
                }
            }
        }
    }
    public void showEligibleList() {
        System.out.println("\n--------------------------------------------------------------->>> ELIGIBLE LIST <<<---------------------------------------------------------------");
        System.out.printf("| %-8s | %-15s | %-30s | %-20s | %-10s | %-10s |%n", "ID", "NAME", "DEPARTMENT","DESIGNATION","SALARY","ATTENDANCE");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Map.Entry<Employee, Integer> entry1 : entrySet) {
            if (entry1.getValue() >= 10) {
                System.out.print(entry1.getKey());
                System.out.printf(" %-10s |",entry1.getValue());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void updateAttendance() {
        String employee_id, attendance;
        System.out.println(">>>  ENTER THE ID OF THE EMPLOYEE TO UPDATE ATTENDANCE");
        employee_id = sc.nextLine();
        while ((!(employee_id.matches("[0-9]+")))) {
            System.out.println("*** EITHER ID IS NOT IN THE EMPLOYEE LIST OR NOT IN CORRECT FORMAT ***\n");
            employee_id = sc.nextLine();
        }
        if (Employee.counter < Integer.valueOf(employee_id)){
            System.out.println("*** EMPLOYEE ID NOT FOUND ***");
        }
        else if(Integer.valueOf(employee_id)<1000) {
            System.out.println("*** EMPLOYEE ID NOT FOUND ***");
        }
        else {
            System.out.println(">>>  ENTER THE ATTENDANCE TO BE UPDATED");
            attendance = sc.nextLine();
            while (!(attendance.matches("[0-9]+"))) {
                System.out.println("*** ENTER VALID ATTENDANCE ***\n");
                attendance = sc.nextLine();
            }
            int updateAttendance = Integer.parseInt(attendance);
            for(Employee employees:TestEmployee.employee) {
                if (employees.getEmpId() == Integer.parseInt(employee_id)) {   //whether the given id is present in the employee list
                    employeeMap.put(employees, updateAttendance);
                    if(filteredlist.contains(employees)){
                        filteredlist.remove(employees);
                    }
                    break;
                }
            }
            System.out.println("UPDATED SUCCESSFULLY !!!");
        }
    }
    public void filterEmployeeList() {
        ArrayList<Employee> employeeArrayList = new ArrayList<>(employeeMap.keySet());
        for(Employee employee : employeeArrayList){
            if(employeeMap.get(employee)<10){
                filteredlist.add(employee);
                employeeMap.remove(employee);
            }
        }
        if(!(employeeMap.isEmpty())) {
            showEligibleList();
        }
        else{
            System.out.println("***  FILTERED LIST IS EMPTY  ***");
        }
    }
}
