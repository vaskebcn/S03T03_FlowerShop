package org.develop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Reader {
    public static IProduct readProduct(String id) {
        IProduct product = null;
        try {
            File products = new File("//src/main/resources/Products.txt");
            FileReader fr = new FileReader (products);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            boolean found = false;
            while(!"".equals(line) && !found) {
                String[] productAttributes = line.split(",");
                String type = productAttributes[0].trim();
                String name = productAttributes[1].trim();
                if (type.equalsIgnoreCase("tree")) {
                    String height = productAttributes[2].trim();
                    product = new Tree (name, height);
                } else if (type.equalsIgnoreCase("flower")) {
                    String colour = productAttributes[2].trim();
                    product = new Flower (name, colour);
                } else if (type.equalsIgnoreCase("decoration")) {
                    String material = productAttributes[2].trim();
                    product = new Decoration (name, material);
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.print("IOException");
        }
        return product;
    }
}
