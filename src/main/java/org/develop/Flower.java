package org.develop;

public class Flower implements IProduct {

    static int idCounter = 1;
    final int ID;
    int ref;
    int quantity;
    String name;
    double price;
    String colour;

    public Flower() {

        this.ID = Flower.idCounter++;
    }

    public int getID() {
        return ID;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) { this.colour = colour; }

    @Override
    public String toString() {
        return "Flower{" +
                "ID=" + ID +
                ", ref=" + ref +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", colour='" + colour + '\'' +
                '}';
    }
}