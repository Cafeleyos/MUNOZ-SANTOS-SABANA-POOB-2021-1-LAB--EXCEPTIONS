package SabanaPayroll;

public class Savings extends BankAccount {

    public final static double DEPOSIT_DISCOUNT = 2000;
    public final static double ANNUAL_INTEREST_RATE  = 0.01;
    private double annualInterests =0;

    /**
     * @return the actual deposit discount.
     */
    @Override
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

        if(amount>DEPOSIT_DISCOUNT) {
            if (super.deposit(amount-DEPOSIT_DISCOUNT)){
                annualInterests = annualInterests+ (amount-DEPOSIT_DISCOUNT)*ANNUAL_INTEREST_RATE;
                return true;
            }
        }
        return false;
    }

    /**
     * @return the interests of the whole year
     */
    public double getAnnualInterests() {
        return this.annualInterests;
    }
     /**
     * Calculate the interest percentage and deposit it in the account without any discount.
     * <br><br>
     * @return the percentage deposited into the account.
     */
    public double depositMonthlyInterest(){
        if (super.deposit(annualInterests/12)){
            return annualInterests/12;
        }
        return 0;
    }



}
