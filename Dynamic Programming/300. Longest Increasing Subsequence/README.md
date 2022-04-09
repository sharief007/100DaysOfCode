[300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 ```text
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 ```

 ```text
Input: nums = [0,1,0,3,2,3]
Output: 4
 ```

 ### Approach - 1 (DP)

 - Time Complexity: O(N^2)
 - Space Complexity: O(N)

 ```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i =1;i<n;i++) {
            int val = nums[i];
            int j =i-1, sub = Integer.MIN_VALUE;
            while(j >= 0) { // check for previous elements which are smaller
                if(val > nums[j]) {
                    sub = Math.max(sub, dp[j]); // find out longest subsequence till now
                }
                j--;
            }
            if(sub == Integer.MIN_VALUE){   // if there isn't any smaller element, nums[i] is smallest till now, so
                dp[i] = 1;
            } else {
                dp[i] = sub + 1;   // LIS till now plus one
            } 
        }
        // System.out.println(Arrays.toString(dp));
        for(int i : dp) {
            max = Math.max(max,i);  // dp array will have LIS till a particular index
        }
        return max;
    }
}
 ```

 ### Approach - 2 (Binary Search) stolen

[Youtube Explanation](https://www.youtube.com/watch?v=on2hvxBXJH4)

 - Time Complexity: O(N*LogN)
 - Space Complexity: O(N)

 ```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int len = 1;temp[0] = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>temp[len-1]){
                temp[len++] = nums[i]; 
            }else{
                int ind = solve(temp,0,len,nums[i]);
                temp[ind] = nums[i];
            }
        }
        return len;
    }
    public int solve(int[] temp , int i ,int j ,int tar){
        while(i<=j){
            int mid =(i+j)/2;
            if(temp[mid]<tar){
                i = mid+1;
            }else{
                j= mid-1;
            }
        }
        return i;
    }
}
 ```