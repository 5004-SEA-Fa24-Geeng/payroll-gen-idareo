package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract Employee class implements IEmployee interface.
 */
public abstract class AbstractEmployee implements IEmployee {

    /** variable for EmployeeName. */
    private String employeeName;
    /** variable for EmployeeID.*/
    private String employeeID;
    /** variable for employee PayRate. */
    private double payRate;
    /** variable for employee Type: HOURLY/SALARY. */
    protected EmployeeType employeeType;
    /** variable for employee PreTaxDeductions. */
    private double pretaxDeductions;
    /** variable for employee ytdEarnings. */
    private double ytdEarnings;
    /**
     * variable for employee ytdTaxesPaid.
     */
    private double ytdTaxesPaid;

    /**
     *
     * @param hoursWorked hours worked for employee (HOURLY).
     * @return defined in subclass based on employeeType.
     */
    protected abstract double calculateGrossPay(double hoursWorked);

    /**
     *
     * @param employeeName employeeName.
     * @param employeeID employeeID.
     * @param payRate employee payRate.
     * @param preTaxDeductions preTaxDeductions for employee.
     * @param ytdEarnings ytdEarnings for employee.
     * @param ytdTaxesPaid ytdTaxesPaid for employee.
     */
    public AbstractEmployee(EmployeeType employeeType,String employeeName, String employeeID, double payRate,  double preTaxDeductions, double ytdEarnings, double ytdTaxesPaid) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.payRate = payRate;
        this.pretaxDeductions = preTaxDeductions;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;

        this.employeeType = employeeType;
    }

    public double getGrossPay(double hoursWorked) {
        return calculateGrossPay(hoursWorked);
    }

    /**
     *
     * @return employeeName.
     */
    @Override
    public String getName() {
        return this.employeeName;
    }

    /**
     *
     * @return employeeID.
     */
    @Override
    public String getID() {
        return this.employeeID;
    }

    /**
     *
     * @return payRate.
     */
    @Override
    public double getPayRate() {
        return payRate;
    }

    /**
     *
     * @return employeeType.
     */
    @Override
    public String getEmployeeType() {
        return this.employeeType.name();
    }

    /**
     *
     * @return preTaxDeductions.
     */
    @Override
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    }

    /**
     *
     * @return ytdEarnings.
     */
    @Override
    public double getYTDEarnings() {
        return this.ytdEarnings;
    }

    /**
     *
     * @return ytdTaxesPaid.
     */
    @Override
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    /**
     *
     * @return employee as string.
     */
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                 this.getEmployeeType(),this.getName(),this.getID(),this.getPayRate(),this.getPretaxDeductions(),this.getYTDEarnings(),this.getYTDTaxesPaid());
    }

    /**
     *
     * @param hoursWorked the hours worked for the pay period.
     *tax = 22.65%, calculated with net_pay(after pretax deductions),
     * hourlyEmployee, payRate*hoursWorked for first 40,then payRate*1.5*(hoursWorked-40)
     *salaryEmployees - payRate/24
     * @return a new PayStub object.
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        BigDecimal grossPay = BigDecimal.valueOf(getGrossPay(hoursWorked))
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal Pay = grossPay.subtract(BigDecimal.valueOf(getPretaxDeductions()))
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal Taxes = Pay.multiply(new BigDecimal("0.2265"));
                //.setScale(2, RoundingMode.HALF_UP);

        BigDecimal netPay = Pay.subtract(Taxes)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal currentYtdEarnings = BigDecimal.valueOf(getYTDEarnings())
                .setScale(3, RoundingMode.HALF_UP);
        BigDecimal currentYtdTaxesPaid = BigDecimal.valueOf(getYTDTaxesPaid())
                .setScale(3, RoundingMode.HALF_UP);

//        ytdEarnings = currentYtdEarnings.doubleValue();
//        ytdTaxesPaid = currentYtdTaxesPaid.doubleValue();


        return new PayStub(employeeName, netPay.doubleValue(), Taxes.doubleValue(), currentYtdEarnings.doubleValue(), currentYtdTaxesPaid.doubleValue());
    }
}
