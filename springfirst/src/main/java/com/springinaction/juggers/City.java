package com.springinaction.juggers;

public class City {   
    private String name;
    private String state;
    private int population;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    public String choseCity(){
        return name;
    }
 
}
