import java.util.Scanner;
public class Employee {
    private int empID;
    private String name;
    private String department;
    private String designation;
    private Double salary;
    static int counter = 1000;
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
            System.out.println("***  ENTER THE VALID EMPLOYEE NAME WITH MINIMUM OF 3 CHARACTERS AND MAXIMUM OF 20 CHARACTERS   ***");
            name=sc.nextLine();
        }
        this.name=name.substring(0,1).toUpperCase()+name.substring(1);
    }
    public String getEmpName(){
        return name;
    }
    public void setDept(String departmentOption){
        String department[]={"Customer Service","Marketing & Sales","Resource & Development","IT"};
        while(!(departmentOption.matches("[1-4]"))){
            System.out.println("***  ENTER THE VALID OPTION !!! ***\n>>>  ENTER EMPLOYEE DESIGNATION\n   1. Customer Service \n    2. Marketing & Sales \n    3. Resource & Development \n    4. IT\nENTER THE OPTION");
            departmentOption = sc.nextLine();
        }
        int depNumber = Integer.parseInt(departmentOption);
        this.department=department[depNumber-1];
    }
    public String getDept(){
        return department;
    }
    public void setDesg(String designationOption){
        String designation[] = {"Manager","Director", "Software Developer", "Accountant"};
        while(!(designationOption.matches("[1-4]"))){
            System.out.println("***  ENTER THE VALID OPTION !!! ***\n>>>  ENTER EMPLOYEE DESIGNATION\n   1. Manager \n    2. Director \n    3. Software Developer \n    4. Accountant\nENTER THE OPTION");
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
                    System.out.println("***  ENTER THE SALARY ABOVE 1000.0   ***");
                    salary = sc.nextLine();
                }
            }
            else{
                System.out.println("*** ENTER VALID SALARY ***");
                salary = sc.nextLine();
            }
        }
    }
    public Double getSal(){ return salary;}
    public void setAllowance(){
        if(designation.compareTo("Manager") == 0){
            salary=this.salary+((20.0/100.0)*this.salary);
        }
        else{
            salary=this.salary+((10.0/100.0)*this.salary);
        }
    }
    public double initialSalary(){
        double originalsalary;
        if(designation.compareTo("Manager") == 0){
            originalsalary=salary/1.2;
        }
        else{
            originalsalary=salary/1.1;
        }
        return originalsalary;
    }
    public String toString() {
        String displaydetails;
        displaydetails = String.format("| %-8s | %-15s | %-30s | %-20s | %-10s |", empID, name, department,designation,salary);
        return displaydetails;
    }
}