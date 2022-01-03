import java.util.Date;

public class Discount {
    public Date expiration;
    public Item[] applicableItems;
    public double percent;

    public Discount(Item[] items, Date expirationDate, double discount) {
        this.applicableItems = items;
        this.expiration = expirationDate;
        this.percent = discount;
    }
}
