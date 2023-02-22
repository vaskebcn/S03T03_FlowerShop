package org.develop;

import java.util.HashMap;

public interface ITicket {
    public void addTicketLine(Product product, int quantity);
    public void calculateTotalPrice();

}
