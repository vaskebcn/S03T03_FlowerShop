package org.develop;

import java.util.HashMap;

public class Tools {
    public static Product.ProductType chooseProductType() {
        boolean choose = true;
        int type = 0;
        Product.ProductType productType = null;

        do {
            type = Input.scanningForInt("""
                    Choose the type of the product:
                    1. Tree.
                    2. Flower.
                    3. Decoration.
                    Write a number between 1 to 3:""");

            switch (type) {
                case 1 -> productType = Product.ProductType.TREE;
                case 2 -> productType = Product.ProductType.FLOWER;
                case 3 -> productType = Product.ProductType.DECORATION;
                default -> {
                    System.out.println("Error. Introduce a number between 0 to 3.");
                    choose = false;
                }
            }
        } while (!choose);

        return productType;
    }

    public static Decoration.MaterialType chooseMaterialType() {
        boolean choose = true;
        int type = 0;
        Decoration.MaterialType materialType = null;

        do {
            type = Input.scanningForInt("""
                    Choose the type of the material:
                    1. Wood. 
                    2. Plastic.
                    Write a number between 1 or 2:""");

            switch (type) {
                case 1 -> materialType = Decoration.MaterialType.WOOD;
                case 2 -> materialType = Decoration.MaterialType.PLASTIC;
                default -> {
                    System.out.println("Error. You have to write 1 or 2.");
                    choose = false;
                }
            }
        } while (!choose);

        return materialType;
    }

    public static Product createProduct() {
        Product product = null;

        Product.ProductType productType = ToolsMontse.chooseProductType();
        String name = Input.scanningForString("Introduce the name:");
        int quantity = Input.scanningForInt("Introduce the quantity:");
        double price = Input.scanningForDouble("Introduce the price:");

        if (productType == Product.ProductType.TREE) {
            float height = Input.scanningForFloat("Introduce the height:");
            product = new Tree(name, quantity, price, height);
            //System.out.println(product);
            System.out.println("Product of type tree added correctly.");
        } else if (productType == Product.ProductType.FLOWER) {
            String colour = Input.scanningForString("Introduce the colour:");
            product = new Flower(name, quantity, price, colour);
            //System.out.println(product);
            System.out.println("Product of type flower added correctly.");
        } else if (productType == Product.ProductType.DECORATION) {
            Decoration.MaterialType materialType = ToolsMontse.chooseMaterialType();
            product = new Decoration(name, quantity, price, materialType);
            //System.out.println(product);
            System.out.println("Product of type decoration added correctly.");
        }
        return product;
    }

    //MODIFICACIÓ DEL DE LA CARLA showStockValue
    public static double showStockValueFromJSON(HashMap<String, Product> storeStockFromJSONArray) {
        double stockValue = 0;
        for (Product product : storeStockFromJSONArray.values()) {
            stockValue += product.getQuantity()*product.getPrice();
        }
        return stockValue;
    }




}
