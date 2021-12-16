# NOTES
## Minimise maximum difference between heights

### Kadane's Algorithm
```java
static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int smallest = arr[0] + k, largest = arr[n-1]-k;
        for(int i = 0; i < n-1; i++){
            int min = Math.min(smallest, arr[i+1]-k);
            int max = Math.max(largest, arr[i]+k);
            if(min < 0) 
                continue;
            ans = Math.min(ans, max-min);
        }
        return ans;
    }
```

Time Complexity: O(n)
Space Complexity: O(1)

