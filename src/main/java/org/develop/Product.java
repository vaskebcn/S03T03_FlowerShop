package org.develop;

public class Product {

    private static int idCounter = 1;
    private final int ID;
    private String ref;
    private String name;
    private int quantity;
    private double price;
    private ProductType productType;


    public Product(int id, String ref, String name, int quantity, double price, ProductType productType) {
        this.ID = Product.idCounter++;
        this.ref = ref;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.productType = productType;
    }

    public int getID() {
        return ID;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public enum ProductType {
        TREE, FLOWER, DECORATION
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", ref='" + ref + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }
}
