package student;

public class HourlyEmployee extends AbstractEmployee {

    public HourlyEmployee(String employeeName, String employeeID,double payRate,double preTaxDeductions,  double ytdEarnings, double ytdTaxesPaid) {
        super(employeeName, employeeID, payRate, preTaxDeductions, ytdEarnings, ytdTaxesPaid);

        this.employeeType = EmployeeType.HOURLY;
    }

    public double calculateGrossPay(double hoursWorked){
        double overtimeRate = 1.5;
        if (hoursWorked < 40){
            return getPayRate() * hoursWorked;
        }else{
            double regularPay = 40 * getPayRate();
            double overtimePay = getPayRate() * overtimeRate * (hoursWorked - 40);
            return regularPay + overtimePay;
        }
    }


}
