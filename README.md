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
    - IF this path is shorter than existing shortest path, update shortest path
    - IF this path is shorter than existing shortest path, update last visited city
    - IF path to this city is shorter than previously selected shortest path, select this path as next city to visit
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
  - Pull all neighbouring cities from table
  - Set current city as visited
  - Add current city to results
  FOR EACH UNVISITED NEIGHBOURING CITY
    - IF this path is shorter than existing shortest path, update shortest path
  - Go to next city
