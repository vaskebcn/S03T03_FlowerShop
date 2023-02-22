package org.develop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
        productJSON.put("type", product.getProductType());

        if (product.getProductType() == Product.ProductType.TREE) {
            Tree tree = (Tree) product;
            productJSON.put("height", tree.getHeight());
        } else if (product.getProductType() == Product.ProductType.FLOWER) {
            Flower flower = (Flower) product;
            productJSON.put("colour", flower.getColour());
        } else if (product.getProductType() == Product.ProductType.DECORATION) {
            Decoration decoration = (Decoration) product;
            productJSON.put ("material", decoration.getMaterial());
        }

        return productJSON;
    }

    public static void writeProductJSON(JSONObject productJSON, String storeName) {

        String fileName = "Products" + storeName;

        try {
            File file = new File ("src\\main\\resources\\" + fileName + ".txt");
            file.createNewFile();

            if (file.canWrite()) {
                FileWriter filewriter = new FileWriter(file, true);
                BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
                filewriter.write(productJSON.toJSONString() + "\n");
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

    //REMOVE PRODUCT I UPDATE PRODUCTS TXT
    public static void removeJSONProduct(String ref, String storeName) {

        try {
            File originalFile = new File("src\\main\\resources\\Products" + storeName + ".txt");
            File temporalFile = new File("src\\main\\resources\\Products" + storeName + "Temp.txt");

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
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
    }

    //STORE
    public static void writeStoreJSON(Store store) {
        JSONObject storeJSON = new JSONObject();

        storeJSON.put("name", store.getStoreName());
        storeJSON.put("stock", store.getStoreStock());
        storeJSON.put("sales", store.getSalesHistory());

        String storeName = (String) storeJSON.get("name");

        try {
            File file = new File ("src\\main\\resources\\" + storeName + ".txt");
            file.createNewFile();

            if (file.canWrite()) {
                FileWriter filewriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
                bufferedWriter.write(storeJSON.toJSONString() + "\n");
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
    public static void writeTicketJSON(Ticket ticket) {
        JSONObject ticketJSON = new JSONObject();

        ticketJSON.put("ID", ticket.getID());
        ticketJSON.put("ticket lines", ticket.getTicketLines());
        ticketJSON.put("total price", ticket.getTotalPrice());

        String ticketName = (String) ticketJSON.get("name");

        try {
            File file = new File ("src\\main\\resources\\" + ticketName + ".txt");
            file.createNewFile();

            if (file.canWrite()) {
                FileWriter filewriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
                bufferedWriter.write(ticketJSON.toJSONString() + "\n");
                bufferedWriter.close();
                System.out.println("Successfully written JSON Object to a file.");
            } else {
                System.out.println("Unable to write the JSON Object to a file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //--------------------------------

    //potser no cal amb el updateStoreDatabase
    public static void removeProduct(Product product) {
        //identificar
        //while !found buscar a fitxer
        //removeJsonLine a TXT
    }

    public static void updateStoreDatabase(Store store) {
        //JSON STUFF passar store a json i sobreescriure la store LaPepita al stores.txt metode1
        //JSON STUFF passar products de la store a json i sobreescriure LaPepitaStock.txt metode2
        //JSON STUFF passar historySales de la store a json i afegir a LaPepitaHistorySales.txt metode3
    }
}
