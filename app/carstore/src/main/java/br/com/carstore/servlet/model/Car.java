package br.com.carstore.servlet.model;

public class Car {

    private String id;
    private String name;
    private String color;

    public Car(String name) {
        this.name = name;
    }

   public Car(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
