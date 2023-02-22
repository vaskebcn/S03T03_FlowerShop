package org.develop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Tools {

    public static Product.ProductType chooseProductType() {
        boolean choose = true;
        int type = 0;
        Product.ProductType productType = null;

        do {
            type = Input.scanningForInt("""
                    Choose the type of the product:
                    1. Tree.
                    2. Flower.
                    3. Decoration.
                    Write a number between 1 to 3:""");

            switch (type) {
                case 1 -> productType = Product.ProductType.TREE;
                case 2 -> productType = Product.ProductType.FLOWER;
                case 3 -> productType = Product.ProductType.DECORATION;
                default -> {
                    System.out.println("Error. Introduce a number between 0 to 3.");
                    choose = false;
                }
            }
        } while (!choose);

        return productType;
    }

    public static Decoration.MaterialType chooseMaterialType() {
        boolean choose = true;
        int type = 0;
        Decoration.MaterialType materialType = null;

        do {
            type = Input.scanningForInt("""
                    Choose the type of the material:
                    1. Wood. 
                    2. Plastic.
                    Write a number between 1 or 2:""");

            switch (type) {
                case 1 -> materialType = Decoration.MaterialType.WOOD;
                case 2 -> materialType = Decoration.MaterialType.PLASTIC;
                default -> {
                    System.out.println("Error. You have to write 1 or 2.");
                    choose = false;
                }
            }
        } while (!choose);

        return materialType;
    }

    public static Product createProduct() {
        Product product = null;

        Product.ProductType productType = Tools.chooseProductType();
        String name = Input.scanningForString("Introduce the name:");
        int quantity = Input.scanningForInt("Introduce the quantity:");
        double price = Input.scanningForDouble("Introduce the price:");

        if (productType == Product.ProductType.TREE) {
            float height = Input.scanningForFloat("Introduce the height:");
            product = new Tree(name, quantity, price, height);
            //System.out.println(product);
            System.out.println("Product of type tree added correctly.");
        } else if (productType == Product.ProductType.FLOWER) {
            String colour = Input.scanningForString("Introduce the colour:");
            product = new Flower(name, quantity, price, colour);
            //System.out.println(product);
            System.out.println("Product of type flower added correctly.");
        } else if (productType == Product.ProductType.DECORATION) {
            Decoration.MaterialType materialType = Tools.chooseMaterialType();
            product = new Decoration(name, quantity, price, materialType);
            //System.out.println(product);
            System.out.println("Product of type decoration added correctly.");
        }
        return product;
    }

    //PRODUCTS
    public static HashMap<String, Product> JSONProductsToHashMap(JSONArray productArrayJSON) {
        HashMap<String, Product> storeStockFromJSONArray = new HashMap<>();
        Product product = null;
        String ref = "";

        for (Object obj: productArrayJSON) {
            JSONObject object = (JSONObject) obj;

            int ID = (Integer) object.get("ID");
            ref = (String) object.get("reference");
            String name = (String) object.get("name");
            int quantity = (Integer) object.get("quantity");
            double price = (Double) object.get("price");
            Product.ProductType type = (Product.ProductType) object.get("type");

            if (type == Product.ProductType.TREE) {
                float height = (Float) object.get("height");
                product = new Tree(ID, ref, name, quantity, price, height);
            } else if (type == Product.ProductType.FLOWER) {
                String colour = (String) object.get("colour");
                product = new Flower(ID, ref, name, quantity, price, colour);
            } else if (type == Product.ProductType.DECORATION) {
                Decoration.MaterialType materialType = (Decoration.MaterialType) object.get("material");
                product = new Decoration(ID, ref, name, quantity, price, materialType);
            }
            storeStockFromJSONArray.put(ref, product);
        }
        return storeStockFromJSONArray;

    }

    //TICKETS
    public static HashMap<Integer, ITicket> JSONTicketsToHashMap(JSONArray ticketArrayJSON) {
        HashMap<Integer, ITicket> salesHistoryFromJSONArray = new HashMap<>();
        int ID = 0;

        for (Object obj: ticketArrayJSON) {
            JSONObject object = (JSONObject) obj;

            ID = (Integer) object.get("ID");
            List<TicketLine> ticketLines = (List<TicketLine>) object.get("ticket lines");
            double totalPrice = (Double) object.get("total price");

            Ticket ticket = new Ticket(ID, ticketLines, totalPrice);
            salesHistoryFromJSONArray.put(ID, ticket);
            }

        return salesHistoryFromJSONArray;

    }

    //REMOVE PRODUCT I UPDATE PRODUCTS TXT
    public static void removeJSONProduct(String ref, String storeName) {
        boolean found = false;
        int i = 0;

        JSONArray productsArrayJSON = Reader.readProductsJSON(storeName);

        while ( i < productsArrayJSON.size() && !found) {
            JSONObject object = (JSONObject) productsArrayJSON.get(i);
            if (object.get("reference").equals(ref)) {
                found = true;
                productsArrayJSON.remove(i);
                System.out.println("Product deleted successfully.");
                try {
                    FileWriter filewriter = new FileWriter("src\\main\\resources\\Products" + storeName + ".txt", true);
                    BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
                    for (Object obj : productsArrayJSON) {
                        JSONObject object2 = (JSONObject) obj;
                        filewriter.write(object2.toJSONString() + "\n");
                    }
                    bufferedwriter.close();
                    System.out.println("File updated successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
        if (!found){
            System.out.println("Product not found in the database.");
        }
    }

    public static double showStockValueFromJSON(HashMap<String, Product> storeStockFromJSONArray) {
        double stockValue = 0;
        for (Product product : storeStockFromJSONArray.values()) {
            stockValue += product.getQuantity()*product.getPrice();
        }
        return stockValue;
    }

    public static double showTicketValueFromJSON(HashMap<Integer, ITicket> salesHistoryFromJSONArray) {
        double ticketsValues = 0;
        for (ITicket ticket : salesHistoryFromJSONArray.values()) {
            ticketsValues += ((Ticket) ticket).getTotalPrice();
        }
        return ticketsValues;
    }




}
