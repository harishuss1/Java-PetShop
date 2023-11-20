package project;

public class Bird  extends Animal{
    
    private String FeatherColor;

    public Bird(String name, String species, int age, double price,String FeatherColor) {
        super(name, species, age, price);
        this.FeatherColor = FeatherColor;
    }


    public String getFeatherColor() {
        return FeatherColor;
    }
    public void setFeatherColor(String featherColor) {
        FeatherColor = featherColor;
    }


    //Methods for the Bird Class

    public boolean canFly(){
      if(getName().equals("emu")){
        return false;
      } 
      else{
      return true;
      }
    }
}
