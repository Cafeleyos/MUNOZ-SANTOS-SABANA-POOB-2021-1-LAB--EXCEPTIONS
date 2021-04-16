package SabanaPayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompensarFund implements IFamilyCompensationFund {

    private static List<Employee> registeredEmployees = new ArrayList<>();

    public CompensarFund() {
    }

    /**
     * Registers a given employee to the Fund. Does not admit Employees payed by hours
     * @param employee to register
     * @return if it was registered
     */
    @Override
    public boolean registerEmployee(Employee employee) throws FamilyCompensationFundException {

        if(employee.getEmployeeMethodPay().equals("hours")) {
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED);
        }
        else{
            for(Employee e : registeredEmployees) {
                if (e.getId() == employee.getId()) {
                    throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_REGISTERED);
                }
            }
        }

        return registeredEmployees.add(employee);
    }

    /**
     * Removes an employee from the Fund
     * @param id employee id
     * @return if it was removed
     */
    @Override
    public boolean deleteEmployee(UUID id) throws FamilyCompensationFundException {
        boolean result = false;
        int i = 0;

        for(i = 0; i < registeredEmployees.size(); i++) {
            if(registeredEmployees.get(i).getId() == id) {
                registeredEmployees.remove(i);
                result = true;
                break;
            }
        }
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
        int i = 0;

        for(i = 0; i < registeredEmployees.size(); i++) {
            if(registeredEmployees.get(i).getId() == id) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * Tell the benefits of this particular fund
     * @return paragraph of the benefits
     */
    @Override
    public String printBenefits() {
        return "Preferential corporate rates.\n" +
                "Service proposal specific to your needs.\n" +
                "Attention at the headquarters of your company.\n" +
                "Preferential service at 16 Compensar locations.\n" +
                "Wide opening hours.\n" +
                "Model of care authorized by the Ministry of Health with high standards of quality and patient " +
                "safety.\n" +
                "Awareness in vaccination prior to the campaigns.\n" +
                "Provision of certified cold chain equipment.\n" +
                "Access to the portfolio of vaccines delivered by the State.\n" +
                "Information and education to the user during vaccination.\n" +
                "Certified vaccinators with the highest distinction in job skills.\n" +
                "Monitoring and control schemes.\n" +
                "Performance reports.\n" +
                "Individual vaccination certificate.\n" +
                "Accompaniment in adverse events following vaccination.\n" +
                "Agreement modality with monthly billing or advance payment.\n" +
                "Billing of the doses actually applied.\n" +
                "Possibility of access by other interest groups (families) to the entire Compensar vaccine " +
                "portfolio, maintaining the presferential rates.";
    }

}
