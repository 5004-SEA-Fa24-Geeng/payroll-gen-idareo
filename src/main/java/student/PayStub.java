package student;

public class PayStub implements IPayStub {

    /**
     * Net pay variable.
     */
    private double netPay;
    /**
     * Taxes deducted.
     */
    private double taxes;
    /**
     * Employee Name.
     */
    private String employeeName;
    /**
     * year-to-date earnings.
     */
    private double ytdEarnings;
    /**
     * PreTaxDeductions.
     */
    private double ytdTaxesPaid;

    /**
     * @param employeeName employeeName.
     * @param netPay       netPay of employee after all deductions.
     * @param taxes        taxes of employee dependent on employeeType.
     * @param ytdEarnings  current ytdEarnings of employees.
     * @param ytdTaxesPaid current ytdTaxesPaid.
     */

    public PayStub(String employeeName, double netPay, double taxes, double ytdEarnings, double ytdTaxesPaid) {
        this.employeeName = employeeName;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }


    /**
     * @return employeeName.
     */
    public String getEmployeeName() {
        return this.employeeName;
    }

    /**
     * @return netPay.
     */
    public double getPay() {
        return this.netPay;
    }

    /**
     * @return taxes.
     */
    public double getTaxesPaid() {
        return this.taxes;
    }

    /**
     * @return ytdEarnings.
     */
    public double getYtdEarnings() {
        return this.ytdEarnings;
    }

    /**
     * @return ytdTaxesPaid.
     */
    public double getYtdTaxesPaid() {
        return this.ytdTaxesPaid;
    }


    /**
     * @return payStub as string.
     */

    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f", this.getEmployeeName(), this.getPay(),
                this.getTaxesPaid(), this.getYtdEarnings(), this.getYtdTaxesPaid());
    }
}
