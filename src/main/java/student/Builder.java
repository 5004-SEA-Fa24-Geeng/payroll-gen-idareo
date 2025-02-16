package student;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    /**
     * builder constructor.
     */
    private Builder() {
    }

    /**
     * Builds an employee object from a CSV string.
     * <p>
     * You may end up checking the type of employee (hourly or salary) by looking at the first.
     * element of the CSV string. Then building an object specific to that type.
     *
     * @param csv the CSV string.
     * @return the employee object.
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {

        String[] parts = csv.split(",");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Error: Invalid Input");
        }

        String type = parts[0].toUpperCase();
        EmployeeType employeeType;
        try {
            employeeType = EmployeeType.valueOf(type); // Convert string to enum
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error: Invalid employee type '" + type + "' in CSV.");
        }
        String employeeName = parts[1];
        String employeeID = parts[2];

        double payRate;
        try {
            payRate = Double.parseDouble(parts[3]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: " + parts[3] + " is not a valid number.");
        }

        double preTaxDeductions;
        try {
            preTaxDeductions = Double.parseDouble(parts[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: " + parts[4] + " is not a valid number.");
        }

        double ytdEarnings;
        try {
            ytdEarnings = Double.parseDouble(parts[5]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: " + parts[5] + " is not a valid number.");
        }

        double ytdTaxesPaid;
        try {
            ytdTaxesPaid = Double.parseDouble(parts[6]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: " + parts[6] + " is not a valid number.");
        }

        IEmployee employee;
        switch (employeeType) {
            case HOURLY:
                employee = new HourlyEmployee(employeeName, employeeID, payRate,
                        ytdEarnings, ytdTaxesPaid, preTaxDeductions);
                break;
            case SALARY:
                employee = new SalaryEmployee(employeeName, employeeID, payRate,
                        ytdEarnings, ytdTaxesPaid, preTaxDeductions);
                break;
            default:
                throw new IllegalArgumentException("Error: Invalid employee type.");
        }

        return employee;
    }


    /**
     * Converts a TimeCard from a CSV String.
     *
     * @param csv csv string.
     * @return a TimeCard object.
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Error!");

        }

        String employeeID = parts[0];
        double hoursWorked;
        try {
            hoursWorked = Double.parseDouble(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error!");
        }
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Error:Hours worked cannot be less than 0.");
        }
        return new TimeCard(employeeID, hoursWorked);
    }


}
