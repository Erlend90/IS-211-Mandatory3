import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataHandlingTool data = new DataHandlingTool();

        Algorithm alg = new Algorithm(data.numberOfCities(), data.getWeights(), data.getCities());

        alg.runSim();
    }
}
