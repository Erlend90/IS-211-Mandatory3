# IS-211-Mandatory3

For this assignment I have elected to implement and compare Dijkstras algorithm and a strictly greedy algorithm. Dijkstras algorithm is a classic algorithm 
to solve the Travelling Salesman Problem, which will check every node and the weights for the paths to its neighbours, and will find the shortest path 
every time. The strictly greedy algorithm, by contrast, will always choose the locally optimal path, and not care about the optimal global path at all.

The reasoning for me choosing these specific algorithms, and in particular choosing the strictly greedy algorithm over a more complex approximation 
algorithm, is two-fold:

Firstly, despite being a very basic algorithm, I believe it still illustrates the trade-off between choosing a "lighter" algorithm which will approximate 
an answer and give you performance over precision, and the more thourough and "heavy" algorithm which trades performance for accuracy.

Second, I have been the subject of some scheduling which has been fully out of my own control (if professors or TAs want more information about this, feel 
free to contact me directly). Hence I have not had a lot of time to study, understand and implement another more complex algorithm.


## Assumptions

To solve this problem I have made certain assumptions and preparations;

1)  I made the map of Romania into an Excel spreadsheet, which was then saved to a CSV file, representing the distances between the neighbouring cities.
2)  In the CSV file I excluded all cities east of Bucharest, as logically going further easst once you get to your destination, and then going back west
    to Bucharest, will never be shorter than the path you took to get there originally.
3)  I have made some effort to try to make the program object oriented, and to ensure loose coupling and encapsulation, but due to the aforementioned time
    constraints the actual algorithm classes may be a bit more messy. I have therefore added comments to explain these classes in particular.
4)  For the benchmarking I have made the assumption that the desired output is to calculate the amount of steps taken by each algorithm rather than the
    time taken (or whatever else), as I assume that it is the time complexity/Big (O) of the algorithms we are interested in when comparing two algorithms 
    performance and results. I will define the steps for each algorithm below, and the program will count them, present the results and compare them
    to each other.
    
    
## Dijkstras algorithm

My implementation for Dijkstras algorithm is largely based off this video: https://www.youtube.com/watch?v=pVfj6mxhdMw&ab_channel=ComputerScience

I have defined the steps of my implementation to be as follows (I will not list the steps which are setting up the simulations etc., only the steps which
are part of the actual decision making process of the algorithm):

WHILE CITIES STILL UNVISITED:
  - Determine current city
  - Pull all neighbouring cities from table
  - Set current city as visited
  FOR EACH UNVISITED NEIGHBOURING CITY:
    - IF not null and not already visited
        - IF this path (global) is shorter than existing shortest path, update shortest path
        - IF this path (global) is shorter than existing shortest path, update last visited city
        - IF path to this city (local) is shorter than previously selected shortest path, select 
          this path as next city to visit
  - Set city with shortest path as next city to visit
- Track shortest path backwards from destination to origin


## Strict greedy algorithm

Although Dijkstras algorithm is also a greedy algorithm, the strict greedy algorithm will only ever choose the path to the nearesst unvisited city, and 
take no notice whether or not there are unvisited cities and a shorter path might exist. Once it reaches the target destination, the algorithm will 
terminate. The algorithm has been implemented from my own understanding of this algorithm, and is a simple enough concept that I believe no source is 
needed.

I have defined the steps of this algorithm as follows (same conditions apply as for Dijkstras algorithm):

WHILE NOT AT TARGET CITY
  - Determine current city
  - Add current city to results
  - Pull all neighbouring cities from table
  - Set current city as visited
  FOR EACH UNVISITED NEIGHBOURING CITY
    - IF not null and not already visited
        - IF this (local) path is shorter than existing shortest path, update shortest path
  - Go to next city


## Results

Dijkstra Algorithm:

Current city is Timisoara

Unvisited neighbour Lugoj: 111 km (total distance is 111 km)
Unvisited neighbour Arad: 118 km (total distance is 118 km)


Next city is Lugoj: 111 km 

=============================================================================

Current city is Lugoj

Unvisited neighbour Mehadia: 70 km (total distance is 181 km)


Next city is Mehadia: 70 km 

=============================================================================

Current city is Mehadia

Unvisited neighbour Drobeta: 75 km (total distance is 256 km)


Next city is Drobeta: 75 km 

=============================================================================

Current city is Drobeta

Unvisited neighbour Craiova: 120 km (total distance is 376 km)


Next city is Craiova: 120 km 

=============================================================================

Current city is Craiova

Unvisited neighbour Pitesti: 138 km (total distance is 514 km)
Unvisited neighbour Rimnicu Vilcea: 146 km (total distance is 522 km)


Next city is Pitesti: 138 km 

=============================================================================

Current city is Pitesti

Unvisited neighbour Bucharest: 101 km (total distance is 615 km)
Unvisited neighbour Rimnicu Vilcea: 97 km (total distance is 611 - has an equal or a shorter path, 522 km via Craiova, not updated)


Next city is Rimnicu Vilcea: 97 km 

=============================================================================

Current city is Rimnicu Vilcea

Unvisited neighbour Sibiu: 80 km (total distance is 602 km)


Next city is Sibiu: 80 km 

=============================================================================

Current city is Sibiu

Unvisited neighbour Fagaras: 99 km (total distance is 701 km)
Unvisited neighbour Arad: 140 km (total distance is 742 - has an equal or a shorter path, 118 km via Timisoara, not updated)
Unvisited neighbour Oradea: 151 km (total distance is 753 km)


Next city is Fagaras: 99 km 

=============================================================================

Current city is Fagaras

Unvisited neighbour Bucharest: 211 km (total distance is 912 - has an equal or a shorter path, 615 km via Pitesti, not updated)


Next city is Bucharest: 211 km 

=============================================================================

Current city is Bucharest



No unvisited neighbours, going back to origin
Next city is Timisoara: 0 km 

=============================================================================

Current city is Timisoara

Unvisited neighbour Arad: 118 km (total distance is 118 - has an equal or a shorter path, 118 km via Timisoara, not updated)


Next city is Arad: 118 km 

=============================================================================

Current city is Arad

Unvisited neighbour Zerind: 75 km (total distance is 193 km)


Next city is Zerind: 75 km 

=============================================================================

Current city is Zerind

Unvisited neighbour Oradea: 71 km (total distance is 264 km)


Next city is Oradea: 71 km 

=============================================================================

Current city is Oradea



All cities visited


Shortest path is:
[Timisoara, Lugoj, Mehadia, Drobeta, Craiova, Pitesti, Bucharest]
615 km


=============================================================================

Greedy algorithm: 

Results = [Timisoara, Lugoj, Mehadia, Drobeta, Craiova, Pitesti, Rimnicu Vilcea, Sibiu, Fagaras]
1001 km

=============================================================================

Comparison: 

Dikjstra algorithm number of steps = 279, shortest path = 615

Strict greedy algorithm number of steps = 163, shortest path = 1001

For this sim the Dijkstra algorithm takes 71% more steps than the strict greedy algorithm 

The path found by the strict greedy algorithm is 62% longer than the path found by the Dijkstra algorithm

Process finished with exit code 0


## Reflection

As can be seen from the results, the strict greedy algorithm is more efficient than Dijkstras algorithm, but yields worse results. This is a good 
illustration of the trade off one makes by running an algorithm that does not consider every option vs an algorithm which visits every node and examines 
every connection. There are other approximation algorithms which yield better results than the strict greedy algorithm I implemented, and will be much 
closer to the Dijkstra algorithm in precision.
