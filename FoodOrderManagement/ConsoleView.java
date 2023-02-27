package FoodOrderManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Model.Menu;
import com.Model.Order;
import com.Model.Restaurant;

public class ConsoleView {
	 
	    private Restaurant restaurant;
	    public ConsoleView(Restaurant restaurant) {
	        this.restaurant = restaurant;
	    }

		public void displayRestaurantInfo(Restaurant restaurant) {
	        System.out.println("Restaurant Name: " + restaurant.getName());
	        System.out.println("Buffet Details: " + restaurant.getBuffet());
	    }

	    public void displayMenu(List<Menu> menuList) {
	        System.out.println("Menu:");
	        for (Menu item : menuList) {
	            System.out.println(item.getName() + " - " + item.getType() + " - " + item.getPrice());
	        }
	    }

	    public Menu getItemFromMenu() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the name of the item to order: ");
	        String itemName = scanner.nextLine();
	        System.out.println("Enter the type of the item (veg/non-veg): ");
	        String itemType = scanner.nextLine();
	        System.out.println("Enter the price of the item: ");
	        double itemPrice = scanner.nextDouble();
	        return new Menu(itemName, itemType, itemPrice);
	    }

	    public void displayOrder(Order order) {
	        System.out.println("Order:");
	        for (Menu item : order.getItems()) {
	            System.out.println(item.getName() + " - " + item.getType() + " - " + item.getPrice());
	        }
	        System.out.println("Total: " + order.getTotal());
	    }
	    public static void main(String[] args) {
	    	List<Menu> vegMenu = new ArrayList<>();
	    	vegMenu.add(new Menu("Veg Biriyani", "veg", 100));
	    	vegMenu.add(new Menu("Veg Fried Rice", "veg", 80));
	    	vegMenu.add(new Menu("Veg Noodles", "veg", 90));
	        List<Menu> nonVegMenu = new ArrayList<>();
	        nonVegMenu.add(new Menu("Chicken Biriyani", "non-veg", 150));
	        nonVegMenu.add(new Menu("Mutton Biriyani", "non-veg", 200));
	        nonVegMenu.add(new Menu("Fish Curry", "non-veg", 180));

	        Restaurant restaurant = new Restaurant("Spicy Bites", "Lunch Buffet - 12:00 PM to 3:00 PM", vegMenu, nonVegMenu);

	        // Initialize the order and view
	        Order order = new Order();
	        ConsoleView view = new ConsoleView(restaurant);

	        // Initialize the controller
	        OrderController controller = new OrderController(order, view, restaurant);

	        // Display restaurant information and menu
	        controller.displayRestaurantInfo();
	        System.out.println();
	        System.out.println("Veg Menu:");
	        controller.displayVegMenu();
	        System.out.println();
	        System.out.println("Non-Veg Menu:");
	        controller.displayNonVegMenu();
	        System.out.println();
 
	        boolean done = false;
	        while (!done) {
	            Menu item = controller.getItemFromMenu();
	            controller.addToOrder(item);
	            System.out.println("Item added to order. Press 'Y' to add another item or any other key to proceed to billing.");
	            Scanner scanner = new Scanner(System.in);
	            String input = scanner.nextLine();
	            if (!input.equalsIgnoreCase("Y")) {
	                done = true;
	            }
	        }
     
	        controller.displayOrder();
	    }

	    public void displayMenuOptions() {
	        System.out.println("Please select an item from the menu options below:");
	        System.out.println("Veg Menu:");
	        List<Menu> vegMenu = restaurant.getVegMenu();
	        for (int i = 0; i < vegMenu.size(); i++) {
	            System.out.println((i + 1) + ". " + vegMenu.get(i).getName() + " - " + vegMenu.get(i).getPrice() + " INR");
	        }
	        System.out.println("Non-Veg Menu:");
	        List<Menu> nonVegMenu = restaurant.getNonVegMenu();
	        for (int i = 0; i < nonVegMenu.size(); i++) {
	            System.out.println((i + 1 + vegMenu.size()) + ". " + nonVegMenu.get(i).getName() + " - " + nonVegMenu.get(i).getPrice() + " INR");
	        }
	    }

	    	
	    	
	    }
	



