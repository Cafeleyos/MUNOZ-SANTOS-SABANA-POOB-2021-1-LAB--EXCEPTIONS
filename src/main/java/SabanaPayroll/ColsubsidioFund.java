package SabanaPayroll;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ColsubsidioFund implements IFamilyCompensationFund {

    private static Map<UUID, Employee> registeredEmployees = new HashMap<>();

    public ColsubsidioFund() {
    }

    /**
     * Registers a given employee to the Fund. Does not admit Employees payed by commission
     * @param employee to register
     * @return if it was registered
     */
    @Override
    public boolean registerEmployee(Employee employee) throws FamilyCompensationFundException {
        boolean result = true;

        if(employee.getEmployeeMethodPay().equals("commission")) {
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED);
        }
        else{
            for(Employee e : registeredEmployees.values()) {
                if (e.getId() == employee.getId()) {
                    throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_REGISTERED);
                }
            }
        }
        if(result) {
            registeredEmployees.put(employee.getId(), employee);
        }

        return result;
    }
    /**
     * Removes an employee from the Fund
     * @param id employee id
     * @return if it was removed
     */
    @Override
    public boolean deleteEmployee(UUID id) throws FamilyCompensationFundException {
        boolean result = false;
        Employee e;

        e = registeredEmployees.get(id);
        result = registeredEmployees.remove(id, e);
        if(!result) {
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED);
        }

        return result;
    }

    /**
     * Checks if and employee is already registered
     * @param id employee id
     * @return if is is registered.
     */
    @Override
    public boolean isEmployeeRegistered(UUID id) {
        boolean result = false;

        result = registeredEmployees.containsKey(id);

        return result;
    }

    /**
     * Tell the benefits of this particular fund
     * @return paragraph of the benefits
     */
    @Override
    public String printBenefits() {
        return "By being an affiliate, you are benefited with discounts, programs, credits, information, insurance, " +
                "subsidies and assistance from our workers.";
    }
}
