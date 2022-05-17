[399. Evaluate Division](https://leetcode.com/problems/evaluate-division/)

You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

```text
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
```

### Approach (DFS) - Stolen

- Time Complexity: O(N^2)
- Space Complexity: O(N)

```java
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = constructMap(equations, values);
        double[] result = new double[queries.size()];
        
        for(int i=0;i<queries.size(); i++) {
            result[i] = calc(queries.get(i).get(0), queries.get(i).get(1), map, new HashSet<>());
        }
        return result;    
    }    
    
    private double calc(String num, String dem, Map<String, Map<String, Double>> map, Set<String> set) {
        
        if(! map.containsKey(num)) return -1.0;
        
        if( map.get(num).containsKey(dem)) {
            return map.get(num).get(dem);
        }
        
        for(Map.Entry<String, Double> entr : map.get(num).entrySet()) {
            if(set.add(entr.getKey())) {
                double val = calc(entr.getKey(), dem, map, set);
                
                if(val != -1) return val * entr.getValue();
            }
        }
        return -1;
    }
    
    private Map<String, Map<String,Double>> constructMap(List<List<String>> eqs, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int idx = 0;
        for(List<String> ls : eqs) {
            
            map.putIfAbsent(ls.get(0), new HashMap<>());
            map.get(ls.get(0)).put(ls.get(1), values[idx]);
            
            map.putIfAbsent(ls.get(1), new HashMap<>());
            map.get(ls.get(1)).put(ls.get(0), (1.0 / values[idx++]));
        }
        return map;
    }
}
```