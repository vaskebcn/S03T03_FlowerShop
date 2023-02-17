package org.develop;

import javax.xml.transform.stream.StreamSource;
import java.util.HashMap;

public class CarlaMethods {
    //EN PPI DEPRECATED PER ADDPRODUCT()
    public void addFlower() {
        String flowerShop = Input.scanningForString("Please indicate the store's name");
        String ref = generateReference("f");
        String name = Input.scanningForString("please indicate the product's name");
        String colour = Input.scanningForString("Please indicate the flower's colour");
        int quantity = Input.scanningForInt("please indicate quantity of ");
        double price = Input.scanningForDouble("Please indicate a price");
        Product flower = new Flower(ref, name, colour, quantity, price);
        flowerShop.addProduct(flower);
        writeProduct(flower);
    }

    //EN PPI DEPRECATED PER ADDPRODUCT()
    public void addDecoration() {
        String flowerShop = Input.scanningForString("Please indicate the store's name");
        String ref = generateReference("f");
        String name = Input.scanningForString("please indicate the product's name");
        String material = Input.scanningForString("Please indicate the decoration's material");
        int quantity = Input.scanningForInt("please indicate quantity of product");
        double price = Input.scanningForDouble("Please indicate a price");
        Product decoration = new Decoration(ref, name, material, quantity, price);
        flowerShop.addProduct(decoration);
        writeProduct(decoration);
    }

    //ens el podriem estalviar crec
    public static void printCatalog(Store store) {
        store.showStock();
    }

    //no tinc clar que no lhagi fet la Montse, sino primer copiar el seu format per addProduct a la inversa
    public static void removeProduct() {

    }

    public static void totalSalesShop(Store store) {
        //store.getTickets()? s'hauria de fer una llista de tickets com a atribut de la store¿
    }

    //MINIMETODE per implementar a PRODUCT i cridar-lo al constructor/atribut de TREE,FLOWER I DECORATION: ref = generateReference(tipus);
    public String generateReference(String type) {
        String ref = type;
        for (int i = 0; i<3 ; i++) {
            int numInitial = (int) (Math.random() * 10 + 1);
            String numToAdd = Integer.toString(numInitial);
            ref += numToAdd;
        }
        return ref;
    }
}
