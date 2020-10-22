package br.com.tiagosantos.carstore.forms;

public class GroupByBrand {
    private String brand;
    private long quantity;

    public GroupByBrand( String brand, long quantity ) {
        this.brand = brand;
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
