package org.develop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;

public class MethodsMontse {

    public static Product createProduct() {
       Product product = null;

       Product.ProductType productType = ToolsMontse.chooseProductType();
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
           Decoration.MaterialType materialType = ToolsMontse.chooseMaterialType();
           product = new Decoration(name, quantity, price, materialType);
           //System.out.println(product);
           System.out.println("Product of type decoration added correctly.");
       }
       return product;
    }

    public static void assignStoreNameWithProduct(HashMap<String, IStore> storesList, HashMap<String,Product> storeStock, Product product) {

        String storeName = Input.scanningForString("Introduce the name of the shop:");

        if (storesList.containsKey(storeName)){
            storeStock.put(storeName, product);
            System.out.println("Shop found in the database.");
        } else {
            System.out.println("Shop not found in the database. First you have to create a flower shop.");
        }

    }

    public static JSONObject createProductJSON(Product product) {
        JSONObject productJSON = new JSONObject();

        productJSON.put("ID", product.getID());
        productJSON.put("Reference", product.getRef());
        productJSON.put("Name", product.getName());
        productJSON.put("Quantity", product.getQuantity());
        productJSON.put("Price", product.getPrice());
        productJSON.put("Type", product.getProductType());

        if (product.getProductType() == Product.ProductType.TREE) {
            Tree tree = (Tree) product;
            productJSON.put("Height", tree.getHeight());
        } else if (product.getProductType() == Product.ProductType.FLOWER) {
            Flower flower = (Flower) product;
            productJSON.put("Colour", flower.getColour());
        } else if (product.getProductType() == Product.ProductType.DECORATION) {
            Decoration decoration = (Decoration) product;
            productJSON.put ("Material", decoration.getMaterial());
        }

        return productJSON;
    }

    public static String foundStoreName(HashMap<String,Product> storeStock, Product product){
        String storeName = "";

        for (String key : storeStock.keySet()) {
            if(storeStock.get(key).equals(product)) {
                storeName = key;
            } else {
                System.out.println("Shop not found. First create a flower shop.");
            }
        }
        return storeName;

    }

    public static void writeProductJSON(JSONObject productJSON) {

        //CRIDAR AL MÈTODE foundStoreName per assignar-li al txt el nom de la botiga_products

        try {
            File file = new File ("src\\main\\resources\\Products.txt");
            file.createNewFile();

            if (file.canWrite()) {
                FileWriter filewriter = new FileWriter(file, true);
                filewriter.write(productJSON.toJSONString() + "\n");
                filewriter.close();
                System.out.println("Successfully written JSON Object to a file.");
            } else {
                System.out.println("Unable to write the JSON Object to a file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray readProductsJSON() {
        JSONArray productArrayJSON = new JSONArray();
        String line = "";

        try {
            File file = new File("Products.txt");

            if (file.exists() && file.canRead()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                JSONParser parser = new JSONParser();
                line = bufferedReader.readLine();

                while (line != null) {
                    JSONObject object = (JSONObject) parser.parse(line);
                    productArrayJSON.add(object);
                }
                reader.close();
            } else {
                System.out.println("Unable to read the file.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return productArrayJSON;
    }



}

        //A REVISAR: problema amb l'ID al generar el fitxer, es repeteixen ID's si es surt i es torna a entrar a l'app.
        //A REVISAR: problema amb el mètode readProductsJSON, surt l'opció de "Unable to read the file".
        //           Possible error en la línia 96 amb el parse.

       // TO DO: Mirar si ha estat afegit al HashMap de products de la classe Store
       // i si és que sí, sumar-li quantity += quantity enlloc de crear una instància de T, F o D.

        //printStockQuantity (String storeFile)
        // filtrar només el quantity





