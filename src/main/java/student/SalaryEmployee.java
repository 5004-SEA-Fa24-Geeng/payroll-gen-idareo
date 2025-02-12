package student;

public class SalaryEmployee extends AbstractEmployee {

    /**
     * @param employeeName     employeeName.
     * @param employeeID       employeeID.
     * @param payRate          payRate for salary employee.
     * @param preTaxDeductions preTaxDeductions.
     * @param ytdEarnings      current ytdEarnings.
     * @param ytdTaxesPaid     current ytdTaxesPaid.
     */
    public SalaryEmployee(String employeeName, String employeeID, double payRate, double preTaxDeductions, double ytdEarnings, double ytdTaxesPaid) {
        super(employeeName, employeeID, payRate, preTaxDeductions, ytdEarnings, ytdTaxesPaid);

    }


    /**
     * @param hoursWorked hours worked for employee (HOURLY).
     * @return calculates grossPay for hourly employee.
     */

    public double calculateGrossPay(double hoursWorked) {
        return getPayRate() / 24;
    }

}
