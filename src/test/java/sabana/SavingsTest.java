package sabana;

import SabanaPayroll.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsTest {

    @Test
    public void shouldGetDepositDiscount() {
        Savings account = new Savings();
        assertTrue(Double.compare(2000, account.getDepositDiscount()) == 0);
    }

    @Test
    public void shouldDepositAmount() {
        Savings account = new Savings();
        boolean result = account.deposit(7000);

        assertTrue(result);
        assertTrue(Double.compare(5000, account.getBalance()) == 0);
    }

    @Test
    public void shouldNotDepositAmount() {
        Savings account = new Savings();

        assertFalse(account.deposit(2000));
        assertFalse(account.deposit(1500));
        assertTrue(Double.compare(0, account.getBalance()) == 0);
    }

    @Test
    public void shouldKeepBalance() {
        Savings account = new Savings();

        assertTrue(account.deposit(12000)); //10000
        assertFalse(account.deposit(2000));
        assertFalse(account.deposit(1000));
        assertTrue(account.deposit(5000)); // 3000
        assertTrue(Double.compare(13000, account.getBalance()) == 0);
    }

    @Test
    public void ShouldWithdrawMoneyIfPossible() throws BankAccountException {
        Savings account = new Savings();
        account.deposit(7000); //5000
        assertTrue(account.withdraw(3000));

        assertTrue(Double.compare(1988.0, account.getBalance()) == 0);
        assertFalse(account.withdraw(1988));
        assertTrue(account.withdraw(1980));
        assertTrue(Double.compare(0.07999999999992724, account.getBalance()) == 0);

    }

    @Test
    public void ShouldCalculateAnnualInterest(){
        Savings account = new Savings();
        account.deposit(70000);
        account.deposit(100000);
        account.deposit(50000);
        account.deposit(30000);
        account.deposit(40000);
        assertEquals(2800,account.getAnnualInterests());
    }

    @Test
    public void ShouldDepositCorrectlyTheMonthlyInterest() {
        Savings account = new Savings();
        account.deposit(70000);
        account.deposit(100000);
        account.deposit(50000);
        account.deposit(30000);
        account.deposit(40000);
        assertEquals(233.33333333333334,account.depositMonthlyInterest());
    }


}