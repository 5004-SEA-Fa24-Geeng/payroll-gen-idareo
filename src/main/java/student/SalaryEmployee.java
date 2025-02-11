package student;

public class SalaryEmployee extends AbstractEmployee{

    public SalaryEmployee(String employeeName, String employeeID,double payRate,double preTaxDeductions,  double ytdEarnings, double ytdTaxesPaid) {
        super(employeeName, employeeID, payRate, preTaxDeductions, ytdEarnings, ytdTaxesPaid);

        this.employeeType = EmployeeType.SALARY;
    }


    /** calculates grossPay per pay period*/

    public double calculateGrossPay(double hoursWorked){
        return getPayRate()/24;
    }

}
