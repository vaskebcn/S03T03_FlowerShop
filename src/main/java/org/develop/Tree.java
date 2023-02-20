package org.develop;

public class Tree extends Product {

    private float height;

    public Tree(String name, int quantity, double price, float height) {
        super(name, quantity, price, ProductType.TREE);
        super.generateReference('T');
        this.height = height;
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
                "ID=" + super.getID() +
                ", ref='" + super.getRef() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", height=" + this.height +
                ", quantity=" + super.getQuantity() +
                ", price=" + super.getPrice() +
                '}';
    }

    public String toString2() {
        return "Tree{" +
                "ID=" + super.getID() +
                ", ref='" + super.getRef() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", height=" + this.height +
                ", price=" + super.getPrice() +
                '}';
    }
}

