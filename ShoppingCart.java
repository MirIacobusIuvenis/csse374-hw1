import java.util.Date;

public class ShoppingCart {
    public Item[] items;
    public int[] quantity;
    public float price;
    public float discountTotal;
    public float[] discount;

    public ShoppingCart() {
        this.items = new Item[20];
        this.quantity = new int[20];
        this.discount = new float[20];
        this.price = 0;
        this.discountTotal = 0;
    }

    /* NEEDS IMPLEMENTED */
    String viewCart() {
        return "Okay?";
    }

    String changeItemQuantity(Item thing, int newQuantity) {
        if(thing.quantityInStock < newQuantity) {
            return "There is not enough of that item in stock, sorry";
        } else if(thing.quantityInStock == 0) {
            return viewCart();
        } else {
            for(int i = 0; i < this.items.length; i++) {
                if(this.items[i] == thing) {
                    this.quantity[i] = newQuantity;
                    calculatePrice();
                }
            }
            return viewCart();
        }
    }

    /* NEEDS IMPLEMENTED */
    String applyDiscount(Discount code) {
    	if(code.expiration.before(new Date())) {
    		return "Code is expired, sorry! Please enter a valid discount code.";
    	}
        return "FUCK";
    }

    String addItem(Item thing, int quantity) {
        if(thing.quantityInStock == 0) {
            return "Item is out of stock, sorry";
        } else if (thing.quantityInStock < quantity) {
            return "There is not enough of that item available, please enter a valid quantity";
        } else {
        for(int i = 0; i < this.items.length; i++) {
            if(this.items[i] == null) {
                this.items[i] = thing;
                this.quantity[i] = quantity;
                this.discount[i] = 1;
                calculatePrice();
            }
        }
        return "The item(s) have been added to your cart!";
    }
}

    void calculatePrice() {
        this.price = 0;
        for(int i = 0; i < this.items.length; i++) {
            if(this.items[i] != null) {
                this.price += this.items[i].price * this.quantity[i] * this.discount[i];
            }
        }    
    }
}