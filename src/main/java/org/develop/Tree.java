package s3_t3_montseliz;

import java.util.HashMap;

public class Tree implements IProduct {

    static int idCounter = 1;
    final int ID;
    int ref;
    int quantity;
    String name;
    double price;
    long stock;
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

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public void addProduct() {

    }

    @Override
    public void removeProduct() {

    }

    @Override
    public void printStock() {
        trees.values().stream()
                .filter(p -> p.getStock() >= 0).forEach(System.out::println);
    }

}