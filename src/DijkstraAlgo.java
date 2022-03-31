import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DijkstraAlgo {
    private ArrayList<Integer> visited;
    private ArrayList<Integer> notVisited;
    private List<String[]> weights;
    private ArrayList<City> cities;
    private HashMap<Integer, String> translator;

    public DijkstraAlgo(int numberOfCities, List<String[]> weights, ArrayList<City> cities){
        this.weights = weights;
        notVisited = createNotVisitedArrayList(numberOfCities);
        visited = new ArrayList<>();
        this.cities = cities;
        int steps = 0;
    }

    public void runSim(){
        System.out.println("\n");
        int currentCityID = 0;
        City currentCity = cities.get(0);
        currentCity.setLastVisited(0);
        currentCity.setShortestPath(0);

        while (visited.size() <= cities.size()){
            System.out.println("\n");
            System.out.println("Dijkstra Algorithm:\n");
            System.out.println("Current city is " + currentCity.getName() + "\n");
            String[] currentCityWeights = weights.get(currentCityID);
            currentCity.isVisited();
            int index = 0;
            int lowestWeight = Integer.MAX_VALUE;
            int nextCityID = 0;

            for (String weight:currentCityWeights){
                City neighbour = cities.get(index);

                if(weight.toLowerCase().contains("null") || neighbour.getVisited()){
                    ;
                }
                else{
                    int distanceToNext = Integer.parseInt(weight);
                    int pathToCurrent = currentCity.getShortestPath();
                    int totalPath = pathToCurrent + distanceToNext;
                    int existingShortestPath = neighbour.getShortestPath();

                    if(existingShortestPath > totalPath){
                        neighbour.setShortestPath(totalPath);
                        neighbour.setLastVisited(currentCityID);
                        System.out.println("Unvisited neighbour " + neighbour.getName() + ": " + distanceToNext + " km (total distance is " + neighbour.getShortestPath() + " km)");
                    }
                    else{
                        System.out.println("Unvisited neighbour " + neighbour.getName() + ": " + distanceToNext + " km (total distance is " + totalPath + " - has an equal or a shorter path, " +
                                neighbour.getShortestPath() + " km via " + cities.get(neighbour.getLastVisited()).getName() + ", not updated)");
                    }

                    if(distanceToNext < lowestWeight){
                        lowestWeight = distanceToNext;
                        nextCityID = index;
                    }
                }
                index++;
            }
            visited.add(currentCityID);
            notVisited.set(currentCityID, null);
            cities.get(currentCityID).isVisited();
            currentCityID = nextCityID;
            currentCity = cities.get(currentCityID);
            System.out.println("\n");

            if(nextCityID == 0 && visited.size() < cities.size()){
                System.out.println("No unvisited neighbours, going back to origin");
                lowestWeight = 0;
            }

            if(visited.size() <= cities.size()) {
                System.out.println("Next city is " + cities.get(nextCityID).getName() + ": " + lowestWeight + " km \n");
                System.out.println("=============================================================================\n");
            }
            else {
                System.out.println("All cities visited");
            }
        }
        ArrayList<String> results = new ArrayList<>();

        City city = cities.get(6);

        while(city.getId() != 0){
            results.add(0, city.getName());
            city = cities.get(city.getLastVisited());
        }

        results.add(0, cities.get(0).getName());

        System.out.println("\n");
        System.out.println("Shortest path is:");
        System.out.println(results);
        System.out.println(cities.get(6).getShortestPath() + " km");
    }

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
}
