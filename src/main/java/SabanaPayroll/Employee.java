package SabanaPayroll;

import java.util.UUID;

/**
 * Represents an employee
 */
public abstract class Employee {

    public UUID id;
    private String name, lastname;
    private Department department;
    private BankAccount account;
    private IFamilyCompensationFund compesationFund = null;

    /**
     * Constructor for specifying name, lastname and department of the employee
     */
    public Employee(String name, String lastname, Department department) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.lastname = lastname;
        this.department = department;
    }

    /**
     * Base method for calculating the salary
     * @return
     */
    public abstract double calculateSalary();

    public UUID getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public boolean addCompesationFund(IFamilyCompensationFund fcf) {
        boolean result = false;

        if(compesationFund == null) {
            this.compesationFund = fcf;
            result = true;
        }

        return result;
    }

    /**
     * returns the name, lastname, department, calculated salary and the payment method.
     */
    @Override
    public String toString() {
        return String.format("%s %s, department %s, salary $%s, pay for %s",
                this.name, this.lastname, this.department.getName(),
                Double.toString(calculateSalary()),
                this.getClass().getSimpleName().equals("EmployeeForHours") ? "hours" : this.getClass().getSimpleName().equals("EmployeeForSalary") ? "salary" : "commissions");
    }

    /**
     * adds an specific account if the employee does not have one already defined.
     * @param account to be added.
     * @return if was successful
     */
    public boolean addAccount(BankAccount account) {
        if(this.account==null){
            this.account = account;
            return true;
        }
        return false;
    }

    /**
     * @return bank account associated.
     */
    public BankAccount getBankAccount(){
        return this.account;
    }

    public abstract String getEmployeeMethodPay();
}
