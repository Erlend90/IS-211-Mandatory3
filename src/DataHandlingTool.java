import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataHandlingTool {
    private HashMap<Integer, String> intStringTranslator;
    private List<String[]> weights;
    private ArrayList<City> cities;

    public DataHandlingTool() throws IOException {
        intStringTranslator = populateTranslator();

        weights = populateWeights();

        cities = createCities();
    }

    public String translate(int id) {
        return intStringTranslator.get(id);
    }

    public List<String[]> getWeights() {
        return weights;
    }

    public HashMap<Integer, String> populateTranslator() {
        intStringTranslator = new HashMap<>();

        intStringTranslator.put(0, "Timisoara");
        intStringTranslator.put(1, "Lugoj");
        intStringTranslator.put(2, "Mehadia");
        intStringTranslator.put(3, "Drobeta");
        intStringTranslator.put(4, "Craiova");
        intStringTranslator.put(5, "Pitesti");
        intStringTranslator.put(6, "Bucharest");
        intStringTranslator.put(7, "Fagaras");
        intStringTranslator.put(8, "Sibiu");
        intStringTranslator.put(9, "Rimnicu Vilcea");
        intStringTranslator.put(10, "Arad");
        intStringTranslator.put(11, "Zerind");
        intStringTranslator.put(12, "Oradea");

        return intStringTranslator;
    }

    public int numberOfCities() {
        return intStringTranslator.size();
    }

    public List<String[]> populateWeights() throws IOException {
        String path = "src/Travelling_salesman_map.csv";
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String[]> weights = new ArrayList<>();
        String thisLine = "";

        while ((thisLine = br.readLine()) != null) {
            weights.add(thisLine.split(";"));
        }

        return weights;
    }

    public ArrayList<City> createCities(){
        cities = new ArrayList<>();
        int i = 0;
        while(i<numberOfCities()){
            cities.add(new City(translate(i), i));
            i++;
        }
        return cities;
    }

    public ArrayList<City> getCities() {
        return cities;
    }
}
