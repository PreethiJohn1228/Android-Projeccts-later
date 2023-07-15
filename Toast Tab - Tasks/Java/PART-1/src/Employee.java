import java.util.Scanner;
public class Employee {
    private int empID;
    private String name;
    private String department;
    private String designation;
    private Double salary;
    private static int counter = 1000;
    public Employee() {
        empID=++counter;
    }
    Scanner sc=new Scanner(System.in);
    public void setEmpID(int empID){
        empID = ++counter;
        this.empID = empID;
    }
    public int getEmpId(){
        return empID;
    }
    public void setEmpName(String name){
        while(!(name.matches("[A-Za-z ]{3,20}+") )){
            System.out.println("Re-enter the employee name");
            name=sc.nextLine();
        }
        this.name =name.substring(0,1).toUpperCase()+name.substring(1);
    }
    public String getEmpName(){
        return name;
    }
    public void setDept(String departmentOption){
        String department[]={"Customer Service","Marketing & Sales","Resource & Development","HR"};
        while(!(departmentOption.matches("[1-4]"))){
            System.out.println("Enter valid option");
            departmentOption = sc.nextLine();
        }
        int depNumber = Integer.parseInt(departmentOption);
        this.department =department[depNumber-1];
    }
    public String getDept(){
        return department;
    }
    public void setDesg(String designationOption){
        String designation[] = {"Manager","Director", "Software Developer", "Quality Analyser"};
        while(!(designationOption.matches("[1-4]"))){
            System.out.println("Enter valid option ");
            designationOption = sc.nextLine();
        }
        int desgNumber=Integer.parseInt(designationOption);
        this.designation =designation[desgNumber-1];
    }
    public String getDesg(){
        return designation;
    }
    public void setSal(String salary){
        while (!((salary.matches("([0-9]*)\\.([0-9]+)")) )){
            System.out.println("Enter valid salary");
            salary = sc.nextLine();
        }
        if(Double.parseDouble(salary)<5000.0){
            System.out.println("Enter salary above 50000.0 ");
            salary = sc.nextLine();
        }
        this.salary =Double.parseDouble(salary);
    }
    public Double getSal(){ return salary;}
    public Employee(String name, String department, String  designation, Double salary){
        empID = ++counter;
        this.name =name;
        this.department =department;
        this.designation =designation;
        this.salary =salary;
    }
    public void SetAllowance(){
        System.out.println("  Salary is " + salary);
        double allowanceSalary;
        if(designation.compareTo("Manager") == 0){
            allowanceSalary=this.salary +((20.0/100.0)*this.salary);
        }
        else{
            allowanceSalary=this.salary +((10.0/100.0)*this.salary);
        }
        System.out.println("The allowance of the employee is " +String.format("%.2f", allowanceSalary));
        allowanceSalary-=this.salary;
        System.out.println("The difference is " + String.format("%.2f", allowanceSalary));
    }
    public String toString() {
        return "EMPLOYEE DETAILS \n ID = " + empID + ", Name = " +
                name + ", Department = " + department + ", Designation = " + designation + "," ;
    }
}