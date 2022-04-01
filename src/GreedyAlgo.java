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


        while(currentCityID != targetCityID){
            currentCity = cities.get(currentCityID); steps++;
            results.add(currentCity.getName()); steps++;
            String[] currentCityWeights = weights.get(currentCityID); steps++;
            currentCity.isVisited(); steps++;
            int index = 0;
            int lowestWeight = Integer.MAX_VALUE;
            int nextCityID = 0;

            for (String weight:currentCityWeights){
                City neighbour = cities.get(index);

                if(weight.toLowerCase().contains("null") || neighbour.getVisited()){
                    steps++;
                }
                else{
                    steps++;
                    int distanceToNext = Integer.parseInt(weight);

                    if(distanceToNext<lowestWeight){
                        nextCityID = neighbour.getId();
                        lowestWeight = distanceToNext;
                        steps++;
                    }
                }
                index++;
            }
            currentCityID = nextCityID;
            totalDistance += lowestWeight;
        }
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
