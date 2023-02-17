package org.develop;

public class Tree extends Product {

    private float height;

    public Tree(String ref, String name, int quantity, double price, float height) {
        super(ref, name, quantity, price, ProductType.TREE);
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
}

