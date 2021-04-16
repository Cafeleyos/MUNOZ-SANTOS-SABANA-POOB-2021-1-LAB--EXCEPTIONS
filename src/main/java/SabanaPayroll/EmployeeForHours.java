package SabanaPayroll;
/**
 * Represents and employee that is payed for hours. Class inherited by Employee.
 */
public class EmployeeForHours extends Employee{

    public static final double HOUR_VALUE = 40;
    private double hours;

    /**
     * Constructor for specifying name, lastname, department and hours of work.
     */
    public EmployeeForHours(String name, String lastname, Department department, double hours) {
        super(name, lastname, department);
        this.hours = hours;
    }
    /**
     * Constructor for specifying name, lastname, department, hours of work and bank account.
     */
    public EmployeeForHours(String name, String lastname, Department department, double hours, BankAccount account) {
        super(name, lastname, department);
        this.hours = hours;
        super.addAccount(account);
    }
    /**
     * Calculates the final salary of this type of employee.
     * @return Salary
     */
    @Override
    public double calculateSalary() {
        return Math.round(this.hours*HOUR_VALUE*10.0)/10.0;
    }

    /**
     * returns the name, lastname, department, calculated salary and the payment method.
     */
    public String toString() {
        return super.toString();
    }

    public Double getSalary() {
        return calculateSalary();
    }

    @Override
    public String getEmployeeMethodPay() {
        return "hours";
    }
}
