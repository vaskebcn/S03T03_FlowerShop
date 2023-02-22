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
                System.out.println("File successfully read.");
            } else {
                System.out.println("Unable to read the file.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return productArrayJSON;
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
                System.out.println("File successfully read.");
            } else {
                System.out.println("Unable to read the file.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return storeJSON;
    }

    //TICKETS
    public static JSONArray readTicketsJSON(String storeName) {
        JSONArray ticketArrayJSON = new JSONArray();
        String line = "";

        try {
            File file = new File("Tickets" + storeName + ".txt");

            if (file.exists() && file.canRead()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                JSONParser parser = new JSONParser();
                line = bufferedReader.readLine();

                while (line != null) {
                    JSONObject object = (JSONObject) parser.parse(line);
                    ticketArrayJSON.add(object);
                }
                bufferedReader.close();
                System.out.println("File successfully read.");
            } else {
                System.out.println("Unable to read the file.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return ticketArrayJSON;
    }
}
