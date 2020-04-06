package core.java.one.interfaces;

import java.io.StringReader;

public class Persoon {
    private String name;
    public Persoon(String name){
        this.name = name;
    }
    public String getName(){
        System.out.print("this is Persoon: ");
        return name;
    }
    public Persoon(){

    }
}
