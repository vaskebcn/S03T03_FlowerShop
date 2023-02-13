package org.develop;

import java.util.HashMap;

public interface ITicket {
    static int idCounter = 1;
    int id = 0;
    public HashMap<Integer,TicketLine> ticketLines = new HashMap<Integer,TicketLine>();
    double totalPrice = 0;

    public void addProduct(Product product);
    public double getTotalPrice();
}
