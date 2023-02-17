package org.develop;

public class Tree extends  Product {

    static int idCounter = 1;
    final int ID;
    int ref;
    int quantity;
    String name;
    double price;
    float height;

    public Tree() {
        this.ID = Tree.idCounter++;

    }

    public int getID() {
        return this.ID;
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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "ID=" + ID +
                ", ref=" + ref +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", height=" + height +
                '}';
    }
}