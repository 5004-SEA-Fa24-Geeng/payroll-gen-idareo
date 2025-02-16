import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuilderTest {

    private SalaryEmployee salaryEmployee;
    private HourlyEmployee hourlyEmployee;

    @BeforeEach
    public void setUp() {
        hourlyEmployee = new HourlyEmployee( "Luffy","s192",30.00,9518.66,0.00,41566.34);
        salaryEmployee = new SalaryEmployee("Nami","s193",200000.00,1000.00,22689.33,6644.00);
    }

    @Test
    public void buildEmployeeFromCSVHourly() {
        String csv = "HOURLY,Luffy,s192,30.00,41566.34,9518.66,0.00";
        IEmployee employee = Builder.buildEmployeeFromCSV(csv);

        assertEquals(hourlyEmployee.getName(), ((HourlyEmployee) employee).getName());
        assertEquals(hourlyEmployee.getID(), ((HourlyEmployee) employee).getID());
        assertEquals(hourlyEmployee.getPayRate(), ((HourlyEmployee) employee).getPayRate());
        assertEquals(hourlyEmployee.getPretaxDeductions(), ((HourlyEmployee) employee).getPretaxDeductions());
        assertEquals(hourlyEmployee.getYTDEarnings(), ((HourlyEmployee) employee).getYTDEarnings());
        assertEquals(hourlyEmployee.getYTDTaxesPaid(), ((HourlyEmployee) employee).getYTDTaxesPaid());
    }


    @Test
    public void buildEmployeeFromCSVSalary() {
        String csv = "SALARY,Nami,s193,200000.00,6644.00,1000.00,22689.33";
        IEmployee employee = Builder.buildEmployeeFromCSV(csv);

        assertEquals(salaryEmployee.getName(), ((SalaryEmployee) employee).getName());
        assertEquals(salaryEmployee.getID(), ((SalaryEmployee) employee).getID());
        assertEquals(salaryEmployee.getPayRate(), ((SalaryEmployee) employee).getPayRate());
        assertEquals(salaryEmployee.getPretaxDeductions(), ((SalaryEmployee) employee).getPretaxDeductions());
        assertEquals(salaryEmployee.getYTDEarnings(), ((SalaryEmployee) employee).getYTDEarnings());
        assertEquals(salaryEmployee.getYTDTaxesPaid(), ((SalaryEmployee) employee).getYTDTaxesPaid());
    }

    @Test
    public void testInvalidCSVLength() {

        String csv = "HOURLY,Luffy,s192,30.00,0.00";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildEmployeeFromCSV(csv);
        });

        assertEquals("Error: Invalid Input", exception.getMessage());
    }

    @Test
    public void testInvalidNumberFormatForPayRate() {

        String csv = "HOURLY,Luffy,s192,invalid,0.00,41566.34,9518.66";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildEmployeeFromCSV(csv);
        });

        assertEquals("Error: invalid is not a valid number.", exception.getMessage());
    }

    @Test
    public void buildTimeCardFromCSV() {
        String csv = "s192,40.5";
        ITimeCard timeCard = Builder.buildTimeCardFromCSV(csv);

        assertEquals("s192", timeCard.getEmployeeID());
        assertEquals(40.5, timeCard.getHoursWorked());
    }

    @Test
    public void testInvalidHoursWorked() {

        String csv = "s192,-5.0";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildTimeCardFromCSV(csv);
        });

        assertEquals("Error: Hours worked cannot be negative.", exception.getMessage());
    }

    @Test
    public void testInvalidTypeHoursWorked() {
        String csv = "s192,invalid";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildTimeCardFromCSV(csv);
        });

        assertEquals("Error!", exception.getMessage());
    }

    @Test
    public void timeCardInvalidCSVLength() {
        String csv = "s192";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildTimeCardFromCSV(csv);
        });

        assertEquals("Error!", exception.getMessage());
    }
}