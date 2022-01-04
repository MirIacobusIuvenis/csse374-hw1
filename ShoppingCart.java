import java.util.Date;

public class ShoppingCart {
    public Item[] items;
    public int[] quantity;
    public double price;
    public double discountTotal;
    public double[] discount;

    public ShoppingCart() {
        this.items = new Item[20];
        this.quantity = new int[20];
        this.discount = new double[20];
        this.price = 0;
        this.discountTotal = 0;
    }

    String viewCart() {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < this.items.length; i++) {
    		if(this.items[i] != null) {
    			sb.append("Item Name: " + this.items[i].name + "\n");
    			sb.append("Item Description: " + this.items[i].description + "\n");
    			sb.append("Item Picture: " + this.items[i].picture + "\n");
    			sb.append("Quantity in Cart: " + this.quantity[i] + "\n");
    			sb.append("Item Unit Price (After Discount): " + (this.items[i].price - (this.items[i].price * this.discount[i])) + "\n");
    			if(this.items[i].quantityInStock == 0) {
    				sb.append("\n");
    				sb.append("***ITEM IS CURRENTLY OUT OF STOCK***");
    			}
    			sb.append("\n" + "\n");
    		}
    	}
    	sb.append("Total Savings!" + "\n" + this.discountTotal + "\n" + "Final Price" + "\n" + this.price + "\n");
        return sb.toString();
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

    String applyDiscount(Discount code) {
    	if(code.expiration.before(new Date())) {
    		return "Code is expired, sorry! Please enter a valid discount code.";
    	}
    	double tempPrice = this.price;
    	for(int i = 0; i < this.items.length; i++) {
    		for(int j = 0; j < code.applicableItems.length; j++) {
    			if(items[i] == code.applicableItems[j]) {
    				this.discount[i] = code.percent;
    				calculatePrice();
    			}
    		}
    	}
    	if(tempPrice == this.price) {
    		StringBuilder discountsb = new StringBuilder();
    		discountsb.append("Cart doesn't contain item(s): ");
    		for(int i = 0; i < code.applicableItems.length; i++) {
    			if(code.applicableItems[i] != null) {
    				discountsb.append(code.applicableItems[i].name + ", ");
    			}
    		}
    		discountsb.delete(discountsb.length()- 2, discountsb.length());
    		return discountsb.toString();
    	}
        return "Cart Price is: " + this.price + "\n" + "Total Discount (Total Savings) Is: " + this.discountTotal;
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
                this.discount[i] = 0;
                calculatePrice();
                break;
            }
        }
        return "The item(s) have been added to your cart!";
    }
}

    void calculatePrice() {
        this.price = 0;
        for(int i = 0; i < this.items.length; i++) {
            if(this.items[i] != null) {
                this.price += (this.items[i].price * this.quantity[i]) - (this.items[i].price * this.quantity[i] * this.discount[i]);
                this.discountTotal += (this.items[i].price * this.quantity[i] * this.discount[i]);
            }
        }    
    }
}