package org.develop;

import javax.xml.transform.stream.StreamSource;
import java.util.HashMap;

public class CarlaMethods {

    public static void printCatalog(String storeFile) {
        //JSON STUFF agafar productsPepitaStore.txt, i imprimir forEach line(products)
    }

    //no tinc clar que no lhagi fet la Montse, sino primer copiar el seu format per addProduct a la inversa
    public static HashMap<String,IStore> removeProductFromStore(HashMap<String,IStore> storesList) {
        String storeName = Input.scanningForString("Please indicate the products store's name");
        //JSON STUFF aqui s'agafa el json de la store guardat al stores.txt i es guarda de nou com a store¿
        Store store = null;
        String ref = Input.scanningForString("Please indicate product's reference");
        if (store.getStoreStock().containsKey(ref)) {
            store.getStoreStock().remove(ref);
            System.out.println("The product has been successfully removed from the store's stock");
        }
        //JSON STUFF aqui es passa again la store a object json i es fa un overwrite d'aquesta al stores.txt
        retur
    }

    public static void printHistorySales(String storeName) {
        //JSON STUFF aqui es mira quin registre de tickets es daquesta store i s'agafa com a json del LaPepitaTickets.txt. Igual sha de canviar el parametre d'entrada
        (json)salesHistory.values().forEach(System.out::println);
    }

    //MINIMETODE per implementar a PRODUCT i cridar-lo al constructor/atribut de TREE,FLOWER I DECORATION: ref = generateReference(tipus);
    public String generateReference(char type) {
        String ref = String.valueOf(type);
        for (int i = 0; i<3 ; i++) {
            int numInitial = (int) (Math.random() * 10 + 1);
            String numToAdd = Integer.toString(numInitial);
            ref += numToAdd;
        }
        return ref;
    }
}
