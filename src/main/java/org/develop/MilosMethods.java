package org.develop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class MilosMethods {

    static void createFlowerShop(){ //S'HA DE CREAR UN OBJECTE FlowerShop

        String storeName = Input.scanningForString("Enter store name");

        if(storesList.contains(storeName)){
            System.out.println("Store name already exist. Choose another store name");
            createFlowerShop();
        }else{
            storesList.add(new Store(storeName));
            System.out.println("Flower Store " + storeName+ " created");
        }

    }

    static void removeDecoration(){

        String storeName = Input.scanningForString("Enter store name");

        Store store = null;

//        searching for a store
        for (Store s : storesList) {
            if (s.getStoreName().equalsIgnoreCase(storeName)) {
                store = s;
            }
        }

        if (store != null) {

            // asign storeStock hashmap and calculate totalPrice
            HashMap<String, Product> stock = store.getStoreStock();
            String decoName = Input.scanningForString("Enter decoration name");

            for (Product p : stock.values()) {
                p.getName().equalsIgnoreCase(decoName);
                stock.remove(p);
            }

        }else{
            System.out.println("No store found");
        }

    }

    static void printTotalPriceProducts() {

        String storeName = Input.scanningForString("Enter store name");

        Store store = null;
        double totalPrice = 0;

//        searching for a store
        for (Store s : storesList) {
            if (s.getStoreName().equalsIgnoreCase(storeName)) {
                store = s;
            }
        }

        if (store != null) {

            // asign storeStock hashmap and calculate totalPrice
            HashMap<String, Product> stock = store.getStoreStock();

            for (Product p : stock.values()) {
                totalPrice += p.getPrice() * p.getQuantity();
            }

            System.out.println(totalPrice);

        } else {
            System.out.println("There is no store with that kind of name");
        }
    }


    //    where should we save all of the tickets?
//    and should tickets be like an array atribute for each instance of a store?
    static void createNewTicket(){
//        LocalDate date = LocalDate.now();
//        allTickets.add(new Ticket());
        Store store = null;

        for (Store s : storesList) {
            System.out.println(s.getStoreName());
        }
        String storeName = Input.scanningForString("Select store");

        for (Store s : storesList) {
            if(storeName.equalsIgnoreCase(s.getStoreName())){
                store = s;
            }
        }

        if(store!=null){
//            return saleTicket
//            ITicket ticket = store.purchaseSale();
//            allTickets.add(ticket);
        }else{
            System.out.println("Something went wrong. Store name not found");
        }
    }

}
