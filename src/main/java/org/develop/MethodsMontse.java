package org.develop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;

public class MethodsMontse {

    //REAPROFITAR PER TICKETS HASHMAP SALESHISTORY
    public static HashMap<String, IStore> JSONArrayToHashMap(JSONArray storeArrayJSON) {
        HashMap<String, IStore> storesListFromJSONArray = new HashMap<>();

        for (int i = 0; i < storeArrayJSON.size(); i++) {
            JSONObject object = (JSONObject) storeArrayJSON.get(i);

            String name = (String) object.get("Name");
            HashMap<String,Product> storeStock = (HashMap<String,Product>) object.get("Stock");
            HashMap<Integer,ITicket> salesHistory = (HashMap<Integer,ITicket>) object.get("Sales");

            Store store = new Store (name, storeStock, salesHistory);
            storesListFromJSONArray.put(name, store);
        }

        return storesListFromJSONArray;

    }



}

        //A REVISAR: problema amb l'ID al generar el fitxer, es repeteixen ID's si es surt i es torna a entrar a l'app.
        //A REVISAR: problema amb el mètode readProductsJSON, surt l'opció de "Unable to read the file".
        //           Possible error en la línia 96 amb el parse. S'HA DE COMPROVAR SI FUNCIONA.






