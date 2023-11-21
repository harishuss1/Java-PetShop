package project;

public class Aquatic extends Animal{

    private String fintype;

    public Aquatic(String name, String species, int age, double price,String fintype) {
        super(name, species, age, price);
        this.fintype = fintype;
    }

    public String getFintype() {
        return fintype;
    }

    public void setFintype(String fintype) {
        this.fintype = fintype;
    }
    
}
