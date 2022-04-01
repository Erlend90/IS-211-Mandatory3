import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DijkstraAlgo {
    private ArrayList<Integer> visited;
    private ArrayList<Integer> notVisited;
    private List<String[]> weights;
    private ArrayList<City> cities;
    private HashMap<Integer, String> translator;
    private int steps;
    private int shortestPath;

    public DijkstraAlgo(int numberOfCities, List<String[]> weights, ArrayList<City> cities){
        this.weights = weights;
        notVisited = createNotVisitedArrayList(numberOfCities);
        visited = new ArrayList<>();
        this.cities = cities;
        steps = 0;
        shortestPath = 0;
    }

    public void runSim(){

        //setup
        System.out.println("\n");
        int currentCityID = 0;
        City currentCity = cities.get(0);
        currentCity.setLastVisited(0);
        currentCity.setShortestPath(0);
        System.out.println("Dijkstra Algorithm:\n");

        //runs until all cities are visited
        while (visited.size() <= cities.size()){
            System.out.println("Current city is " + currentCity.getName() + "\n"); steps++;

            // gets the weights for current city and sets it as visited + more setup
            String[] currentCityWeights = weights.get(currentCityID); steps++;
            currentCity.isVisited(); steps++;
            int index = 0;
            int lowestWeight = Integer.MAX_VALUE;
            int nextCityID = 0;

            //examines path to all neighbouring cities
            for (String weight:currentCityWeights){
                City neighbour = cities.get(index);

                //checks if null or already visited
                if(weight.toLowerCase().contains("null") || neighbour.getVisited()){
                    steps++;
                }
                else{
                    steps++;
                    //parses the weight and does calculations
                    int distanceToNext = Integer.parseInt(weight);
                    int pathToCurrent = currentCity.getShortestPath();
                    int totalPath = pathToCurrent + distanceToNext;
                    int existingShortestPath = neighbour.getShortestPath();

                    //updates values if shorter path found
                    if(existingShortestPath > totalPath){
                        neighbour.setShortestPath(totalPath); steps++;
                        neighbour.setLastVisited(currentCityID); steps++;
                        System.out.println("Unvisited neighbour " + neighbour.getName() + ": " + distanceToNext + " km (total distance is " + neighbour.getShortestPath() + " km)");
                    }
                    else{
                        System.out.println("Unvisited neighbour " + neighbour.getName() + ": " + distanceToNext + " km (total distance is " + totalPath + " - has an equal or a shorter path, " +
                                neighbour.getShortestPath() + " km via " + cities.get(neighbour.getLastVisited()).getName() + ", not updated)");
                    }

                    //examines if the path to the currently examined city is the shortest path available to neighbours
                    if(distanceToNext < lowestWeight){
                        lowestWeight = distanceToNext;
                        nextCityID = index; steps++;
                    }
                }
                index++;
            }
            //updating visited and not visited tables, sets up next city to be visited
            visited.add(currentCityID);
            notVisited.set(currentCityID, null);
            currentCityID = nextCityID; steps++;
            currentCity = cities.get(currentCityID);
            System.out.println("\n");

            //clause to solve if no unvisited neighbours, goes back to start
            if(nextCityID == 0 && visited.size() < cities.size()){
                System.out.println("No unvisited neighbours, going back to origin");
                lowestWeight = 0;
                steps++;
            }

            if(visited.size() <= cities.size()) {
                System.out.println("Next city is " + cities.get(nextCityID).getName() + ": " + lowestWeight + " km \n");
                System.out.println("=============================================================================\n");
            }
            else {
                System.out.println("All cities visited");
            }
        }

        //set up and present results
        ArrayList<String> results = new ArrayList<>();

        City city = cities.get(6);

        while(city.getId() != 0){
            results.add(0, city.getName());
            city = cities.get(city.getLastVisited());
        }

        results.add(0, cities.get(0).getName());

        shortestPath = cities.get(6).getShortestPath();

        steps++;

        System.out.println("\n");
        System.out.println("Shortest path is:");
        System.out.println(results);
        System.out.println(cities.get(6).getShortestPath() + " km");
    }

    //method to set up arraylist
    public ArrayList<Integer> createNotVisitedArrayList(int numberOfCities){
        notVisited = new ArrayList<>();
        int i = 0;
        while(i<numberOfCities){
            notVisited.add(i);
            i++;
        }
        //System.out.println(notVisited.toString());
        return notVisited;
    }

    public int getShortestPath(){
        return shortestPath;
    }

    public int getSteps(){
        return steps;
    }
}
