package sabana;

import SabanaPayroll.*;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CafamFundTest {

    private static Faker faker;

    private static List<Employee> employees;
    private static Department department;

    private static EmployeeForSalary EmployeeForSalary;
    private static EmployeeForHours EmployeeForHours;
    private static EmployeeForCommission EmployeeForCommission;

    private static IFamilyCompensationFund cafamFund;

    @BeforeAll
    public static void setUp() {
        faker = new Faker(new Locale("en-US"));

        department = new Department("Engineering");

        EmployeeForSalary = new EmployeeForSalary(faker.name().firstName(), faker.name().lastName(), department, 1000000);
        EmployeeForHours = new EmployeeForHours(faker.name().firstName(), faker.name().lastName(), department, 40);
        EmployeeForCommission = new EmployeeForCommission(faker.name().firstName(), faker.name().lastName(), department, 100);

        employees = new ArrayList<>();
        employees.add(EmployeeForSalary);
        employees.add(EmployeeForHours);
        employees.add(EmployeeForCommission);

        cafamFund = new CafamFund();
    }

    @Test
    @DisplayName("GIVEN a employee by salary WHEN try to register THEN success")
    public void shouldRegisterEmployee() {

        assertTrue(cafamFund.registerEmployee(EmployeeForCommission));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to register again THEN fails")
    public void shouldNotRegisterEmployeeWhenDuplicated() {

        assertTrue(cafamFund.registerEmployee(EmployeeForSalary));
        assertFalse(cafamFund.registerEmployee(EmployeeForSalary));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to delete THEN success")
    public void shouldDeleteEmployee() {

        assertTrue(cafamFund.registerEmployee(EmployeeForSalary));
        assertTrue(cafamFund.deleteEmployee(EmployeeForSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to delete THEN fails")
    public void shouldNotDeleteEmployee() {

        assertFalse(cafamFund.deleteEmployee(EmployeeForSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to validate is registered THEN success")
    public void shouldValidateEmployeeIsRegistered() {

        assertTrue(cafamFund.registerEmployee(EmployeeForHours));
        assertTrue(cafamFund.isEmployeeRegistered(EmployeeForHours.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to validate is registered THEN fails")
    public void shouldNotValidateEmployeeIsRegistered() {

        assertFalse(cafamFund.isEmployeeRegistered(EmployeeForSalary.getId()));
    }

    @Test
    public void shouldPrintBenefits() {

        String benefits = cafamFund.printBenefits();
        assertNotNull(benefits);
    }
}
