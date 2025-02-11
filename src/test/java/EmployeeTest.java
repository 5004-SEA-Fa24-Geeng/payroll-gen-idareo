import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.HourlyEmployee;
import student.SalaryEmployee;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    private SalaryEmployee salaryEmployee;
    private HourlyEmployee hourlyEmployee;

    @BeforeEach
    public void setUp() {
        hourlyEmployee = new HourlyEmployee( "Luffy",  "s192", 30.00, 0.00, 41566.34, 9518.66);
        salaryEmployee = new SalaryEmployee("Nami",  "s193", 200000.00, 1000.00, 39706.33, 11627.00);
    }

    @Test
    public void testHourlyEmployeeConstructor() {
        assertEquals("Luffy", hourlyEmployee.getName());
        assertEquals("s192", hourlyEmployee.getID());
        assertEquals(30.00, hourlyEmployee.getPayRate());
        assertEquals(0.00, hourlyEmployee.getPretaxDeductions());
        assertEquals(41566.34, hourlyEmployee.getYTDEarnings());
        assertEquals(9518.66,hourlyEmployee.getYTDTaxesPaid());
    }

    @Test
    public void testSalaryEmployeeConstructor() {
        assertEquals("Nami", salaryEmployee.getName());
        assertEquals("s193", salaryEmployee.getID());
        assertEquals(200000.00, salaryEmployee.getPayRate());
        assertEquals(1000.00, salaryEmployee.getPretaxDeductions());
        assertEquals(39706.33, salaryEmployee.getYTDEarnings());
        assertEquals(11627.00,salaryEmployee.getYTDTaxesPaid());
    }

    @Test
    public void toCSV() {
        String expectedCSV = "HOURLY, Luffy, s192, 30.00, 0.00, 41566.34, 9518.66";
        assertEquals(expectedCSV, hourlyEmployee.toCSV());

    }

    @Test
    public void hourlyEmployeeCalculateGrossPay() {

        double hoursWorked = 60;
        double regularPay = 40 * hourlyEmployee.getPayRate();
        double overtimePay = hourlyEmployee.getPayRate() * 1.5 * (hoursWorked - 40);
        double expectedGrossPay = regularPay + overtimePay;
        assertEquals(expectedGrossPay, hourlyEmployee.calculateGrossPay(hoursWorked), 0.01);

    }

    @Test
    public void salaryEmployeeCalculateGrossPay(){
        double expectedGrossPay = salaryEmployee.getPayRate()/24;
        assertEquals(expectedGrossPay, salaryEmployee.calculateGrossPay(0),0.01);
    }


}
