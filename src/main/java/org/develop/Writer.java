package org.develop;
import org.json.*;

import java.io.*;

public class Writer {

    //PRODUCTS
    public static JSONObject createProductJSON(Product product) {
        JSONObject productJSON = new JSONObject();
        productJSON.put("ID", product.getID());
        productJSON.put("reference", product.getRef());
        productJSON.put("name", product.getName());
        productJSON.put("quantity", product.getQuantity());
        productJSON.put("price", product.getPrice());
        productJSON.put("type", String.valueOf(product.getProductType()));

        if (product.getProductType() == Product.ProductType.TREE) {
            Tree tree = (Tree) product;
            productJSON.put("height", tree.getHeight());
        } else if (product.getProductType() == Product.ProductType.FLOWER) {
            Flower flower = (Flower) product;
            productJSON.put("colour", flower.getColour());
        } else if (product.getProductType() == Product.ProductType.DECORATION) {
            Decoration decoration = (Decoration) product;
            productJSON.put ("material", String.valueOf(decoration.getMaterial()));
        }
        return productJSON;
    }

    public static void writeProductJSON(JSONObject productJSON, String storeName) {
        storeName = storeName.trim().replace(" ","_");
        String fileName = "Products" + storeName;
        try {
            File file = new File ("src/main/resources/" + fileName + ".txt");
            if (file.canWrite()) {
                FileWriter filewriter = new FileWriter(file, true);
                BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
                filewriter.write(productJSON.toString() + "\n");
                bufferedwriter.close();
                System.out.println("Successfully written JSON Object to a file.");
            } else {
                System.out.println("Unable to write the JSON Object to a file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addProductJSON(Product product, String storeName) {
        JSONObject jsonObject = createProductJSON(product);
        writeProductJSON(jsonObject, storeName);
    }

    //REMOVE PRODUCT TXT
    public static void removeJSONProduct(String ref, String storeName) {
        storeName = storeName.trim().replace(" ","_");
        try {
            File originalFile = new File("src/main/resources/Products" + storeName + ".txt");
            File temporalFile = new File("src/main/resources/Products" + storeName + "Temp.txt");

            BufferedReader bReader = new BufferedReader(new FileReader(originalFile));
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(temporalFile));

            String currentLine;
            while ((currentLine = bReader.readLine()) != null) {
                if (currentLine.contains(ref)) continue;
                bWriter.write(currentLine + System.getProperty("line.separator"));
            }
            bReader.close();
            bWriter.close();
            originalFile.delete();
            temporalFile.renameTo(originalFile);
            System.out.println("Product successfully removed.");
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
    }

    //UPDATE PRODUCT TXT
    public static void updateJSONProduct(Product product, String storeName) {
        Writer.removeJSONProduct(product.getRef(), storeName);
        JSONObject productJSON = createProductJSON(product);
        Writer.writeProductJSON(productJSON, storeName);
    }

    //STORE
    public static void writeStoreJSON(Store store) {
        String storeName = store.getStoreName().trim().replace(" ","_");
        JSONObject storeJSON = new JSONObject();
        storeJSON.put("name", storeName);
        try {
            File file = new File ("src/main/resources/Stores.txt");
            File productsFile = new File("src/main/resources/Products"+storeName+".txt");
            productsFile.createNewFile();
            File ticketsFile = new File("src/main/resources/Tickets"+storeName+".txt");
            ticketsFile.createNewFile();
            if (file.canWrite()) {
                FileWriter filewriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
                bufferedWriter.write(storeJSON.toString() + "\n");
                bufferedWriter.close();
                System.out.println("Successfully written JSON Object to a file.");
            } else {
                System.out.println("Unable to write the JSON Object to a file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TICKET
    public static void writeTicketJSON(Ticket ticket, String storeName) {
        JSONObject ticketJSON = new JSONObject();
        String fileName = "Tickets" + storeName.trim().replace(" ","_");
        ticketJSON.put("ID", ticket.getID());
        ticketJSON.put("ticketLines", ticket.getTicketLines());
        ticketJSON.put("totalPrice", ticket.getTotalPrice());

        try {
            File file = new File ("src/main/resources/" + fileName + ".txt");
            if (file.canWrite()) {
                FileWriter filewriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
                bufferedWriter.write(ticketJSON.toString() + "\n");
                bufferedWriter.close();
                System.out.println("Successfully written JSON Object to a file.");
            } else {
                System.out.println("Unable to write the JSON Object to a file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
