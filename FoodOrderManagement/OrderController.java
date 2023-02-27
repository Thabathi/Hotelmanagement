package FoodOrderManagement;

import java.util.Scanner;

import com.Model.Menu;
import com.Model.Order;
import com.Model.Restaurant;

public class OrderController {
	 
	    private Order order;
	    private ConsoleView view;
	    private Restaurant restaurant;

	    public OrderController(Order order, ConsoleView view, Restaurant restaurant) {
	        this.order = order;
	        this.view = view;
	        this.restaurant = restaurant;
	    }

	    public void displayRestaurantInfo() {
	        view.displayRestaurantInfo(restaurant);
	    }

	    public void displayVegMenu() {
	    	view.displayMenu(restaurant.getVegMenu());
	    	}
	    public void displayNonVegMenu() {
	        view.displayMenu(restaurant.getNonVegMenu());
	    }

	    public void addToOrder(Menu item) {
	        order.addItem(item);
	    }

	    public void displayOrder() {
	        view.displayOrder(order);
	    }

		public Menu getItemFromMenu() {
			//public Menu getItemFromMenu() {
			    // Display the menu options to the user
			    view.displayMenuOptions();
			    Scanner scanner = new Scanner(System.in);
			    int selection = scanner.nextInt();

			    // Get the corresponding menu item based on the user's selection
			    Menu item;
			    if (selection <= restaurant.getVegMenu().size()) {
			        item = restaurant.getVegMenu().get(selection - 1);
			    } else {
			        item = restaurant.getNonVegMenu().get(selection - 1 - restaurant.getVegMenu().size());
			    }

			    return item;
			}

			 
		}
	    
	




