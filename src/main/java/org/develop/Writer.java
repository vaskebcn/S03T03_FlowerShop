package org.develop;

import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
