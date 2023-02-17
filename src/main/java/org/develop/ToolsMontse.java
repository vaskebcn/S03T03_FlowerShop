package org.develop;

import java.sql.SQLOutput;

public class ToolsMontse {
    public static Product.ProductType chooseProductType() {
        int type = 0;
        Product.ProductType productType = null;

        do {
            type = Input.scanningForInt("""
                    Choose the type of the product:
                    1. Tree. 
                    2. Flower.
                    3. Decoration.
                    0. Exit the menu.
                    Write a number between 0 to 3:""");

            switch (type) {
                case 0 -> System.out.println("Bye bye!");
                case 1 -> productType = Product.ProductType.TREE;
                case 2 -> productType = Product.ProductType.FLOWER;
                case 3 -> productType = Product.ProductType.DECORATION;
                default -> System.out.println("Error. Introduce a number between 0 to 3.");
            }

        } while (type != 0);

        return productType;
    }

    public static Decoration.MaterialType chooseMaterialType() {
        int type = 0;
        Decoration.MaterialType materialType = null;

        do {
            type = Input.scanningForInt("""
                    Choose the type of the material:
                    1. Wood. 
                    2. Plastic.
                    0. Exit the menu.
                    Write a number between 0 to 2:""");

            switch (type) {
                case 0 -> System.out.println("Bye bye!");
                case 1 -> materialType = Decoration.MaterialType.WOOD;
                case 2 -> materialType = Decoration.MaterialType.PLASTIC;
                default -> System.out.println("Error. You have to write a number between 0 to 2.");
            }
        } while (type != 0);

        return materialType;
    }

    //CANVIAR ELS MENÚS DE INT A BOOLEAN PERQUÈ ÉS LA UNITAT MÉS PETITA I PER TANT MÉS EFICIENT!!!


}
