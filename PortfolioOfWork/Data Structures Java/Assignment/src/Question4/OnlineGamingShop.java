package Question4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OnlineGamingShop {
    private LinkedList<OnlineGame> onlineGameDetails;
    private Queue<CustomerOrder> customerOrders;
    private Stack<SoldGame> soldGameDetails;
    private HashMap <String, Integer> monthlySalesReport;//hashmap will be used to show sales for each game category
    private double totalMonthlyRevenue;
    private int orderCounter;
    private int totalGamesSold;

    public OnlineGamingShop() {
        this.onlineGameDetails = new LinkedList<>();
        this.customerOrders = new LinkedList<>();
        this.soldGameDetails = new Stack<>();
        this.monthlySalesReport =  new HashMap<>();// monthly sales initialized to 0 at the start of the month
        this.totalMonthlyRevenue = 0.0;// revenue for the total amount of games
        this.orderCounter = 0;// order counter that will track all orders, both successful and unsuccessful
        this.totalGamesSold = 0; // will track the number of games sold
    }

    // Method for adding game to the list
    public void addGame(OnlineGame game) {
        onlineGameDetails.add(game);
    }

    // Adding customer order to queue
    public void addOrder(CustomerOrder order) {
        customerOrders.add(order);
    }


    // Method to process customer orders
    public void processOrder() {
        CustomerOrder order = customerOrders.poll();
        // Retrieve the customer order from the queue
        if (order != null) {
            OnlineGame game = findGame(order.getGameName());
            orderCounter++;// order counter will increment by one when there is an order

            if (game != null && game.getGameQuantity() > 0) {
                game.reduceGameQuantity(); // reduces the quantity of a game when it is ordered

                // Create a SoldGame with all required parameters
                soldGameDetails.push(new SoldGame(game.getGameName(), game.getGameCategory(), game.getGamePrice(), order.getCustomerName()));
                monthlySalesReport.put(game.getGameCategory(), monthlySalesReport.getOrDefault(game.getGameCategory(), 0) + 1);// get or default method will return games based on their key and return a default value if the jey does not exist
                totalMonthlyRevenue += game.getGamePrice();// will add the prices of games sold and display it in monthly report
               totalGamesSold++; // will increment when a game is sold

                System.out.println("Order # " + orderCounter + " processed: " + order.getGameName() + " purchased by " + order.getCustomerName());
            } else {
                System.out.println("Order # " + orderCounter + " Made by " + order.getCustomerName()
                        + " Not processed: " + "The Game ordered is not available: " + order.getGameName());
            }
        } else {
            System.out.println("No orders to process.");
        }
    }

    // Method that finds a game by its name
    public OnlineGame findGame(String gameName) {
        for (OnlineGame game : onlineGameDetails) {
            if (game.getGameName().equalsIgnoreCase(gameName)) {
                return game;
            }
        }
        return null; // Returns null if game name is not found
    }

    // Method that generates the monthly sales report
    public void createMonthlyReport() {
        System.out.println("Monthly report:" + "\nTotal Orders this month: " + orderCounter +
                "\nTotal games sold this month: " + totalGamesSold
                + "\nTotal revenue this month: " + "R" + totalMonthlyRevenue);

        //displaying sold games by category
        for (String gameCategory : monthlySalesReport.keySet()) {
            System.out.println("game category: " + gameCategory + ", games sold: " + monthlySalesReport.get(gameCategory));
        }
    }

    public static void main(String[] args) {
        OnlineGamingShop steamShop = new OnlineGamingShop();
        steamShop.addGame(new OnlineGame("Forza", "Racing", 799.99, 2));
        steamShop.addGame(new OnlineGame("God of War", "Action", 1299.99, 3));
        steamShop.addGame(new OnlineGame("Call of Duty", "FPS Shooter", 1499.99, 1));

        steamShop.displayGameDetails();

   //    steamShop.addOrder(new CustomerOrder("John", "God of war"));
//        steamShop.addOrder(new CustomerOrder("Kay ", "God of War"));
//        steamShop.addOrder(new CustomerOrder("Tristan", "Forza"));
//        steamShop.addOrder(new CustomerOrder("James", "Forza"));
//        steamShop.addOrder(new CustomerOrder("Joe", "Horizon"));

        // Process all orders
        steamShop.processOrder(); // calls proocess orders method


        // Generate the monthly report
        steamShop.createMonthlyReport();
    }

    private void displayGameDetails() {
        System.out.println("Game details: ");
        for (OnlineGame game : onlineGameDetails) {
            System.out.printf("Game Name: %s, Category: %s, Price: R%.2f\n, Quantity: %d\n",
                    game.getGameName(), game.getGameCategory(), game.getGamePrice(), game.getGameQuantity());  // printf is used to properly format the game details
        }
    }
}

// Online Game class
class OnlineGame {
    private String gameName;
    private String gameCategory;
    private double gamePrice;
    private int gameQuantity;

    // Constructor for game fields
    public OnlineGame(String gameName, String gameCategory, double gamePrice, int gameQuantity) {
        this.gameName = gameName;
        this.gameCategory = gameCategory;
        this.gamePrice = gamePrice;
        this.gameQuantity = gameQuantity;
    }

    // Getters
    public String getGameName() {
        return gameName;
    }

    public String getGameCategory() {
        return gameCategory;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public int getGameQuantity() {
        return gameQuantity;
    }

    public void reduceGameQuantity() {
        if (gameQuantity > 0) {
            gameQuantity--;
        }
    }
}

// CustomerOrder class
class CustomerOrder {
    private String customerName;
    private String gameName;

    public CustomerOrder(String customerName, String gameName) {
        this.customerName = customerName;
        this.gameName = gameName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getGameName() {
        return gameName;
    }
}

// SoldGame class inherits from OnlineGame class
class SoldGame extends OnlineGame {
    private String customerName;

    public SoldGame(String gameName, String gameCategory, double gamePrice, String customerName) {
        super(gameName, gameCategory, gamePrice, 1);// game quantity is initialised to 1 as a game is already sold
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }
}