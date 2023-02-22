package org.develop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int menu = 0;
        do {
            menu = Input.scanningForInt("""
                    Choose which option do you want of the next menu:
                    1. Create a flower shop. 
                    2. Add a new product to store.
                    3. Print all the store catalog.
                    4. Remove a product from the store.
                    5. Print all the stock quantity.
                    6. Print the total price of the stock products from the store.
                    7. Create a purchase ticket with products.
                    8. Print store sales history.
                    9. Print the total money earned from all sales.
                    0. Exit the application.
                    Choose a number between 0 to 9:""");

            switch (menu) {
                case 0 -> System.out.println("Thank you for your purchase!");
                case 1 -> createFlowerShop();
                case 2 -> newProductToStore();
                case 3 -> printCatalog();
                case 4 -> removeProductFromStore();
                case 5 -> printStockQuantity();
                case 6 -> printStockValue();
                case 7 -> purchaseSale();
                case 8 -> printHistorySales();
                case 9 -> printTotalSalesValue();
                default -> System.out.println("Error. Introduce a number between 0 to 13.");
            }

        } while (menu != 0);

    }

    //case1 FET
    public static void createFlowerShop() {
        String storeName = Input.scanningForString("Enter the store name:");
        while(Tools.checkExistingStore(storeName)){
            storeName = Input.scanningForString("Store name already exists. Choose another store name");
        }
        Writer.writeStoreJSON(new Store(storeName));
        System.out.println("Flower Store " + storeName+ " successfully created");
    }

    //case2 FET
    public static void  newProductToStore () {
        String storeName = Input.scanningForString("Please indicate the name of the store:");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        Product newProduct = Tools.createProduct();
        Writer.addProductJSON(newProduct, storeName);
    }

    //case3 FET
    public static void  printCatalog () {
        String storeName = Input.scanningForString("Please indicate store's name:");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        JSONArray productArrayJSON = Reader.readProductsJSON(storeName);
        HashMap<String, Product> storeStockFromJSONArray = Tools.JSONProductsToHashMap(productArrayJSON);
        storeStockFromJSONArray.values().stream().filter(v -> v.getProductType().equals("TREE")).forEach(p -> System.out.println(p.toString2()));
        storeStockFromJSONArray.values().stream().filter(v -> v.getProductType().equals("FLOWER")).forEach(p -> System.out.println(p.toString2()));
        storeStockFromJSONArray.values().stream().filter(v -> v.getProductType().equals("DECORATION")).forEach(p -> System.out.println(p.toString2()));
    }

    //case4 FET
    public static void removeProductFromStore () {
        String storeName = Input.scanningForString("Please indicate the products store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        String ref = Input.scanningForString("Please indicate product's reference");
        Writer.removeJSONProduct(ref, storeName);
    }

    //case5 PENDENT PER METODE WRITER UPDATEPRODUCT
    public static void  printStockQuantity () {
        String storeName = Input.scanningForString("Please indicate the products store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        JSONArray productArrayJSON = Reader.readProductsJSON(storeName);
        HashMap<String, Product> storeStockFromJSONArray = Tools.JSONProductsToHashMap(productArrayJSON);//(canvi a Tools)

        for (Product product : storeStockFromJSONArray.values()) {
            System.out.println(product);
        }
    }

    //case6
    public static void  printStockValue () {
        String storeName = Input.scanningForString("Please indicate the products store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        JSONArray productArrayJSON = Reader.readProductsJSON(storeName);
        HashMap<String, Product> storeStockFromJSONArray = Reader.JSONArrayToHashMap(productArrayJSON);
        Tools.showStockValueFromJSON(storeStockFromJSONArray);
    }

    //case7
    public static void  purchaseSale () {


    }

    //case8 CAOS, MIRAR BE
    public static void printHistorySales () {
        String storeName = Input.scanningForString("Please indicate store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        JSONObject storeJSON = Reader.readStoreJSON(storeName);
        IStore storeFromJSONArray = Tools.readTicketsJSON(storeJSON);

        /* storesListFromJSONArray.values().stream()
                .filter(store -> store.getName().equals(storeName))*/
    }

    //case9
    public static void printTotalSalesValue () {
        String storeName = Input.scanningForString("Please indicate store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        JSONArray ticketsArray = Reader.readTicketsJSON(storeName);
        HashMap<Integer, ITicket> historySales = Tools.JSONTicketsToHashMap(ticketsArray);
        double totalValue = Tools.showTicketValueFromJSON( historySales);
        System.out.println(storeName+" -> total sales: "+totalValue+"€\n");
    }


}




/*
crear els fileReaders i fileWriters opcions menu Writers i Readers
    Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
    Printar per pantalla stock amb quantitats.
    Printar per pantalla valor total de la floristeria.
    Mostrar una llista de compres antigues.
    Visualitzar el total de diners guanyats amb totes les vendes.*/

