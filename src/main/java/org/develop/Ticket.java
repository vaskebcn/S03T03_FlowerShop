package org.develop;

import java.util.HashMap;

public class Ticket implements ITicket{
    static int idCounter = 1;
    int id = 0;
    HashMap<Integer,TicketLine> ticketLines = new HashMap<Integer,TicketLine>();
    double totalPrice = 0;

    public Ticket () {
        id += idCounter;
        idCounter++;
    }

    @Override
    public void addProduct(Product product) {
        if (ticket.containsValue(product)) {
                product.add1ToQuantity();
        } else {
            ticket.put(ticket.size(), product);
        }
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }
}
