package org.develop;

public class MethodsMontse {

    public static void addProductToStore() {
       String ref = "";

       Product.ProductType productType = ToolsMontse.chooseProductType();

       String name = Input.scanningForString("Introduce the name:");
       int quantity = Input.scanningForInt("Introduce the quantity:");
       double price = Input.scanningForDouble("Introduce the price:");

       if (productType == Product.ProductType.TREE) {
           float height = Input.scanningForFloat("Introduce the height:");
           ref = new Product(null, name, quantity, price, Product.ProductType.TREE).obtainRef();
           ref = new Product(null, name, quantity, price, Product.ProductType.TREE).getRef();
           Product product = new Tree(ref, name, quantity, price, height);
           System.out.println(product);
       } else if (productType == Product.ProductType.FLOWER) {
           String colour = Input.scanningForString("Introduce the colour:");
           ref = new Product(null, name, quantity, price, Product.ProductType.FLOWER).obtainRef();
           ref = new Product(null, name, quantity, price, Product.ProductType.FLOWER).getRef();
           Product product = new Flower(ref, name, quantity, price, colour);
           System.out.println(product);
       } else if (productType == Product.ProductType.DECORATION) {
           Decoration.MaterialType materialType = ToolsMontse.chooseMaterialType();
           ref = new Product(null, name, quantity, price, Product.ProductType.DECORATION).obtainRef();
           ref = new Product(null, name, quantity, price, Product.ProductType.DECORATION).getRef();
           Product product = new Decoration(ref, name, quantity, price, materialType);
           System.out.println(product);
       }


    }

}



       // TO DO: Mirar si ha estat afegit al HashMap de products de la classe Store
       // i si és que sí, sumar-li quantity += quantity enlloc de crear una instància de T, F o D.

       // TO DO: Enlloc de demanar-li per scanner que introdueixi la referencia, que cridi al mètode Random de la Carla






