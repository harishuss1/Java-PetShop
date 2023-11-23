package project;

public class PromoCode {

    private String code;
    private double value;

    public PromoCode(String code, double value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String toString() {
        return code + ", " + value + "% Off";
    }

}
