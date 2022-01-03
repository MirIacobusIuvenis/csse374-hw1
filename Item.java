public class Item {
    public String name;
    public String description;
    public double price;
    public String picture;
    public int quantityInStock;

    public Item(String name, String description, double price, String picture, int quantityInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.quantityInStock = quantityInStock;
    }

    void changeQuantityAvailable(int newQuantity) {
        this.quantityInStock = newQuantity;
    }
}
