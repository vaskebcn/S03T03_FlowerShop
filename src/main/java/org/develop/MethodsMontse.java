package org.develop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;

public class MethodsMontse {

    public static Product createProduct() {
       Product product = null;

       Product.ProductType productType = ToolsMontse.chooseProductType();
       String name = Input.scanningForString("Introduce the name:");
       int quantity = Input.scanningForInt("Introduce the quantity:");
       double price = Input.scanningForDouble("Introduce the price:");

       if (productType == Product.ProductType.TREE) {
           float height = Input.scanningForFloat("Introduce the height:");
           product = new Tree(null, name, quantity, price, height);
           product.obtainRef();
           System.out.println("Product of type tree added correctly.");
       } else if (productType == Product.ProductType.FLOWER) {
           String colour = Input.scanningForString("Introduce the colour:");
           product = new Flower(null, name, quantity, price, colour);
           product.obtainRef();
           System.out.println("Product of type flower added correctly.");
       } else if (productType == Product.ProductType.DECORATION) {
           Decoration.MaterialType materialType = ToolsMontse.chooseMaterialType();
           product = new Decoration(null, name, quantity, price, materialType);
           product.obtainRef();
           System.out.println("Product of type decoration added correctly.");
       }
       return product;
    }

    public static JSONObject createProductJSON(Product product) {
        JSONObject productJSON = new JSONObject();

        productJSON.put(product.getID(), product);

        return productJSON;
    }

    public static void writeProductJSON(JSONObject productJSON) {
        try (FileWriter file = new FileWriter("Products.txt", true)) {
            file.write(productJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readProductJSON() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("Products.txt")) {
            Object obj = jsonParser.parse(reader);
            JSONArray productsList = (JSONArray) obj;
            productsList.forEach(p -> );

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}



       // TO DO: Mirar si ha estat afegit al HashMap de products de la classe Store
       // i si és que sí, sumar-li quantity += quantity enlloc de crear una instància de T, F o D.







