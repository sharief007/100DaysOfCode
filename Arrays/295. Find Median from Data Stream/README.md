
[295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

```text
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
```

[Youtube Explanation](https://www.youtube.com/watch?v=1LkOrc-Le-Y)

### Approach - 1

Insertion :

1. For every new elements to be inserted, perform insertion sort.
2. insertion sort will take O(n) time complexity.
3. copying the array while changing sise will take O(n) time Complexity. so O(N+N) = O(N).

- Time Complexity for N data elements: O(n^2) 
- Time Complexity for Median: O(1)
- Space Complexity: O(N)

TLE (17/21 Test cases)
```java
class MedianFinder {

    private List<Integer> stream;
    private int size = 0;
    
    public MedianFinder() {
        stream = new ArrayList<>();
    }
    
    public void addNum(int num) {
        size++;
        stream.add(num);
        Collections.sort(stream);
    }
    
    public double findMedian() {
        if(size%2 == 0) {
            return (double)(stream.get(size/2) + stream.get(size/2 - 1))/2;
        } else {
            return stream.get(size/2);
        }
    }
}
```

### Approach - 2 (Using Heap)

- Time complexity for N elements: O(N * log N)
- Time Complexity for median: O(N/2 * logN) + O(N/2 * logN)
- Space Complexity: O(N)

```java

```


### Approach - 3 (Use MaxHeap & MinHeap)

- Time Complexity for inserting N elements: O(N * logN)
- Time Complexity for median: O(1)
- Space Complexity: O(N)

[Youtube Explanation](https://www.youtube.com/watch?v=1LkOrc-Le-Y)

```java
class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        max = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        min = new PriorityQueue<Integer>();
    }
    
    // think of a sorted array
    public void addNum(int num) {
        max.add(num);
        // if maxHeap has more than 1 elements than in minHeap
        if(max.size() - min.size() > 1){
            // then get the max element and add it to minHeap
            int top = max.poll();
            min.add(top);
        }
        
        if(min.size() > 0){
            // if this condition is true, then it is not a sorted array
            if(min.peek()<max.peek()){
                //interchange the values
                int a = min.poll();
                int b = max.poll();
                
                min.add(b);
                max.add(a);
            }
        }
    }
    
    public double findMedian() {
        // this means odd number of elements 
        if(max.size() > min.size()){
            return (double) max.peek();
        }else{  // even number of elements
            return  (double) ((max.peek()+min.peek()))/2;
        }
    }
}
```
