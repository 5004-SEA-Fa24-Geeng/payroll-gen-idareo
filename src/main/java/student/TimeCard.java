package student;

public class TimeCard implements ITimeCard {

    /**
     * Employee ID variable
     */
    private String employeeID;
    /**
     * Hours worked variable
     */
    private double hoursWorked;

    /**
     * @param employeeID  employeeID
     * @param hoursWorked hoursWorked
     */
    public TimeCard(String employeeID, double hoursWorked) {
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
    }

    /**
     * @return employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @return hoursWorked
     */
    public double getHoursWorked() {
        return this.hoursWorked;
    }

    /**
     * @return timeCard as string
     */
    public String toString() {
        return "TimeCard:\n"
                + "--------------------------"
                + "EmployeeID: " + this.getEmployeeID() + "\n"
                + "HoursWorked: " + this.getHoursWorked();

    }


}
