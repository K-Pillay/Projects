package Question3;

import java.util.*;

//steps to follow
// 1 create nodes for bus destination and departure points - use link list for nodes and connection.
// 2: create edges between nodes and make them bidirectional
// 3 Store nodes and data in linked list
// 4 Get input from user (destination and departure)
// 5 create method to initialise the bus stops with the locations ( use a hash map to store data )
// 6 create method to traverse the nodes and display all the journey information

public class BusNetwork extends BusStopNodes {
    //call to super
    public BusNetwork(String busStopName) {
        super(busStopName);
    }

    private static HashMap<String, BusStopNodes> BusStopMap = new HashMap<>(); // hashmap that will store the bust stop names as key value pairs


    public static void main(String[] args) {
        initialiseBusStopNodes();// calls method that initialises all bus stops

//retrieving user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter your departure point: ");
        String departurePoint = scanner.nextLine().trim();
        System.out.print("Please Enter your destination point: ");
        String destinationPoint = scanner.nextLine().trim();
        scanner.close();

//retrieve the departure and destination point from user, and compare values stored in the hash map
        BusStopNodes departure = BusStopMap.get(departurePoint);
        BusStopNodes destination = BusStopMap.get(destinationPoint);


        // if statement that will check if there is user input

        if (departure == null || destination == null) {
            System.out.println("Invalid/no departure or destination point found. Please check your both your departure and destination point are correct.");

        } else {
            TraverseBusStops(departure, destination); // call the method that will traverse the bus stops and display all the information on the journey
        }
    }

    //Method to initialise the bus stops and the bidirectional connections between stations
    private static void initialiseBusStopNodes() {
        //creating nodes
        BusStopNodes JohannesburgCBD = new BusStopNodes("Johannesburg CBD");
        BusStopNodes ParkStation = new BusStopNodes("Park Station");
        BusStopNodes Midrand = new BusStopNodes("Midrand");
        BusStopNodes Centurion = new BusStopNodes("Centurion");
        BusStopNodes PretoriaCBD = new BusStopNodes("Pretoria CBD");

        //add Bus stops and the names to the hashmap for easy retrieval
        BusStopMap.put(JohannesburgCBD.BusStopName, JohannesburgCBD);
        BusStopMap.put(ParkStation.BusStopName, ParkStation);
        BusStopMap.put(Midrand.BusStopName, Midrand);
        BusStopMap.put(Centurion.BusStopName, Centurion);
        BusStopMap.put(PretoriaCBD.BusStopName, PretoriaCBD);


        //adding the bidirectional connections
        JohannesburgCBD.addEdge(ParkStation);
        ParkStation.addEdge(Midrand);
        Midrand.addEdge(Centurion);
        Centurion.addEdge(PretoriaCBD);
    }

    // Method to display all the journey info and traverse the graph through BFS.
    private static void TraverseBusStops(BusStopNodes departure, BusStopNodes destination) {
        System.out.println("Departure point: " + departure.BusStopName);
        System.out.println("Destination point: " + destination.BusStopName);
        System.out.println("Stations en route to your destination:");

        Queue<BusStopNodes> queue = new LinkedList<>();
        Set<BusStopNodes> visited = new HashSet<>(); // Track all visited nodes

       // adding departure points to the queue and set
        queue.add(departure);
        visited.add(departure);

        while (!queue.isEmpty()) {
            BusStopNodes currentNode = queue.poll();

            // If we reach the destination, print and exit
            if (currentNode == destination) {
                System.out.println("Arrived at destination: " + currentNode.BusStopName);
                return;
            }

            // Traverse each connected bus stop (neighbor)
            for (BusStopNodes neighbor : currentNode.edges) {
                // Only proceed if neighbor has not been visited
                if (!visited.contains(neighbor)) {
                    System.out.println("Current Station: " + currentNode.BusStopName +
                            " ---> Next Station: " + neighbor.BusStopName);

                    visited.add(neighbor); // Mark the nodes that have been visted
                    queue.add(neighbor);   // Add the visited nodes to the queue.
                }
            }
        }

        // will be printed in the scenario that the destination cannot be reached
        System.out.println("Cannot reach destination from route chosen");
    }
}