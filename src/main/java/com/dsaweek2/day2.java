package com.dsaweek2;

public class day2 {
    public static void main(String[] args) {
        // LC  : find minimum in rotated array
        int[] nums = {3, 4, 5, 6, 0, 1, 2};
        int result = findMinimum(nums);
        System.out.println(result);
    }
    public static  int findMinimum(int[] nums){
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid  = l + (r - l)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return nums[r];
    }

}
