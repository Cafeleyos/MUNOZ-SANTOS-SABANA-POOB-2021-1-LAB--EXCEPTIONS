package sabana;

import SabanaPayroll.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SabanaNominaTest {

    private static SabanaPayroll sabanaPayRoll;
    private static Department F;
    private static Department V;
    private static Department I;
    private static EmployeeForHours e1h;
    private static EmployeeForHours e2h;
    private static EmployeeForHours e3h;
    private static EmployeeForSalary s1,s2,s3;
    private static EmployeeForCommission c1,c2,c3;
    private static ColsubsidioFund colFund;
    private static CompensarFund comFund;
    private static BankAccount a1,a2,a3,a4,a5,a6;

    @BeforeAll
    public static void setUp() {
        sabanaPayRoll = new SabanaPayroll();
        a1 = new Savings();
        a2 = new Savings();
        a3 = new Savings();
        a4 = new Checking();
        a5 = new Checking();
        a6 = new Checking();
        I = new Department("ENGINEERING");
        V = new Department("SALES");
        F = new Department("FINANCES");
        e1h = new EmployeeForHours("Juan", "Perez", F, 10,a1);
        e2h = new EmployeeForHours("Jorge", "Gomez", V, 15.9,a2);
        e3h = new EmployeeForHours("Laura", "Beltran", I, 0);
        s1 = new EmployeeForSalary("Pedro", "Perez", F, 10000.1,a3);
        s2 = new EmployeeForSalary("Camilo", "Munoz", V, 5000.6,a4);
        s3 = new EmployeeForSalary("David", "Colmenares", I, 24600.2);
        c1 = new EmployeeForCommission("David","Guarnizo",F,100,a5);
        c2 = new EmployeeForCommission("Diana","Sanchez",V,200,a6);
        c3 = new EmployeeForCommission("Erika","Rojas",I,0);
        colFund = new ColsubsidioFund();
        comFund = new CompensarFund();
        F.addEmployee(e1h);
        F.addEmployee(s1);
        F.addEmployee(c1);
        V.addEmployee(e2h);
        V.addEmployee(s2);
        V.addEmployee(c2);
        I.addEmployee(e3h);
        I.addEmployee(s3);
        I.addEmployee(c3);
        sabanaPayRoll.addDepartment(F);
        sabanaPayRoll.addDepartment(V);
        sabanaPayRoll.addDepartment(I);
        }


    @Test
    public void shouldCalculateOnlySalary() {
        assertEquals(9200.1,s1.getSalary());
        assertEquals(4600.6,s2.getSalary());
        assertEquals(22632.2,s3.getSalary());
    }
    @Test
    public void shouldGetCorrectlyTheSalaryDiscounts(){
        assertEquals(368.004,s1.getHealthDiscount());
        assertEquals(184.02400000000003,s2.getPensionDiscount());
        assertEquals(905.288,s3.getHealthDiscount());
    }

    @Test
    public void shouldCalculateOnlySalaryForHours() {
        assertEquals(400,  e1h.getSalary());
        assertEquals(636, e2h.getSalary());
        assertEquals(0,  e3h.getSalary());
    }

    @Test
    public void shouldCalculateOnlySalaryForCommission() {
        assertEquals(4000.0,  c1.getSalary());
        assertEquals(8000.0, c2.getSalary());
        assertEquals(0.0,  c3.getSalary());
    }

    @Test
    public void shouldPrintInformationAboutEmployees() {
        assertEquals("Juan Perez, department FINANCES, salary $400.0, pay for hours", e1h.toString());
        assertEquals("David Colmenares, department ENGINEERING, salary $22632.2, pay for salary", s3.toString());
    }

    @Test
    public void shouldCalculateDepartmentSalaries() {
        assertEquals(13600.1, F.calculateDepartmentSalaries());
        assertEquals(13236.6, V.calculateDepartmentSalaries());
        assertEquals(22632.2, I.calculateDepartmentSalaries());
    }

    @Test
    public void shouldCalculateEmployeeSalarieGivenItsId() {
        assertEquals(e1h.getSalary(),sabanaPayRoll.calculateEmployeeSalary(e1h.getId()));
        assertEquals(s2.getSalary(),sabanaPayRoll.calculateEmployeeSalary(s2.getId()));
        assertEquals(c3.getSalary(),sabanaPayRoll.calculateEmployeeSalary(c3.getId()));
    }

    @Test
    public void shouldCalculateDepartmentSalariesGivenItsId() {
        assertEquals(F.calculateDepartmentSalaries(),sabanaPayRoll.calculateDepartmentSalaries(F.getId()));
        assertEquals(V.calculateDepartmentSalaries(),sabanaPayRoll.calculateDepartmentSalaries(V.getId()));
        assertEquals(I.calculateDepartmentSalaries(),sabanaPayRoll.calculateDepartmentSalaries(I.getId()));
    }

    @Test
    public void shouldCalculateUniversitySalaries() {
        double result = F.calculateDepartmentSalaries()+V.calculateDepartmentSalaries()+ I.calculateDepartmentSalaries();
        assertEquals(result,sabanaPayRoll.calculateUniversitySalaries());
    }

    @Test
    public void shouldPrintAllTheEmployees() {
        sabanaPayRoll.printPayroll();
    }

    @Test
    public void shouldGetBalanceOfAnEmployee() {
        resetDeposits();
        assertTrue(sabanaPayRoll.depositToEmployee(e1h.getId(), 1200000));
        assertEquals(sabanaPayRoll.calculateEmployeeBalance(e1h.getId()), 1198000.0);
        assertTrue(sabanaPayRoll.depositToEmployee(e1h.getId(), 20000));
        assertEquals(sabanaPayRoll.calculateEmployeeBalance(e1h.getId()), 1216000.0);

    }

    @Test
    public void shouldDepositToAnEmployeeIfSatisfiesTheAccountRequirements() {
        resetDeposits();
        assertTrue(sabanaPayRoll.depositToEmployee(e1h.getId(), 1200000));
        assertEquals(sabanaPayRoll.calculateEmployeeBalance(e1h.getId()),1198000.0);

        assertTrue(sabanaPayRoll.depositToEmployee(s2.getId(), 400000));
        assertEquals(sabanaPayRoll.calculateEmployeeBalance(s2.getId()),395000.0);

        assertFalse(sabanaPayRoll.depositToEmployee(c1.getId(), 5000));
        assertEquals(sabanaPayRoll.calculateEmployeeBalance(c1.getId()),0);

        assertFalse(sabanaPayRoll.depositToEmployee(s1.getId(), 2000));
        assertEquals(sabanaPayRoll.calculateEmployeeBalance(s1.getId()),0);
    }



    @Test
    public void shouldGetCorrectlyTheBalanceOfAllEmployees(){
        resetDeposits();
        sabanaPayRoll.depositToEmployee(e1h.getId(), 1200000);
        sabanaPayRoll.depositToEmployee(e2h.getId(), 3000000);
        sabanaPayRoll.depositToEmployee(s1.getId(), 1000000);
        sabanaPayRoll.depositToEmployee(s2.getId(), 400000);
        sabanaPayRoll.depositToEmployee(c1.getId(), 500000);
        sabanaPayRoll.depositToEmployee(c2.getId(), 6000000);

        assertEquals(sabanaPayRoll.calculateAllEmployeesBalance(),1.2079E7);
    }

    @Test
    public void shouldAddEmployeeToFamilyCompesationFund() {
        assertTrue(sabanaPayRoll.assigneFamilyCompesation(s1.getId(), colFund));
        assertFalse(sabanaPayRoll.assigneFamilyCompesation(c2.getId(), colFund));
        assertTrue(sabanaPayRoll.assigneFamilyCompesation(e1h.getId(), colFund));
        assertFalse(sabanaPayRoll.assigneFamilyCompesation(e2h.getId(), comFund));
        assertTrue(sabanaPayRoll.assigneFamilyCompesation(c1.getId(), comFund));
    }

    public void resetDeposits(){
        a1.clearAccount(12345);
        a2.clearAccount(12345);
        a3.clearAccount(12345);
        a4.clearAccount(12345);
        a5.clearAccount(12345);
    }
}
