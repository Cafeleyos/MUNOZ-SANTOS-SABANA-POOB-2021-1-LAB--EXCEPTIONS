package SabanaPayroll;

public class BankAccountException extends Exception{

    public static final String LOW_AMOUNT_OF_MONEY = "The amount of money is too low for the requested withdrawal";

    public BankAccountException(String message) {
        super(message);
    }
}
