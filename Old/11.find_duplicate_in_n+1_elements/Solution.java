public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,7,8,9};
        System.out.println(findDuplicate(arr));
    }

    private static int findDuplicate(int[] nums) {
        int n =nums.length;
        for(int i=0;i<n;i++) {
            nums[nums[i]%n] += n;
        }
        for(int i=0;i<n;i++) {
            if(nums[i]>=2*n) {
                return i;
            }
        }
        return -1;
    }
}
