package student;

/**
 * HourlyEmployee class is a subclass of the abstract employee
 */
public class HourlyEmployee extends AbstractEmployee {

    /**
     *
     * @param employeeName employeeName
     * @param employeeID employeeID
     * @param payRate employee payRate
     * @param preTaxDeductions Tax deductions before employee is paid
     * @param ytdEarnings current ytd earnings
     * @param ytdTaxesPaid current taxes paid
     */
    public HourlyEmployee(String employeeName, String employeeID,double payRate,double preTaxDeductions,  double ytdEarnings, double ytdTaxesPaid) {
        super(employeeName, employeeID, payRate, preTaxDeductions, ytdEarnings, ytdTaxesPaid);

        this.employeeType = EmployeeType.HOURLY;
    }

    /**
     *
     * @param hoursWorked hours worked for employee (HOURLY)
     * @return regularPay + overtimePay if hours <= 40
     */
    public double calculateGrossPay(double hoursWorked){
        double overtimeRate = 1.5;
        if (hoursWorked <= 40){
            return getPayRate() * hoursWorked;
        }else{
            double regularPay = 40 * getPayRate();
            double overtimePay = getPayRate() * overtimeRate * (hoursWorked - 40);
            return regularPay + overtimePay;
        }
    }


}
