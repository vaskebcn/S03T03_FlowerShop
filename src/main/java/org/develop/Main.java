package org.develop;

import org.json.JSONArray;

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
                case 7 -> purchaseStoreSale();
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
        Product newProduct = Tools.createProduct(storeName);
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
        storeStockFromJSONArray.values().stream().filter(v -> v.getProductType() == Product.ProductType.TREE).forEach(p -> System.out.println(p.toString2()));
        storeStockFromJSONArray.values().stream().filter(v -> v.getProductType() == Product.ProductType.FLOWER).forEach(p -> System.out.println(p.toString2()));
        storeStockFromJSONArray.values().stream().filter(v -> v.getProductType() == Product.ProductType.DECORATION).forEach(p -> System.out.println(p.toString2()));
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

    //case5 FET
    public static void  printStockQuantity () {
        String storeName = Input.scanningForString("Please indicate the products store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        JSONArray storeStockJSON = Reader.readProductsJSON(storeName);
        HashMap<String, Product> storeStock = Tools.JSONProductsToHashMap(storeStockJSON);
        storeStock.values().forEach(v -> System.out.println(v.toString3()));
    }

    //case6 FET
    public static void  printStockValue () {
        String storeName = Input.scanningForString("Please indicate the products store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        JSONArray storeStockJSON = Reader.readProductsJSON(storeName);
        HashMap<String, Product> storeStock = Tools.JSONProductsToHashMap(storeStockJSON);
        Tools.showStockValue(storeStock);
    }

    //case7 FET
    public static void  purchaseStoreSale () {
        String storeName = Input.scanningForString("Please indicate the products store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        Store store = new Store(storeName);
        JSONArray storeStockJSON = Reader.readProductsJSON(storeName);
        HashMap<String,Product> storeStock = Tools.JSONProductsToHashMap(storeStockJSON);
        store.setStoreStock(storeStock);
        JSONArray historySalesJSON = Reader.readTicketsJSON(storeName);
        HashMap<Integer,ITicket> historySales = Tools.JSONTicketsToHashMap(historySalesJSON);
        store.setSalesHistory(historySales);
        store.purchaseSale();
    }

    //case8 FET
    public static void printHistorySales () {
        String storeName = Input.scanningForString("Please indicate store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        JSONArray historySalesJSON = Reader.readTicketsJSON(storeName);
        HashMap<Integer,ITicket> historySales = Tools.JSONTicketsToHashMap(historySalesJSON);
        historySales.values().forEach(System.out::println);
    }

    //case9 FET
    public static void printTotalSalesValue () {
        String storeName = Input.scanningForString("Please indicate store's name");
        while (!Tools.checkExistingStore(storeName)) {
            storeName = Input.scanningForString("Store does not exist. Choose another store name:");
        }
        JSONArray ticketsArray = Reader.readTicketsJSON(storeName);
        HashMap<Integer, ITicket> historySales = Tools.JSONTicketsToHashMap(ticketsArray);
        Tools.showTicketValueFromJSON( historySales);
    }
}

