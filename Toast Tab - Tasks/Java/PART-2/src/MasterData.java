import java.util.ArrayList;
public class MasterData {
    private ArrayList<Employee> masterData = new ArrayList<>();
    MasterData(ArrayList<Employee> employee){
        for(Employee employees : employee){
            masterData.add(employees);
            System.out.print(employees.toString());
            employees.setAllowance();
        }
    }
    int partition(ArrayList<Employee> employeeArrayList, int low, int high, String option) {
        int n = employeeArrayList.size();
        Employee temp;
        String person="",pivot="";
        double personSalary=0,pivotSalary=0;
        Employee pi = employeeArrayList.get(high);
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if(Integer.parseInt(option)==1){
                person= String.valueOf(employeeArrayList.get(j).getEmpId());
                pivot= String.valueOf(pi.getEmpId());
            }
            if(Integer.parseInt(option)==2){
                person= employeeArrayList.get(j).getEmpName();
                pivot=pi.getEmpName();
            }
            if(Integer.parseInt(option)==3){
                person=employeeArrayList.get(j).getDept();
                pivot=pi.getDept();
            }
            if(Integer.parseInt(option)==4){
                person=employeeArrayList.get(j).getDesg();
                pivot=pi.getDesg();
            }
            if(Integer.parseInt(option)==5){
                personSalary=employeeArrayList.get(j).getSal();
                pivotSalary= pi.getSal();
            }
            if (person.compareTo(pivot) <0) {
                i++;
                temp = employeeArrayList.get(i);
                employeeArrayList.set(i,employeeArrayList.get(j));
                employeeArrayList.set(j,temp);
            }
            if (personSalary < pivotSalary) {
                i++;
                temp = employeeArrayList.get(i);
                employeeArrayList.set(i,employeeArrayList.get(j));
                employeeArrayList.set(j,temp);
            }
        }
        temp = employeeArrayList.get(i+1);
        employeeArrayList.set(i+1,employeeArrayList.get(high));
        employeeArrayList.set(high,temp);
        return i+1;
    }
    void quick_sort(ArrayList<Employee> employeeArrayList, int low, int high, String option) {
        if (low < high) {
            int pi = partition(employeeArrayList, low, high, option);
            quick_sort(employeeArrayList, low, pi-1, option);
            quick_sort(employeeArrayList, pi+1, high, option);
        }
    }

}