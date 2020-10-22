package br.com.tiagosantos.carstore.forms;

public class GroupByDecade {
    private int decade;
    private long quantity;

    public GroupByDecade(Float decade, long quantity ) {
        this.decade = decade.intValue();
        this.quantity = quantity;
    }

    public int getDecade() {
        return decade;
    }

    public void setDecade(int decade) {
        this.decade = decade;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
