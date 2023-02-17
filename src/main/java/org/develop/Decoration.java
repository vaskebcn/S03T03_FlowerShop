package org.develop;

public class Decoration extends Product {

    private MaterialType material; //wood or plastic

    public Decoration(String ref, String name, int quantity, double price, MaterialType material) {
        super(ref, name, quantity, price, ProductType.DECORATION);
        this.material = material;
    }

    public MaterialType getMaterial() {
        return material;
    }

    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    public enum MaterialType {
        WOOD, PLASTIC
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "ID=" + super.getID() +
                ", ref='" + super.getRef() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", material=" + this.material +
                ", quantity=" + super.getQuantity() +
                ", price=" + super.getPrice() +
                '}';
    }
}
