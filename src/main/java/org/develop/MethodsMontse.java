package org.develop;

public class MethodsMontse {

    public static void addProduct() {

       Product.ProductType productType = ToolsMontse.chooseProductType();

       String ref = Input.scanningForString("Introduce the reference:");
       String name = Input.scanningForString("Introduce the name:");
       int quantity = Input.scanningForInt("Introduce the quantity:");
       double price = Input.scanningForDouble("Introduce the price:");

       if (productType == Product.ProductType.TREE) {
           float height = Input.scanningForFloat("Introduce the height:");
           Product tree = new Tree(ref, name, quantity, price, height);
           System.out.println(tree);
       } else if (productType == Product.ProductType.FLOWER) {
           String colour = Input.scanningForString("Introduce the colour:");
           Product flower = new Flower(ref, name, quantity, price, colour);
           System.out.println(flower);
       } else if (productType == Product.ProductType.DECORATION) {
           Decoration.MaterialType materialType = ToolsMontse.chooseMaterialType();
           Product decoration = new Decoration(ref, name, quantity, price, materialType);
           System.out.println(decoration);
       }

       // TO DO: Mirar si ha estat afegit al HashMap de products de la classe Store
       // i si és que sí, sumar-li quantity += quantity enlloc de crear una instància de T, F o D.

       // TO DO: Enlloc de demanar-li per scanner que introdueixi la referencia, que cridi al mètode Random de la Carla






    }

}
