package SabanaPayroll;

import java.time.LocalDate;

/**
 * Represents a bank check
 */
public class Check {

    private double amount;
    private LocalDate expirationDate;

    /**
     * Initialize a check.
     * @param amount of the check
     * @param expirationDate of the check.
     */
    public Check(double amount, LocalDate expirationDate) {
        this.amount = amount;
        this.expirationDate = expirationDate;
    }

    /**
     * @return the amount of the check.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return the expiration date of the check.
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
