package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractEmployee implements IEmployee {

    private String employeeName;
    private String employeeID;
    private double payRate;
    protected EmployeeType employeeType;
    private double pretaxDeductions;
    private double ytdEarnings;
    private double ytdTaxesPaid;

    protected abstract double calculateGrossPay(double hoursWorked);

    public AbstractEmployee(String employeeName, String employeeID, double payRate, double preTaxDeductions, double ytdEarnings, double ytdTaxesPaid) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.payRate = payRate;
        this.pretaxDeductions = preTaxDeductions;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    @Override
    public String getName() {
        return this.employeeName;
    }

    public String getID() {
        return this.employeeID;
    }

    @Override
    public double getPayRate() {
        return payRate;
    }

    @Override
    public String getEmployeeType() {
        return this.employeeType.name();
    }

    @Override
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    }


    @Override
    public double getYTDEarnings() {
        return this.ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    @Override
    public String toCSV() {
        return String.format("%s, %s, %s, %.2f, %.2f, %.2f, %.2f",
                 this.getEmployeeType(), this.getName(), this.getID(), this.getPayRate(), this.getPretaxDeductions(), this.getYTDEarnings(), this.getYTDTaxesPaid());
    }


// payRate * hoursWorked for the first 40 hours, then payRate * 1.5 * (hoursWorked - 40) for overtime.
// For salary employees, it is pay rate divided by 24 for two payments every month.

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        BigDecimal grossPay = BigDecimal.valueOf(calculateGrossPay(hoursWorked))
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal Pay = grossPay.subtract(BigDecimal.valueOf(pretaxDeductions))
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal Taxes = Pay.multiply(new BigDecimal("0.2265"))
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal netPay = Pay.subtract(Taxes)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal currentYtdEarnings = BigDecimal.valueOf(ytdEarnings)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal currentYtdTaxesPaid = BigDecimal.valueOf(ytdTaxesPaid)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal newYtdEarnings = currentYtdEarnings.add(netPay)
                .setScale(2, RoundingMode.DOWN);

        BigDecimal newYtdTaxesPaid = currentYtdTaxesPaid.add(Taxes)
                .setScale(2, RoundingMode.HALF_UP);

        ytdEarnings += newYtdEarnings.doubleValue();
        ytdTaxesPaid += newYtdTaxesPaid.doubleValue();


        return new PayStub(employeeName, netPay.doubleValue(), Taxes.doubleValue(), ytdEarnings, ytdTaxesPaid);
    }
}
