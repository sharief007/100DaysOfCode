
[973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)

### Approach - 1

- Time Complexity: O(Nlogn + N)
- Space Complexity: O(N)

```java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<Point> listOfPoints = new ArrayList<>();
        int[][] answer = new int[k][2];
        for(int[] p : points) {
            Point point = new Point(p,findDistanceFromOrigin(p));
            listOfPoints.add(point);
        }
        Collections.sort(listOfPoints, new Compare());
        for(int i=0;i<k;i++) {
            answer[i] = listOfPoints.get(i).cordinates;
        }
        return answer;
    }
    
    private double findDistanceFromOrigin(int[] point) {
        int x = point[0], y = point[1];
        return Math.sqrt((x*x)+(y*y));
    }
    
    private class Point  {
        final int[] cordinates;
        final double distance;
        Point(int[] cordinates, double distance) {
            this.cordinates = cordinates;
            this.distance = distance;
        }
    }
    
    private class Compare implements Comparator<Point> {
        public int compare(Point a,Point b) {
            return Double.compare(a.distance,b.distance);
        }
    }
}
```

Same Solution

```java
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}
```

### Approach -2

use multimap or treemap

- Time Complexity: O(Nlogn + K)
- Space Complexity: O(N)

```java
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        TreeMap<Long,List<int[]>> map = new TreeMap<>();
        List<int[]> ans = new LinkedList<>();
        
        // int[][] result = new int[k][2];
        
        for(int[] point: points) {
            long dis = getDistanceFromOrigin(point);
            if(map.containsKey(dis)) {
                List<int[]> list = map.get(dis);
                list.add(point);
                map.put(dis,list);
            } else {
                List<int[]> list = new LinkedList<>();
                list.add(point);
                map.put(dis, list);
            }
        }
        
        for(Map.Entry<Long,List<int[]>> entry: map.entrySet()) {
            for(int[] pt : entry.getValue()) {
                ans.add(pt);
                K--;
            }
            if(K==0) break;
        }
        
        return ans.toArray(new int[0][0]);
    }
    
    private long getDistanceFromOrigin(int[] point) {
        int x = point[0], y = point[1];
        return (x*x)+(y*y);
    }
    
}
```