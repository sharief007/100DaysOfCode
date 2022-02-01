[15. 3Sum](https://leetcode.com/problems/3sum/)


Find triplets in an array whose sum is equal to a given number.

1. Triplets should be unique.

### Approach -1
Time complexity : O(n^2)
Space complexity: O(1)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(i==0 || nums[i] != nums[i-1]) {
                findTriplets(i, nums, n, list);
            }
        }
        return list;
    }
    
    private void findTriplets(int i, int[] nums, int n, List<List<Integer>> list) {
        int low = i+1, high = n-1;
        while(low < high) {
            int sum = nums[low] + nums[high] + nums[i];
            if(sum > 0) {
                high--;
            } else if(sum <0) {
                low++;
            } else {
                list.add(List.of(nums[low],nums[high],nums[i]));
                low++;
                while(low<high && nums[low] == nums[low-1]) {
                    low++;
                }
            }
        }
    }
}
```


---------------------

### 3Sum

Find triplets in an array whose sum is equal to a given number.

### Approach -1 

Time complexity: O(n^2)
Space complexity: O(n)

1. Traverse the array from start to end. (loop counter i)
2. Create a HashMap or set to store unique pairs.
3. Run another loop from i+1 to end of the array. (loop counter j)
4. If there is an element in the set which is equal to x- arr[i] – arr[j], then print the triplet (arr[i], arr[j], x-arr[i]-arr[j]) and break
5. Insert the jth element in the set.


This solution will result non unique triplets as well

``` java
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new LinkedList<>();
        for(int i =0;i<n-2;i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j = i+1;j<n;j++) {
                int remainder = 0 - (nums[i] + nums[j]);
                if(set.contains(remainder)) {
                    list.add(Arrays.asList(nums[i], nums[j], remainder));
                }
                set.add(nums[j]);
            }
        }
        return list;
    }
}
```

### Approach -2
1. Sort the given array.
2. Loop over the array and fix the first element of the possible triplet, arr[i].
3. Then fix two pointers, one at i + 1 and the other at n – 1. And look at the sum, 
4. If the sum is smaller than the required sum, increment the first pointer.
5. Else, If the sum is bigger, Decrease the end pointer to reduce the sum.
6. Else, if the sum of elements at two-pointer is equal to given sum then print the triplet and break.


```java
public class Solution {
    boolean find3Numbers(int A[], int arr_size, int sum)
    {
        int l, r;
        /* Sort the elements */
        quickSort(A);
        /* Now fix the first element one by one and find the
           other two elements */
        for (int i = 0; i < arr_size - 2; i++) {
 
            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            l = i + 1; // index of the first element in the remaining elements
            r = arr_size - 1; // index of the last element
            while (l < r) {
                if (A[i] + A[l] + A[r] == sum) {
                    System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
                    return true;
                }
                else if (A[i] + A[l] + A[r] < sum)
                    l++;
 
                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }
        // If we reach here, then no triplet was found
        return false;
    }
}
```