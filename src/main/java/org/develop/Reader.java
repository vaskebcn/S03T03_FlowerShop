package org.develop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static Product readProduct(String id) {
        Product product = null;
        try {
            File products = new File("//src/main/resources/Products.txt");
            FileReader fr = new FileReader (products);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            boolean found = false;
            while(!"".equals(line) && !found) {
                String[] productAttributes = line.split(",");
                String type = productAttributes[0].trim();
                String ref = productAttributes[1].trim();

                String price = productAttributes[3].trim();
                if (type.equalsIgnoreCase("tree")) {
                    String height = productAttributes[2].trim();
                    product = new Tree (ref, quantity, name, price, height);
                } else if (type.equalsIgnoreCase("flower")) {
                    String colour = productAttributes[2].trim();
                    product = new Flower (ref, quantity, name, price, colour);
                } else if (type.equalsIgnoreCase("decoration")) {
                    String material = productAttributes[2].trim();
                    product = new Decoration (ref, quantity, name, price, material);
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException | IOException ex) {
            System.out.print("IOException");
        }
        return product;
    }
}
