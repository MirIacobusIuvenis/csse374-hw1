import java.util.Date;

public class main {

	public static void main(String[] args) {
	      ShoppingCart test1 = new ShoppingCart();
	      ShoppingCart test2 = new ShoppingCart();
	      ShoppingCart test3 = new ShoppingCart();
	      ShoppingCart test4 = new ShoppingCart();
	      Item outOfStockItem = new Item("Apple", "the fruit", 1.00, "red fruit with green leaf", 0);
	      Item item2 = new Item("Banana", "bunch of 3, other fruit", 1.50, "yellow curved cylindrical fruit", 100);
	      Item item3 = new Item("Orange", "spherical, orange, fruit", 2.00, "spherical, orange, fruit", 50);
	      Item item4 = new Item("Bookshelf", "horizontal planks to hold books", 20.00, "oak wood with glazed finish", 4);
	  //  **Use Case 1 Test**
	  //Add 1 item to the cart
	      System.out.println("TEST Add 1 Item To Cart:");
	      System.out.println(test1.addItem(item2, 1));
	      System.out.println();
	      
	  //Add 2 of an item to the cart
	      System.out.println("TEST Add 2 Items To Cart:");
	      System.out.println(test2.addItem(item3, 2));
	      System.out.println(test2.addItem(item4, 1));
	      System.out.println();
	  
	  //Adds item that is out of stock
	      System.out.println("TEST Item Is Out Of Stock:");
	      System.out.println(test3.addItem(outOfStockItem, 1));
	      System.out.println();
	  
	  //Adds more of item than is available
	      System.out.println("TEST User Wants More Than We Have");
	      System.out.println(test4.addItem(item4, 6));
	      System.out.println();
	      
	  //  **Use Case 2 Test**
	      Item[] itemSet1 = new Item[5];
	      itemSet1[0] = item2;
	      Item[] itemSet2 = new Item[5];
	      itemSet2[0] = item3;
	      itemSet2[1] = item4;
	      Discount discount1 = new Discount(itemSet1, new Date(122, 02, 25), 0.1);
	      Discount discount2 = new Discount(itemSet2, new Date(122, 02, 25), 0.05);
	      Discount discount3 = new Discount(itemSet1, new Date(121, 00, 01), 0.1);
	  //Supplies valid discount code for one item
	      System.out.println("TEST Valid Discount Code: 1 Item");
	      System.out.println(test1.applyDiscount(discount1));
	      System.out.println();
	      
	  //Supplies valid discount code for several items
	      System.out.println("TEST Valid Discount Code: Multiple Items");
	      System.out.println(test2.applyDiscount(discount2));
	      System.out.println();
	  
	  //Supplies expired discount code
	      System.out.println("TEST Expired Discount Code");
	      System.out.println(test1.applyDiscount(discount3));
	      System.out.println();
	  
	  //Supplies discount code for item that is not in the cart
	      System.out.println("TEST Item Not In Cart");
	      System.out.println(test1.applyDiscount(discount1));
	      System.out.println();
	  
	  //  **Use Case 3 Test**
	  //Adds more to quantity of item
	      System.out.println("TEST Add More Of Item");
	      System.out.println(test1.changeItemQuantity(item2, 3));
	      System.out.println();
	  
	  //Removes some of the quantity of item
	      System.out.println("TEST Remove Some Of Item");
	      System.out.println(test2.changeItemQuantity(item3, 1));
	      System.out.println();
	  
	  //Removes item altogether
	      System.out.println("TEST Remove Item Alltogether");
	      System.out.println(test3.changeItemQuantity(item2, 0));
	      System.out.println();
	  
	  //Item has gone out of stock
	      System.out.println("TEST Item has since gone out of stock");
	      System.out.println(test4.addItem(item4, 3));
	      item4.changeQuantityAvailable(0);
	      System.out.println(test4.changeItemQuantity(item4, 1));
	      System.out.println();
	  
	  //  **Use Case 0 Test**
	  //Retrieve cart
	      System.out.println("TEST View Cart");
	      System.out.println(test1.viewCart());
	      System.out.println(test2.viewCart());
	      System.out.println(test3.viewCart());
	      System.out.println(test4.viewCart());
	}
}
