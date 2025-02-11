package student;

public class PayStub implements IPayStub{

    /** Net pay */
    private double netPay;
    /** Taxes deducted*/
    private double taxes;
    /**Employee Name*/
    private String employeeName;
    /** year-to-date earnings*/
    private double ytdEarnings;
    /** PreTaxDeductions */
    private double ytdTaxesPaid;


    public PayStub(String employeeName, double netPay, double taxes, double ytdEarnings, double ytdTaxesPaid) {
        this.employeeName = employeeName;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }


    public String getEmployeeName(){
        return this.employeeName;
    }

    public double getPay(){
        return this.netPay;
    }

    public double getTaxesPaid(){
        return this.taxes;
    }

    public double getYtdEarnings(){
        return this.ytdEarnings;}

    public double getYtdTaxesPaid(){
        return this.ytdTaxesPaid;
    }


    /**"employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"*/

    public String toCSV(){
        return String.format(" %s, %.2f, %.2f, %.2f, %.2f", this.getEmployeeName(), this.getPay(), this.getTaxesPaid(), this.getYtdEarnings(), this.getYtdTaxesPaid());
    }


}
