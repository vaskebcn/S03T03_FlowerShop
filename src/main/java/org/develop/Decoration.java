package s3_t3_montseliz;

import java.util.HashMap;

public class Decoration implements IProduct {

    static int idCounter = 1;
    final int ID;
    int ref;
    int quantity;
    String name;
    double price;
    long stock;
    String material; //wood or plastic

    public Decoration() {

        this.ID = Decoration.idCounter++;
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

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void addProduct() {
    }

    @Override
    public void removeProduct() {
    }

    @Override
    public void printStock() {
        decorations.values().stream()
                .filter(p -> p.getStock() >= 0).forEach(System.out::println);
    }

}
