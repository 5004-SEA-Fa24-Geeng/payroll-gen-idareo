package student;

public class TimeCard implements ITimeCard{

    /**Employee ID*/
    private String employeeID;
    /** Hours worked for hourly employees*/
    private double hoursWorked;

    public TimeCard (String employeeID, double hoursWorked) {
        this.employeeID =  employeeID;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeID(){
        return employeeID;}

    public double getHoursWorked(){
        return this.hoursWorked;
    }

    public String toString(){
        return "TimeCard:\n"
                + "--------------------------"
                + "EmployeeID: " + this.getEmployeeID() + "\n"
        +"HoursWorked: " + this.getHoursWorked();

    }


}
