package org.develop;

public class TicketLine {
    IProduct product;
    public TicketLine (IProduct product) {
        this.product = product;
    }

    public String toString() {
        return product.toString();
    }


}
