package org.develop;

public class Flower extends Product {

    private String colour;

    public Flower(String ref, String name, int quantity, double price, String colour) {
        super(ref, name, quantity, price, ProductType.FLOWER);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "ID=" + super.getID() +
                ", ref='" + super.getRef() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", colour=" + this.colour +
                ", quantity=" + super.getQuantity() +
                ", price=" + super.getPrice() +
                '}';
    }
}