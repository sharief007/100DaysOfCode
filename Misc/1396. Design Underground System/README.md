[1396. Design Underground System](https://leetcode.com/problems/design-underground-system/)

### Approach

- Time Complexity
0. new instance(): O(1)
1. check in: O(1)
2. check out: O(1)
3. avg. time: O(N)  // depends on number of passangers
- Space Complexity: O(N)

```java
class UndergroundSystem {

    private final Map<String, List<Integer>> distance;
    private final Map<Integer, Station> records;
    
    public UndergroundSystem() {
        this.distance = new HashMap<>();
        this.records = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        records.put(id, new Station(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(records.containsKey(id)) {
            Station source = records.get(id);
            String key = source.name + '$' + stationName;
            List<Integer> times = distance.getOrDefault(key, new LinkedList<>());
            times.add(t - source.time);
            distance.put(key, times);
        }         
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + '$' + endStation;
        List<Integer> distances = distance.get(key);
        if(distances != null) {
            int sum = 0;
            for(int d : distances) {
                sum += d;
            }
            
            return (double) sum / distances.size();
        }
        return 0;
    }
    
    private class Station {
        String name;
        int time;
        Station(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
```