import java.util.ArrayList;
import java.util.List;

public class GreedyAlgo {
    private int currentCityID;
    private int targetCityID;
    private ArrayList<String> results;
    private ArrayList<City> cities;
    private List<String[]> weights;
    private City currentCity;
    int totalDistance = 0;

    public GreedyAlgo(ArrayList<City> cities, List<String[]> weights){
        currentCityID = 0;
        targetCityID = 6;
        this.cities = cities;
        this.weights = weights;
        int steps = 0;
        results = new ArrayList<>();
    }

    public void runSim(){
        while(currentCityID != targetCityID){
            currentCity = cities.get(currentCityID);
            results.add(currentCity.getName());
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

                    if(distanceToNext<lowestWeight){
                        nextCityID = neighbour.getId();
                        lowestWeight = distanceToNext;
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
        System.out.println("Total distance = " + totalDistance + " km");
    }
}
