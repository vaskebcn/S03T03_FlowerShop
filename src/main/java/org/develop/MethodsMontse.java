package org.develop;

public class MethodsMontse {

    public static void addProduct() {

       int ref = Input.scanningForInt("Introduce the reference:");
       String name = Input.scanningForString("Introduce the name:");
       int quantity = Input.scanningForInt("Introduce the quantity:");
       double price = Input.scanningForDouble("Introduce the price:");

       Product.ProductType productType = ToolsMontse.chooseProductType();

       if (productType == Product.ProductType.TREE) {
           float height = Input.scanningForFloat("Introducte the height:");
       } else if (productType == Product.ProductType.FLOWER) {
           String colour = Input.scanningForString("Introduce the colour:");
       } else if (productType == Product.ProductType.DECORATION) {
           Decoration.MaterialType materialType = ToolsMontse.chooseMaterialType();
       }

       //TO DO: Mirar si ha estat afegit i si es que sí, sumarli quantity += quantity






    }

}
