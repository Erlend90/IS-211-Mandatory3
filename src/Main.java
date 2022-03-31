import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataHandlingTool data = new DataHandlingTool();

        DijkstraAlgo dijkstra = new DijkstraAlgo(data.numberOfCities(), data.getWeights(), data.getCities());
        int dijkstraSteps = dijkstra.runSim();

        data.clearVisited(data.getCities());

        GreedyAlgo greedy = new GreedyAlgo(data.getCities(), data.getWeights());
        int greedySteps = greedy.runSim();

        System.out.println("=============================================================================\n");
        System.out.println("Comparison: \n");
        System.out.println("Dikjstra algorithm number of steps = " + dijkstraSteps);
        System.out.println("\n");
        System.out.println("Strict greedy algorithm number of steps = " + greedySteps);
    }
}
