import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataHandlingTool data = new DataHandlingTool();

        DijkstraAlgo dijkstra = new DijkstraAlgo(data.numberOfCities(), data.getWeights(), data.getCities());
        dijkstra.runSim();
        int dijkstraSteps = dijkstra.getSteps();
        int dijkstraShortestPath = dijkstra.getShortestPath();

        data.clearVisited(data.getCities());

        GreedyAlgo greedy = new GreedyAlgo(data.getCities(), data.getWeights());
        greedy.runSim();
        int greedySteps = greedy.getSteps();
        int greedyShortestPath = greedy.getTotalDistance();

        System.out.println("=============================================================================\n");
        System.out.println("Comparison: \n");
        System.out.println("Dikjstra algorithm number of steps = " + dijkstraSteps + ", shortest path = " + dijkstraShortestPath + "\n");
        System.out.println("Strict greedy algorithm number of steps = " + greedySteps + ", shortest path = " + greedyShortestPath + "\n");
        System.out.println("For this sim the Dijkstra algorithm takes " + ((dijkstraSteps*100/greedySteps)-100) + "% more steps than the strict greedy algorithm \n");
        System.out.println("The path found by the strict greedy algorithm is " + ((greedyShortestPath*100/dijkstraShortestPath)-100) + "% longer than the path found by the Dijkstra algorithm");
    }
}
