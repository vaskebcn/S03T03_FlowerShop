package org.develop;

import java.util.HashMap;

public class Ticket implements ITicket{
    static int idCounter = 1;
    final int ID;
    HashMap<Integer,TicketLine> ticketLines = new HashMap<Integer,TicketLine>();
    double totalPrice = 0;

    public Ticket () {
        this.ID = idCounter;
        idCounter++;
    }
    public int getID() {
        return ID;
    }
    public HashMap<Integer,TicketLine> getTicketLines() {
        return ticketLines;
    }

    @Override
    public void addTicketLine(IProduct product) {
        TicketLine ticketLine = new TicketLine(product);
        if (ticketLines.containsValue(ticketLine)) {
                product.add1ToQuantity();
        } else {
            ticketLines.put(ticketLines.size(), ticketLine);
        }
    }

    @Override
    public double getTotalPrice() {

        return 0;
    }
}
