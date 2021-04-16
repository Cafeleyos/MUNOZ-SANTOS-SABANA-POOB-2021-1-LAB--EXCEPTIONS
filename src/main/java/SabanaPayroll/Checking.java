package SabanaPayroll;

import java.time.LocalDate;

public class Checking extends BankAccount {

    public final static double DEPOSIT_DISCOUNT = 5000;

    /**
     * @return the actual deposit discount.
     */
    public double getDepositDiscount() {
        return DEPOSIT_DISCOUNT;
    }

    /**
     * If the amount to be deposited is greater than the deposit discount then it will do it, if not, the operation isn´t completed.
     * @param amount amount to deposit.
     * @return If is was successful.
     */
    @Override
    public boolean deposit(double amount){
        if (amount>DEPOSIT_DISCOUNT){
            super.deposit(amount-DEPOSIT_DISCOUNT);
            return true;
        }
        return false;
    }

    /**
     * If a given check isn´t expired then its amount is deposited to the account (just if the amount satisfies the requirements). If not,
     * the operation isn´t completed
     * @param check to deposit
     * @return If is was successful.
     */
    public boolean processCheck(Check check){
        if (LocalDate.now().isBefore(check.getExpirationDate())){
            if(check.getAmount()>DEPOSIT_DISCOUNT) {
                deposit(check.getAmount());
                return true;
            }
        }
        return false;
    }



}
