package org.develop;

import java.sql.SQLOutput;

public class ToolsMontse {
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

}
