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
            System.out.println(">>>  RE-ENTER THE EMPLOYEE NAME");
            name=sc.nextLine();
        }
        this.name=name.substring(0,1).toUpperCase()+name.substring(1);
    }
    public String getEmpName(){
        return name;
    }
    public void setDept(String departmentOption){
        String department[]={"Customer Service","Marketing & Sales","Resource & Development","HR"};
        while(!(departmentOption.matches("[1-4]"))){
            System.out.println(">>>  ENTER THE VALID OPTION");
            departmentOption = sc.nextLine();
        }
        int depNumber = Integer.parseInt(departmentOption);
        this.department=department[depNumber-1];
    }
    public String getDept(){
        return department;
    }
    public void setDesg(String designationOption){
        String designation[] = {"Manager","Director", "Software Developer", "Quality Analyser"};
        while(!(designationOption.matches("[1-4]"))){
            System.out.println(">>>  ENTER THE VALID OPTION");
            designationOption = sc.nextLine();
        }
        int desgNumber=Integer.parseInt(designationOption);
        this.designation=designation[desgNumber-1];
    }
    public String getDesg(){
        return designation;
    }
    public void setSal(String salary){
        double sal;
        while(true){
            if(salary.matches("([0-9]*)\\.([0-9]+)|([0-9]+)")){
                sal = Double.parseDouble(salary);
                if(sal >= 1000) {
                    this.salary= sal;
                    break;
                }
                else{
                    System.out.println(">>>  ENTER THE SALARY ABOVE 1000.0");
                    salary = sc.nextLine();
                }
            }
            else{
                System.out.println(">>>  ENTER VALID SALARY");
                salary = sc.nextLine();
            }
        }
    }
    public Double getSal(){ return salary;}
    public Employee(String empName, String dept, String  desgn, Double sal){
        empID = ++counter;
        this.name=empName;
        this.department=dept;
        this.designation=desgn;
        this.salary=sal;
    }
    public void setAllowance(){
        System.out.println("  Salary is " +salary);
        double allowanceSalary;
        if(designation.compareTo("Manager") == 0){
            allowanceSalary=this.salary+((20.0/100.0)*this.salary);
        }
        else{
            allowanceSalary=this.salary+((10.0/100.0)*this.salary);
        }
        System.out.println("    Allowance Salary  " +String.format("%.2f", allowanceSalary));
        allowanceSalary-=this.salary;
        System.out.println("    Allowance " + String.format("%.2f", allowanceSalary));
    }
    public String toString() {
        return ">> EMPLOYEE DETAILS \n ID = " + empID + ", Name = " +
                name + ", Department = " + department + ", Designation = " + designation + "," ;
    }
}
