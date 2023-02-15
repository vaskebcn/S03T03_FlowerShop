package org.develop;

public class Decoration implements IProduct {

    static int idCounter = 1;
    final int ID;
    int ref;
    int quantity;
    String name;
    double price;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "ID=" + ID +
                ", ref=" + ref +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", material='" + material + '\'' +
                '}';
    }
}
