package sabana;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import SabanaPayroll.*;
import static org.junit.jupiter.api.Assertions.*;

public class ColsubsidioFundTest {

    private static Faker faker;

    private static List<Employee> employees;
    private static Department department;

    private static EmployeeForSalary EmployeeForSalary;
    private static EmployeeForSalary EmployeeForSalary2;
    private static EmployeeForHours EmployeeForHours;
    private static EmployeeForCommission EmployeeForCommission;

    private static IFamilyCompensationFund colsubsidioFund;

    @BeforeAll
    public static void setUp() {
        faker = new Faker(new Locale("en-US"));

        department = new Department("Engineering");

        EmployeeForSalary = new EmployeeForSalary(faker.name().firstName(), faker.name().lastName(), department, 1000000);
        EmployeeForSalary2 = new EmployeeForSalary(faker.name().firstName(), faker.name().lastName(), department, 1200000);
        EmployeeForHours = new EmployeeForHours(faker.name().firstName(), faker.name().lastName(), department, 40);
        EmployeeForCommission = new EmployeeForCommission(faker.name().firstName(), faker.name().lastName(), department, 100);

        employees = new ArrayList<>();
        employees.add(EmployeeForSalary);
        employees.add(EmployeeForSalary2);
        employees.add(EmployeeForHours);
        employees.add(EmployeeForCommission);

        colsubsidioFund = new ColsubsidioFund();
    }

    @Test
    @DisplayName("GIVEN a employee by salary WHEN try to register THEN success")
    public void shouldRegisterEmployee() throws FamilyCompensationFundException {

        assertTrue(colsubsidioFund.registerEmployee(EmployeeForSalary2));
    }

    @Test
    @DisplayName("GIVEN a employee by commission WHEN try to register THEN fails")
    public void shouldNotRegisterEmployeeWhenByCommission() {

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> colsubsidioFund.registerEmployee(EmployeeForCommission));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to register again THEN fails")
    public void shouldNotRegisterEmployeeWhenDuplicated() throws FamilyCompensationFundException {

        assertTrue(colsubsidioFund.registerEmployee(EmployeeForSalary));

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> colsubsidioFund.registerEmployee(EmployeeForSalary));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_REGISTERED, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to delete THEN success")
    public void shouldDeleteEmployee() throws FamilyCompensationFundException {

        assertTrue(colsubsidioFund.registerEmployee(EmployeeForSalary));
        assertTrue(colsubsidioFund.deleteEmployee(EmployeeForSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to delete THEN fails")
    public void shouldNotDeleteEmployee() {

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> colsubsidioFund.deleteEmployee(EmployeeForSalary.getId()));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to validate is registered THEN success")
    public void shouldValidateEmployeeIsRegistered() throws FamilyCompensationFundException {

        assertTrue(colsubsidioFund.registerEmployee(EmployeeForHours));
        assertTrue(colsubsidioFund.isEmployeeRegistered(EmployeeForHours.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to validate is registered THEN fails")
    public void shouldNotValidateEmployeeIsRegistered() {

        assertFalse(colsubsidioFund.isEmployeeRegistered(EmployeeForSalary.getId()));
    }

    @Test
    public void shouldPrintBenefits() {

        String benefits = colsubsidioFund.printBenefits();
        assertNotNull(benefits);
    }

}
