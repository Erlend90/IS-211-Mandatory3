import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataHandlingTool data = new DataHandlingTool();

        DijkstraAlgo dijkstra = new DijkstraAlgo(data.numberOfCities(), data.getWeights(), data.getCities());
        dijkstra.runSim();

        data.clearVisited(data.getCities());

        GreedyAlgo greedy = new GreedyAlgo(data.getCities(), data.getWeights());
        greedy.runSim();
    }
}
