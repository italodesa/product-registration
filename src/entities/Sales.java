package entities;

import java.util.ArrayList;

public class Sales {
    ArrayList<Sale> sales = new ArrayList<Sale>();

    public void addSale(Sale sale){
        sales.add(sale);
    }
}
