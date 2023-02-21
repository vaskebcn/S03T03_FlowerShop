package org.develop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;

public class ToolsMontse {
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

    public static JSONObject createStoreJSON (Store store, HashMap<String,IStore> storesList) {
        JSONObject storeJSON = new JSONObject();

        storeJSON.put("Name", store.getStoreName());
        storeJSON.put("Stock", store.getStoreStock());
        storeJSON.put("Sales", store.getSalesHistory());

        return storeJSON;

    }

    public static void writeStoreJSON(JSONObject storeJSON) {

        String storeName = (String) storeJSON.get("Name");

        try {
            File file = new File ("src\\main\\resources\\" + storeName + ".txt");
            file.createNewFile();

            if (file.canWrite()) {
                FileWriter filewriter = new FileWriter(file, true);
                filewriter.write(storeJSON.toJSONString() + "\n");
                filewriter.close();
                System.out.println("Successfully written JSON Object to a file.");
            } else {
                System.out.println("Unable to write the JSON Object to a file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray readStoreJSON(String storeName) {
        JSONArray storesArrayJSON = new JSONArray();
        String line = "";

        try {
            File file = new File(storeName + ".txt");

            if (file.exists() && file.canRead()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                JSONParser parser = new JSONParser();
                line = bufferedReader.readLine();

                while (line != null) {
                    JSONObject object = (JSONObject) parser.parse(line);
                    storesArrayJSON.add(object);
                }
                reader.close();
            } else {
                System.out.println("Unable to read the file.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return storesArrayJSON;
    }

    public static HashMap<String, IStore> JSONArrayToHashMap(JSONArray storesArrayJSON) {
        HashMap<String, IStore> storesListFromJSONArray = new HashMap<>();

        for (int i = 0; i < storesArrayJSON.size(); i++) {
            JSONObject object = (JSONObject) storesArrayJSON.get(i);

            String name = (String) object.get("Name");
            HashMap<String,Product> storeStock = (HashMap<String,Product>) object.get("Stock");
            HashMap<Integer,ITicket> salesHistory = (HashMap<Integer,ITicket>) object.get("Sales");

            Store store = new Store (name, storeStock, salesHistory); //SOBRECÀRREGA DE CONSTRUCTORS A LA CLASSE PRODUCT
            storesListFromJSONArray.put(name, store);
        }

        return storesListFromJSONArray;

    }



}
