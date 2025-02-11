import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.PayStub;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayStubTest {


    private PayStub payStub;

    @BeforeEach
    public void setUp() {
        payStub = new PayStub("John Doe", 5000.00, 1000.00, 100000.00, 20000.00);
    }

    @Test
    public void testGetterMethods() {
        assertEquals("John Doe", payStub.getEmployeeName());
        assertEquals(5000.00, payStub.getPay());
        assertEquals(1000.00, payStub.getTaxesPaid());
        assertEquals(100000.00, payStub.getYtdEarnings());
        assertEquals(20000.00, payStub.getYtdTaxesPaid());
    }

    @Test
    public void testToCSV() {
        String expectedCSV = " John Doe, 5000.00, 1000.00, 100000.00, 20000.00";
        assertEquals(expectedCSV, payStub.toCSV());
    }


}