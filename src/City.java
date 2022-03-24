public class City {
    private String name;
    private int id;
    private int shortestPath;
    private int lastVisited;
    private boolean visited;

    public City (String name, int id){
        this.name = name;
        this.id = id;
        shortestPath = Integer.MAX_VALUE;
        visited = false;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getShortestPath() {
        return shortestPath;
    }

    public int getLastVisited() {
        return lastVisited;
    }

    public boolean getVisited(){
        return visited;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShortestPath(int shortestPath) {
        this.shortestPath = shortestPath;
    }

    public void setLastVisited(int lastVisited) {
        this.lastVisited = lastVisited;
    }

    public void isVisited() {
        visited = true;
    }
}
