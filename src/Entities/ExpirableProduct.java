package Entities;

import java.util.Date;

public class ExpirableProduct extends Product {

    private Date expirationDate;

    public ExpirableProduct(String name, double price, int quantity,Date expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean isExpired() {
        return new Date().after(expirationDate);
    }

    @Override
    public boolean needsShipping() {
        return true;
    }
}
