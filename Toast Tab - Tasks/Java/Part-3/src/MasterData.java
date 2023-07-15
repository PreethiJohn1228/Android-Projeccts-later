import java.util.ArrayList;
public class MasterData {
    ArrayList<Employee> masterData = new ArrayList<>();
    MasterData(ArrayList<Employee> employee){
        for(Employee employees : employee){
            masterData.add(employees);
        }
    }
    public void displayDetails(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-8s | %-15s | %-30s | %-20s | %-10s |%n", "ID", "NAME", "DEPARTMENT","DESIGNATION","SALARY");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        for(Employee employees : TestEmployee.employee){
            System.out.print(employees.toString());
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }
    public void employeeSort(String option, String choice){
        switch (option){
            case "1": {
                if (choice.equals("1")) {
                    masterData.sort((e1, e2)->e1.getEmpId()-e2.getEmpId());
                }
                else{
                    masterData.sort((e1, e2)->e2.getEmpId()-e1.getEmpId());
                }
                break;
            }
            case "2": {
                if (choice.equals("1")) {
                    masterData.sort((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()));
                }
                else{
                    masterData.sort((e1,e2) -> e2.getEmpName().compareTo(e1.getEmpName()));
                }
                break;
            }
            case "3": {
                if (choice.equals("1")) {
                    masterData.sort((e1,e2)->e1.getDept().compareTo(e2.getDept()));
                }
                else{
                    masterData.sort((e1,e2)->e2.getDept().compareTo(e1.getDept()));
                }
                break;
            }
            case "4": {
                if (choice.equals("1")) {
                    masterData.sort((e1,e2)->e1.getDesg().compareTo(e2.getDesg()));
                }
                else{
                    masterData.sort((e1,e2)->e2.getDesg().compareTo(e1.getDesg()));
                }
                break;
            }
            case "5": {
                if (choice.equals("1")) {
                    masterData.sort(( e1, e2)->e1.getSal().compareTo(e2.getSal()));
                }
                else{
                    masterData.sort((e1,e2)->e2.getSal().compareTo(e1.getSal()));
                }
                break;
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-8s | %-15s | %-30s | %-20s | %-10s |%n", "ID", "NAME", "DEPARTMENT", "DESIGNATION", "SALARY");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        for (Employee employee1 : masterData) {
            System.out.println(employee1.toString());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }
}