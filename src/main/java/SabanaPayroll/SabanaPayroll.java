package SabanaPayroll;

import java.util.ArrayList;
import java.util.UUID;

/**
 * System of payroll.
 */
public class SabanaPayroll {

    private ArrayList<Department> departments = new ArrayList<>();

    /**
     * Adds and specified department if it isn´t already added.
     * @return if it was added
     */
    public boolean addDepartment(Department d) {
        boolean result = true;

        for(Department a : departments) {
            if(d.getId() == a.getId()) {
                result = false;
                return result;
            }
        }
        departments.add(d);
        return result;
    }

    /**
     * Looks for the salary of an specified employee by its ID
     * @return the salary of the employee
     */
    public double calculateEmployeeSalary(UUID employeeId) {
        for(Department d: departments) {
            for(Employee e: d.getEmployees()) {
                if (e.getId() == employeeId) {
                    return e.calculateSalary();
                }
            }
        }
        return 0.0;
    }

    /**
     * Looks for the total salaries of an specific department by giving its ID
     * @return total salaries of the department
     */
    public double calculateDepartmentSalaries(UUID departmentId) {
        for(Department d: departments) {
            if (d.getId() == departmentId){
                return d.calculateDepartmentSalaries();
            }
        }
        return 0.0;
    }

    /**
     * calculate the total salaries of the entire university
     * @return total salaries
     */
    public double calculateUniversitySalaries() {
        double result = 0;
        for(Department d: departments) {
            result += d.calculateDepartmentSalaries();
        }
        return result;
    }

    /**
     * prints all the employees name, lastname, department, calculated salary and payment method.
     */
    public void printPayroll() {
        System.out.println("-------SabanaPayroll--------");
        for(Department d: departments){
            for(Employee e: d.getEmployees()){
                System.out.print(e.toString()+"\n");
            }

        }
        System.out.println("-----------");
    }

    /**
     * Deposits money to an specific employee given its ID.
     * @param uuid of the employee.
     * @param amount to be deposited.
     * @return if it was successful.
     */
    public boolean depositToEmployee(UUID uuid, double amount){
        boolean result = false;
        for(Department d: departments) {
            for(Employee e: d.getEmployees()) {
                if (e.getId() == uuid) {
                    if(e.getBankAccount() == null) {
                        break;
                    }
                    result = (e.getBankAccount().deposit(amount));
                }
            }
        }
        return result;
    }

    /**
     * Calculates the balance of an specific employee.
     * @param uuid of the employee.
     * @return the balance of the employee.
     */
    public double calculateEmployeeBalance(UUID uuid){
        double result = -1;
        for(Department d: departments) {
            for(Employee e: d.getEmployees()) {
                if (e.getId() == uuid) {
                    if(e.getBankAccount() == null) {
                        break;
                    }
                    result = e.getBankAccount().getBalance();
                }
            }
        }
        return result;
    }

    /**
     * Calculates the whole balance of the employees.
     * @return the total balance.
     */
    public double calculateAllEmployeesBalance(){
        double result = 0;
        for(Department d: departments) {
            for(Employee e: d.getEmployees()) {
                if(e.getBankAccount()==null){
                    break;
                }
                result += e.getBankAccount().getBalance();
            }
        }
        return result;
    }

    /**
     * Assigns to a an employee(given its id) a given CompensationFund.
     * @param uuid of the employee
     * @param fcf a compensation fund
     * @return if it was successful
     */
    public boolean assigneFamilyCompesation(UUID uuid, IFamilyCompensationFund fcf) throws FamilyCompensationFundException {
        boolean result = false, exist = false;
        int i = 0;


        for(Department d: departments) {
            for(i = 0; i < d.getEmployees().size(); i++) {
                if(uuid == d.getEmployees().get(i).getId()) {
                    exist = d.getEmployees().get(i).addCompesationFund(fcf);

                    if(exist) {
                        result = fcf.registerEmployee(d.getEmployees().get(i));
                    }
                    break;
                }
            }
        }

        return result;
    }
    
}
