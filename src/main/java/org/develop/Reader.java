package org.develop;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

    public static int readLastID (String fileName) {
        int lastID = 1;
        Scanner scanner;
        String line = "";
        try {
            //BufferedReader bReader = new BufferedReader (new FileReader("src/main/resources/" +fileName));
            scanner = new Scanner(new File("src/main/resources/" +fileName));
            while (scanner.hasNext()) {
                line = scanner.next();
            }
            JSONObject JSONLine = new JSONObject(line);
            lastID += JSONLine.getInt("ID");
            scanner.close();
            System.out.println("Last ID successfully retrieved");
        } catch (Exception e) {
            System.out.println("Can't open file");
        }
        return lastID;
    }

    //PRODUCTS
    public static JSONArray readProductsJSON(String storeName) {
        String storeNameTrimmed = storeName.trim().replace(" ","_");
        JSONArray productArrayJSON = new JSONArray();
        String line = "";
        try {
            File file = new File("src/main/resources/Products"+storeNameTrimmed+".txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            line = bufferedReader.readLine();
            while (line != null) {
                JSONObject object = new JSONObject(line);
                productArrayJSON.put(object);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            System.out.println("File successfully read.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productArrayJSON;
    }

    //TICKETS
    public static JSONArray readTicketsJSON(String storeName) {
        String storeNameTrimmed = storeName.trim().replace(" ","_");
        JSONArray ticketArrayJSON = new JSONArray();
        String line = "";
        try {
            File file = new File("src/main/resources/Tickets" + storeNameTrimmed + ".txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            line = bufferedReader.readLine();
            while (line != null) {
                JSONObject object = new JSONObject(line);
                ticketArrayJSON.put(object);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            System.out.println("File successfully read.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ticketArrayJSON;
    }
}
