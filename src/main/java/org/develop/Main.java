package org.develop;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, IStore> storesList = new HashMap<>();

        int menu = 0;

        do {
            menu = Input.scanningForInt("""
                    Choose which option do you want of the next menu:
                    1. Create a flower shop. 
                    2. Add a new product to store.
                    3. Print all the store catalog.
                    4. Remove a product from the store.
                    5. Print all the stock quantity.
                    6. Print the total price of the stock products from the store.
                    7. Create a purchase ticket with products.
                    8. Print store sales history.
                    9. Print the total money earned from all sales.
                    0. Exit the application.
                    Choose a number between 0 to 9:""");

            switch (menu) {
                case 0 -> System.out.println("Thank you for your purchase!");
                case 1 -> createFlowerShop(HashMap<String, IStore> storesList);
                case 2 -> newProductToStore(HashMap<String, IStore> storesList);
                case 3 -> printCatalog();
                case 4 -> removeProductFromStore(HashMap<String, IStore> storesList);
                case 5 -> printStockQuantity();
                case 6 -> printStockValue();
                case 7 -> purchaseSale(HashMap<String, IStore> storesList);
                case 8 -> printHistorySales();
                case 9 -> printTotalSalesValue();
                default -> System.out.println("Error. Introduce a number between 0 to 13.");
            }

        } while (menu != 0);

    }

}

/*Decisions en grup previes
    decidir Interface: Istore Milos per floristeria i IProduct Montse per productes arbre, ITicket Carla
    decidir atributs classes
        Floristeria: String ID (key), String nom, (HashMap?) stock <Tree>, stock <Flower>, stock <Decoration> objectes
        Arbre: String ID (key),String ref, String nom, Double alçada, Double preu (value), static int quantity
        Flor: String ID(key), String ref, String nom, String color, Double preu, static int quantity (sense Set, nomes add o remove)
        Decoracio: String nom, String material (fusta/plastic), Double preu, static int quantity
        Ticket: HashMap compra <Products>, Double preuTotal (metode getTotal amb sum products.getPreu())
    decidir estructura interClasses

    ITicket ticket3 = new Ticket<>()
    IProduct sequoya = new Tree<>();
    Istore floristeriaLaPepa = new FlowerShop<>();
 */

//3 possibles separacions
/*crear les classes de productes
    En una floristeria, que té un nom, tenim arbres, flors i decoració.
    Cada arbre té una alçada.
    Les flors tenen un color.
    La decoració té un tipus de material: fusta o plàstic.
    Tots tenen un preu.
    Una floristeria ha de tenir un stock de cada un dels productes (arbres, flors i decoració).
    La floristeria té un registre del valor total de l'stock que té.
    S’ha de crear una classe ticket, on poder registrar les compres en UNA sola llista.
 */
/*crear el main amb opcions menu baseDeDades
    Crear Floristeria.
    Afegir Arbre.
    Afegir Flor.
    Afegir Decoració.
    Retirar arbre.
    Retirar flor.
    Retirar decoració.
    Crear tickets de compra amb múltiples objectes.
 */
/*crear els fileReaders i fileWriters opcions menu Writers i Readers
    Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
    Printar per pantalla stock amb quantitats.
    Printar per pantalla valor total de la floristeria.
    Mostrar una llista de compres antigues.
    Visualitzar el total de diners guanyats amb totes les vendes.
 */
