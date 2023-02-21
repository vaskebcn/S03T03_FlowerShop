package org.develop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Reader {
    //PRODUCTS
    public static JSONArray readProductsJSON(String storeName) {
        JSONArray productArrayJSON = new JSONArray();
        String line = "";

        try {
            File file = new File("Products"+storeName+".txt");

            if (file.exists() && file.canRead()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                JSONParser parser = new JSONParser();
                line = bufferedReader.readLine();

                while (line != null) {
                    JSONObject object = (JSONObject) parser.parse(line);
                    productArrayJSON.add(object);
                }
                bufferedReader.close();
            } else {
                System.out.println("Unable to read the file.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return productArrayJSON;
    }

    public static HashMap<String, Product> JSONArrayToHashMap(JSONArray productArrayJSON) {
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

    //STORE
    public static JSONObject readStoreJSON(String storeName) {
        JSONObject storeJSON = new JSONObject();
        String line = "";

        try {
            File file = new File(storeName + ".txt");

            if (file.exists() && file.canRead()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                JSONParser parser = new JSONParser();
                line = bufferedReader.readLine();

                while (line != null) {
                    storeJSON = (JSONObject) parser.parse(line);
                }
                bufferedReader.close();
            } else {
                System.out.println("Unable to read the file.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return storeJSON;
    }
}
