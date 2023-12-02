package project;

/**
 * Represents a promotional code that can be applied for discounts.
 */
public class PromoCode {

    private String code;
    private double value;

    /**
     * Constructs a PromoCode with the specified code and discount value.
     *
     * @param code  the code associated with the promo.
     * @param value the discount value in percentage.
     */
    public PromoCode(String code, double value) {
        this.code = code;
        this.value = value;
    }

    /**
     * Gets the code associated with the promo.
     *
     * @return the promo code.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets the code associated with the promo.
     *
     * @param code the new promo code to be set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the discount value in percentage.
     *
     * @return the discount value.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Sets the discount value in percentage.
     *
     * @param value the new discount value to be set.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Overrides the toString method to provide a string representation of the PromoCode.
     *
     * @return a string representation of the PromoCode, including its code and discount value.
     */
    @Override
    public String toString() {
        return code + ", " + value + "% Off";
    }
}
