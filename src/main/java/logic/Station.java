package logic;

public class Station {
    private String name;
    private int number;

    //constructor
    public Station(String name,int number){
        this.setName(name);
        this.setNumber(number);
    }

    //method

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if(number < 0){
            this.number = 0;
        }else{
            this.number = number;
        }
    }
}
