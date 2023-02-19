package org.develop;

public class Product {

    private static int idCounter = 1;
    private final int ID;
    private String ref;
    private String name;
    private int quantity;
    private double price;
    private ProductType productType;


    public Product(String ref, String name, int quantity, double price, ProductType productType) {
        this.ID = Product.idCounter++;
        this.ref = ref;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.productType = productType;
    }

    public enum ProductType {
        TREE, FLOWER, DECORATION
    }

    public int getID() {
        return ID;
    }

    public String getRef() {
        return ref;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String obtainRef() {
        if (productType == ProductType.TREE) {
            ref = generateReference('T');
        } else if (productType == ProductType.FLOWER) {
            ref = generateReference('F');
        } else if (productType == ProductType.DECORATION){
            ref = generateReference('D');
        }
        return ref;
    }

    public String generateReference(char type) {
        String ref = String.valueOf(type);
        for (int i = 0; i < 3 ; i++) {
            int numInitial = (int) (Math.random() * 10 + 1);
            String numToAdd = Integer.toString(numInitial);
            ref += numToAdd;
        }
        return ref;
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
