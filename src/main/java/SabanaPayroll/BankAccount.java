package SabanaPayroll;

/**
 * Represents a bank account.
 */
public abstract class BankAccount {

    public static final int TAX_4_1000 = 4;

    private double balance;

    /**
     * Initialize an account.
     */
    public BankAccount() {
        this.balance = 0;
    }

    /**
     * Gets the discount of the deposits
     *
     * @return
     */
    public abstract double getDepositDiscount();

    /**
     * Deposit an amount of money in the account
     * <br><br>
     * - The money to be deposited must be greater than the discount applied by the bank by default, if not, the
     *   operation cannot be performed. <br>
     * - If the amount to be deposited is correct, the discount is applied and the balance value is changed.
     * <br><br>
     *
     * @param amount amount to deposit.
     * @return if the operation was successful.
     */
    public boolean deposit(double amount) {
        if (amount>0) {
            setBalance(this.balance + amount);
            return true;
        }
        return false;
    }

    /**
     * Make a withdraw
     * <br><br>
     * - If the amount to withdraw added to the 4 x 1000 tax is less than the account balance, the operation cannot be done <br>
     *
     * @param amount amount to withdraw
     * @return if the operation was successful.
     */
    public boolean withdraw(double amount) throws BankAccountException {
        if (amount>this.balance) {
            throw new BankAccountException(BankAccountException.LOW_AMOUNT_OF_MONEY);
        }
        if(amount + calculateTax(amount)<=balance) {
            this.balance = balance- (amount+calculateTax(amount));
            return true;
        }
        return false;
    }

    /**
     * returns the balance of the account.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance to the value given
     * @param balance to be replaced
     */
    private void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Calculates the value of the 4X1000 tax of a given amount.
     * @param amount to calculate.
     * @return tax applied to the amount
     */
    public double calculateTax(double amount){
        return (amount*TAX_4_1000)/1000;
    }

    /**
     * Method done only for test purposes
     * Sets the balance to 0
     * @param adminPassword for performing the operation is necessary the correct password.
     * @return If it was possible according to the password.
     */

    public boolean clearAccount(double adminPassword) {
        boolean result = false;
        if (adminPassword == 12345) {
            this.balance = 0;
            result = true;
        }
        return false;
    }
}
