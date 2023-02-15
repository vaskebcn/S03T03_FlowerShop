package org.develop;

public class Main {
    public static void main(String[] args) {
        int menu = 0;

        do {
            menu = Input.scanningForInt("""
                    Choose which option do you want of the next menu:
                    1. Create a flower shop. 
                    2. Add a new tree.
                    3. Add a new flower.
                    4. Add a new decoration.
                    5. Print all the store catalog.
                    6. Remove a tree.
                    7. Remove a flower.
                    8. Remove a decoration.
                    9. Print all the stock quantity.
                    10. Print the total price of the stock products.
                    11. Create a purchase ticket with products.
                    12. Print a history of sales.
                    13. Print the total sales of the shop.
                    0. Exit the application.
                    Choose a number between 0 to 13:""");

            switch (menu) {
                case 0 -> System.out.println("Thank you for your purchase!");
                case 1 -> createFlowerShop();
                case 2 -> addTree();
                case 3 -> addFlower();
                case 4 -> addDecoration();
                case 5 -> printCatalog();
                case 6 -> removeTree();
                case 7 -> removeFlower();
                case 8 -> removeDecoration();
                case 9 -> printStockQuantity();
                case 10 -> printTotalPriceProducts();
                case 11 -> createNewTicket();
                case 12 -> historySales();
                case 13 -> totalSalesShop();
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
