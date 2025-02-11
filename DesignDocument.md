# Payroll Generator Design Document

This document is meant to provide a tool for you to demonstrate the design process. You need to work on this before you
code, and after have a finished product. That way you can compare the changes, and changes in design are normal as you
work through a project. It is contrary to popular belief, but we are not perfect our first attempt. We need to iterate
on our designs to make them better. This document is a tool to help you do that.

## (INITIAL DESIGN): Class Diagram

Place your class diagram below. Make sure you check the fil in the browser on github.com to make sure it is rendering
correctly. If it is not, you will need to fix it. As a reminder, here is a link to tools that can help you create a
class
diagram: [Class Resources: Class Design Tools](https://github.com/CS5004-khoury-lionelle/Resources?tab=readme-ov-file#uml-design-tools)

[//]: # ( [MermaidChart: eaa3a140-a8a7-4e28-a621-5be49b7c68c4]

classDiagram
direction BT
class FileUtil {
}

    class Builder {
    }

    class Payroll {
    }

    class HourlyEmployee {
    }

    class SalaryEmployee {
    }

    class IPaystub {
    }

    class AbstractEmployee {
    }

    class IEmployee {
    }

    class ITimeCard {
    }

    class PayrollGenerator {
    }

	<<AbstractClass>> AbstractEmployee
	<<Interface>> IEmployee
	<<Interface>> ITimeCard

    PayrollGenerator --|> FileUtil : Inherits
    PayrollGenerator *-- Builder : Composes
    PayrollGenerator -- Payroll
    Payroll --> HourlyEmployee : Uses
    Payroll --> SalaryEmployee : Uses
    SalaryEmployee --|> AbstractEmployee : Inherits
    HourlyEmployee --|> AbstractEmployee : Inherits
    AbstractEmployee ..|> ITimeCard
    AbstractEmployee ..|> IEmployee
    IEmployee ..|> IPaystub

## (INITIAL DESIGN): Tests to Write - Brainstorm

Write a test (in english) that you can picture for the class diagram you have created. This is the brainstorming stage
in the TDD process.

@Test
public void testHourlyEmployeeConstructor() {
assertEquals("Luffy", hourlyEmployee.getName());
assertEquals("s192", hourlyEmployee.getID());
assertEquals(30.00, hourlyEmployee.getPayRate());
assertEquals(0.00, hourlyEmployee.getPretaxDeductions());
assertEquals(41566.34, hourlyEmployee.getYTDEarnings());
assertEquals(9518.66,hourlyEmployee.getYTDTaxesPaid());
}

> [!TIP]
> As a reminder, this is the TDD process we are following:
> 1. Figure out a number of tests by brainstorming (this step)
> 2. Write **one** test
> 3. Write **just enough** code to make that test pass
> 4. Refactor/update as you go along
> 5. Repeat steps 2-4 until you have all the tests passing/fully built program

You should feel free to number your brainstorm.

1. Test that the `Employee` class properly returns `name` from `getName()`
2. Test that the `Employee` class properly returns `id` from `getId()`
3. continue to add your brainstorm here (you don't need to super formal - this is a brainstorm) - yes, you can change
   the bullets above to something that fits your design.

## (FINAL DESIGN): Class Diagram

Go through your completed code, and update your class diagram to reflect the final design. Make sure you check the file
in the browser on github.com to make sure it is rendering correctly. It is normal that the two diagrams don't match!
Rarely (though possible) is your initial design perfect.

[//]: # ( [MermaidChart: eaa3a140-a8a7-4e28-a621-5be49b7c68c4]

classDiagram
direction BT
class FileUtil {
public static final String EMPLOYEE_HEADER;
public static final String PAY_STUB_HEADER;
private FileUtil() ;
public static List readFileToList(String file) ;
public static void writeFile(String outFile, List lines) ;
public static void writeFile(String outFile, List lines, boolean backup) ;
}

    class Builder {
	    private Builder() ;
	    public static IEmployee buildEmployeeFromCSV(String csv) ;
	    public static ITimeCard buildTimeCardFromCSV(String csv) ;
    }

    class HourlyEmployee {
	    public HourlyEmployee(String employeeName, String employeeID;double payRate,double preTaxDeductions; double ytdEarnings, double ytdTaxesPaid) ;
	    public double calculateGrossPay(double hoursWorked)
    }

    class SalaryEmployee {
	    public SalaryEmployee(String employeeName, String employeeID,double payRate,double preTaxDeductions,  double ytdEarnings, double ytdTaxesPaid) ;
	    public double calculateGrossPay(double hoursWorked)
    }

    class IPaystub {
	    double getPay() ;
	    double getTaxesPaid() ;
	    String toCSV() ;
    }

    class AbstractEmployee {
	    private String employeeName;
	    private String employeeID;
	    private double payRate;
	    protected EmployeeType employeeType;
	    private double pretaxDeductions;
	    private double ytdEarnings;
	    private double ytdTaxesPaid;
	    protected abstract double calculateGrossPay(double hoursWorked) ;
	    public AbstractEmployee(String employeeName, String employeeID, double payRate, double preTaxDeductions, double ytdEarnings, double ytdTaxesPaid) ;
	    public String getName() ;
	    public String getID() ;
	    public double getPayRate() ;
	    public String getEmployeeType() ;
	    public double getPretaxDeductions() ;
	    public double getYTDEarnings() ;
	    public double getYTDTaxesPaid() ;
	    public String toCSV() ;
	    public IPayStub runPayroll(double hoursWorked) ;
    }

    class IEmployee {
	    String getName() ;
	    String getID() ;
	    double getPayRate() ;
	    String getEmployeeType() ;
	    double getYTDEarnings() ;
	    double getYTDTaxesPaid() ;
	    double getPretaxDeductions() ;
	    IPayStub runPayroll(double hoursWorked) ;
	    String toCSV() ;
    }

    class ITimeCard {
	    String getEmployeeID() ;
	    double getHoursWorked() ;
    }

    class PayrollGenerator {
	    private static final String DEFAULT_EMPLOYEE_FILE;
	    private static final String DEFAULT_PAYROLL_FILE;
	    private static final String DEFAULT_TIME_CARD_FILE;
	    private static final class Argument;
	    private PayrollGenerator() ;
	    public static void main(String[] args) ;
    }

    class PayStub {
	    private double netPay;
	    private double taxes;
	    private String employeeName;
	    private double ytdEarnings;
	    private double ytdTaxesPaid;
	    public PayStub(String employeeName, double netPay, double taxes, double ytdEarnings, double ytdTaxesPaid) ;
	    public String getEmployeeName() ;
	    public double getPay() ;
	    public double getTaxesPaid() ;
	    public double getYtdEarnings() ;
	    public double getYtdTaxesPaid() ;
	    public String toCSV() ;
    }

    class TimeCard {
	    public TimeCard(String employeeID, double hoursWorked) ;
	    public String getEmployeeID() ;
	    public double getHoursWorked() ;
	    public String toString() ;
    }

    class EmployeeType {
	    ~~ HOURLY, SALARY
    }

	<<AbstractClass>> AbstractEmployee
	<<Interface>> ITimeCard

    PayrollGenerator --* FileUtil : Composes
    PayrollGenerator *-- Builder : Composes
    Builder --> EmployeeType : Uses
    SalaryEmployee --|> AbstractEmployee : Inherits
    HourlyEmployee --|> AbstractEmployee : Inherits
    AbstractEmployee ..|> ITimeCard
    AbstractEmployee ..|> IEmployee
    IEmployee ..|> IPaystub
    PayStub --|> IPaystub : Implements
    ITimeCard ..|> TimeCard

> [!WARNING]
> If you resubmit your assignment for manual grading, this is a section that often needs updating. You should double
> check with every resubmit to make sure it is up to date.

## (FINAL DESIGN): Reflection/Retrospective

> [!IMPORTANT]
> The value of reflective writing has been highly researched and documented within computer science, from learning new
> information to showing higher salaries in the workplace. For this next part, we encourage you to take time, and truly
> focus on your retrospective.

Take time to reflect on how your design has changed. Write in *prose* (i.e. do not bullet point your answers - it
matters in how our brain processes the information). Make sure to include what were some major changes, and why you made
them. What did you learn from this process? What would you do differently next time? What was the most challenging part
of this process? For most students, it will be a paragraph or two.

The major changes made were mainly how the classes interacted with each other. I ended up adding new classes and
removing some others I originally thought I would implement.
I learnt that this really does take a lot of time, especially if you are considering the most efficient ways to put the
program together. Additionally, when dealing with something as complicated as numbers
you tend to run into a lot of errors by the smallest of margins. Additionally, the object-oriented way if designing
requires a multitude of components to come together with ease. I do see the benefit,
especially if working within groups, unlike other programming languages, it is clearer to identify/pinpoint exactly what
method is causing errors. However, getting those various classes to work together will require
a lot of additional work and testing. I think this highlights the importance of testing while coding. 