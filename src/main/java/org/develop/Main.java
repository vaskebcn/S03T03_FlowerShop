package org.develop;

import org.json.simple.JSONArray;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,IStore> storesList = new HashMap<>();
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
                case 1 -> createFlowerShop(storesList);
                case 2 -> newProductToStore(storesList);
                case 3 -> printCatalog();
                case 4 -> removeProductFromStore(storesList);
                case 5 -> printStockQuantity();
                case 6 -> printStockValue();
                case 7 -> purchaseSale(storesList);
                case 8 -> printHistorySales();
                case 9 -> printTotalSalesValue();
                default -> System.out.println("Error. Introduce a number between 0 to 13.");
            }

        } while (menu != 0);

    }

    //case1 MilosMethod crea nova store amb nom únic i afegeix a stores
    public static HashMap<String,IStore> createFlowerShop(HashMap<String,IStore> storesList) {
        String storeName = Input.scanningForString("Enter the store name:");

        if(storesList.containsKey(storeName)){
            storeName = Input.scanningForString("Store name already exists. Choose another store name");
            System.out.println("Flower Store " + storeName + "cannot be used");
        }else{
            storesList.put(storeName, new Store(storeName));
            System.out.println("Flower Store " + storeName+ " created");
        }
        return storesList;
    }

    //case2 amb metode createProduct Montse i metode store.addProduct Carla
    public static HashMap<String,IStore>  newProductToStore (HashMap<String,IStore> storesList) {
        String storeName = Input.scanningForString("Please indicate the name of the store:");
        if (storesList.containsKey(storeName)) {
            Product newProduct = Tools.createProduct();
            storesList.get(storeName).addProduct(newProduct);
        } else {
            System.out.println("Sorry, this store is not on the database");
        }
        return storesList;
    }

    //case3
    public static void  printCatalog () {
        String storeName = Input.scanningForString("Please indicate store's name:");

        JSONArray productArrayJSON = MethodsMontse.readProductsJSON(storeName);
        HashMap<String, Product> storeStockFromJSONArray = MethodsMontse.JSONArrayToHashMap(productArrayJSON);

        storeStockFromJSONArray.values().stream().filter(v -> v.getProductType().equals("TREE")).forEach(System.out::println);
        storeStockFromJSONArray.values().stream().filter(v -> v.getProductType().equals("FLOWER")).forEach(System.out::println);
        storeStockFromJSONArray.values().stream().filter(v -> v.getProductType().equals("DECORATION")).forEach(System.out::println);
    }

    //case4
    public static HashMap<String,IStore>  removeProductFromStore (HashMap<String,IStore> storesList) {
        String storeName = Input.scanningForString("Please indicate the products store's name");
        //JSON STUFF aqui s'agafa el json de la store guardat al stores.txt i es guarda de nou com a store¿
        Store store = null;
        String ref = Input.scanningForString("Please indicate product's reference");
        if (store.getStoreStock().containsKey(ref)) {
            store.getStoreStock().remove(ref);
            System.out.println("The product has been successfully removed from the store's stock");
        }
        //JSON STUFF aqui es passa again la store a object json i es fa un overwrite d'aquesta al stores.txt
        return storesList;
    }

    //case5
    public static void  printStockQuantity (String storeName) {
        JSONArray productArrayJSON = MethodsMontse.readProductsJSON(storeName);
        HashMap<String, Product> storeStockFromJSONArray = MethodsMontse.JSONArrayToHashMap(productArrayJSON);

        for (Product product : storeStockFromJSONArray.values()) {
            System.out.println(product.getProductType() + " / " + product.getName() + ": " + product.getQuantity());
        }
    }

    //case6
    public static void  printStockValue (String storeName) {
        JSONArray productArrayJSON = MethodsMontse.readProductsJSON(storeName);
        HashMap<String, Product> storeStockFromJSONArray = MethodsMontse.JSONArrayToHashMap(productArrayJSON);

        MethodsMontse.showStockValueFromJSON(storeStockFromJSONArray);
    }

    //case7
    public static HashMap<String,IStore>  purchaseSale (HashMap<String,IStore> storesList) {

        return storesList;
    }

    //case8
    public static void printHistorySales (String storeName) {
        JSONArray storesArrayJSON = ToolsMontse.readStoreJSON(storeName);
        HashMap<String, IStore> storesListFromJSONArray = ToolsMontse.JSONArrayToHashMap(storesArrayJSON);


        //PENSAR-LO
        /* storesListFromJSONArray.values().stream()
                .filter(store -> store.getName().equals(storeName))*/
    }

    //case9
    public static void printTotalSalesValue () {


    }


}




/*
crear els fileReaders i fileWriters opcions menu Writers i Readers
    Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
    Printar per pantalla stock amb quantitats.
    Printar per pantalla valor total de la floristeria.
    Mostrar una llista de compres antigues.
    Visualitzar el total de diners guanyats amb totes les vendes.*/

