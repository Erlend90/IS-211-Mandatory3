import java.util.ArrayList;
import java.util.List;

public class GreedyAlgo {
    private int currentCityID;
    private int targetCityID;
    private ArrayList<String> results;
    private ArrayList<City> cities;
    private List<String[]> weights;
    private City currentCity;
    int totalDistance;
    int steps;

    public GreedyAlgo(ArrayList<City> cities, List<String[]> weights){
        totalDistance = 0;
        steps = 0;
        currentCityID = 0;
        targetCityID = 6;
        this.cities = cities;
        this.weights = weights;
        results = new ArrayList<>();
    }

    public void runSim(){
        //runs until at target city
        while(currentCityID != targetCityID){

            //fetches current city object, adds the name to the result arraylist
            currentCity = cities.get(currentCityID); steps++;
            results.add(currentCity.getName()); steps++;

            //fetches distances to neighbours
            String[] currentCityWeights = weights.get(currentCityID); steps++;

            //sets city as visited
            currentCity.isVisited(); steps++;

            //setup
            int index = 0;
            int lowestWeight = Integer.MAX_VALUE;
            int nextCityID = 0;

            //examines distance to all neighbours
            for (String weight:currentCityWeights){
                City neighbour = cities.get(index);

                if(weight.toLowerCase().contains("null") || neighbour.getVisited()){
                    steps++;
                }
                else{
                    steps++;
                    int distanceToNext = Integer.parseInt(weight);

                    //checks if this is the shortest distance to neighbours
                    if(distanceToNext<lowestWeight){
                        nextCityID = neighbour.getId();
                        lowestWeight = distanceToNext;
                        steps++;
                    }
                }
                index++;
            }

            //sets up next city and calculates current path
            currentCityID = nextCityID;
            totalDistance += lowestWeight;
        }
        //presents results
        System.out.println("\n");
        System.out.println("=============================================================================\n");
        System.out.println("Greedy algorithm: \n");
        System.out.println("Results = " + results);
        System.out.println(totalDistance + " km\n");

    }

    public int getSteps() {
        return steps;
    }

    public int getTotalDistance() {
        return totalDistance;
    }
}
