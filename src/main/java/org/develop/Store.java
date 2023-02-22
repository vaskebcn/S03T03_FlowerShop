package org.develop;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Store implements IStore{
    
    private String storeName;
    private HashMap<String,Product> storeStock = new HashMap<>();
    private HashMap<Integer,ITicket> salesHistory = new HashMap<>();
    
    public Store (String storeName) {
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public HashMap<String,Product> getStoreStock() {
        return storeStock;
    }

    public HashMap<Integer,ITicket> getSalesHistory() { return salesHistory; }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public void addProduct(Product product) {
        if (storeStock.containsKey(product.getRef())) {
            storeStock.get(product.getRef()).addQuantity(product.getQuantity());
        } else {
            storeStock.put(product.getRef(), product);
        }
    }

    @Override
    public void showProduct(String ref) {
        if (storeStock.containsKey(ref)) {
            System.out.println(storeStock.get(ref));
        } else {
            System.out.println("Sorry, this product is not currently on stock");
        }
    }

    /*aquest metode es complex, he intentat abarcar tots els escenaris de compra de producte,
    i inicialment demano les ref, sino podem canviarho.
    Faig ticket nou i entro a bucle compra. alla pregunto referencia del producte.
    Primera opcio, el tenim. Llavors preguntem quantitat.
        Primera opcio, en tenim de sobres:reduïm quantity de producte
        Segona opcio, en tenim just el que demana:eliminem tot el producte(perque es quedaria a 0quantity ergo no el tenim)
        tercera opcio, no en tenim suficient, se li demana si vol la quantitat que queda, si es que si, eliminem producte igual que anterior
    Segona opcio, no el tenim, i avisem per pantalla
    Una vegada afegit el producte al ticket, demanem si es vol seguir amb el següent producte
        Primera opcio NO, doncs imprimim ticket i sortim del bucle
        Sino, comencem el bucle de nou demanant un nou producte*/
    @Override
    public void purchaseSale() {
        ITicket saleTicket = new Ticket();
        boolean saleCompleted = false;
        while (!saleCompleted) {
            String ref = Input.scanningForString("Please indicate product reference");
            if (storeStock.containsKey(ref)) {
                Product product = storeStock.get(ref);
                int quantity = Input.scanningForInt("Please indicate quantity");
                if (product.getQuantity() > quantity) {
                    product.sellQuantity(quantity);
                    saleTicket.addTicketLine(product, quantity);
                } else if (product.getQuantity() == quantity){
                    storeStock.remove(ref);
                    System.out.println("Lucky you! Last ones on stock!");
                    saleTicket.addTicketLine(product, quantity);
                } else if (product.getQuantity() < quantity) {
                    String limitedSale = Input.scanningForString("Sorry, currently we have only " +product.getQuantity()+ " on stock. Would you like to acquire the remaining stock?");
                    if (limitedSale.equalsIgnoreCase("yes")) {
                        quantity = product.getQuantity();
                        storeStock.remove(ref);
                        System.out.println("Excellent choice");
                        saleTicket.addTicketLine(product, quantity);
                    }
                }
            } else {
                System.out.println("Sorry, this product is not currently available");
            }
            //Aqui demanem si es vol afegir un altre producte, si es que no, imprimim ticket i sortim del bucle de compra
            String nextSale = Input.scanningForString("Would you like to add anything else to your sale?");
            if (nextSale.equalsIgnoreCase("no")) {
                System.out.print(saleTicket);
                salesHistory.put(((Ticket) saleTicket).getID(), saleTicket); //he afegit el ticket al hashmap de compres fetes
                Writer.updateStoreDatabase(this);
                saleCompleted = true;
            }
        }
    }
}
