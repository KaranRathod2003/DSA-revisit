package com.dsaweek2;

public class day2 {
    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        int n =  nums.length;
        int target = 4;

//        int result = findMinimum(nums);
            int result = searchArray(nums, target);
        System.out.println(result);
    }
    // LC 153 : find minimum in rotated array
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


    // LC 34 : FIND FIRST AND LAST POSITION OF ELEMENT IN SORTED ARRAY
    public static int[] searchPosition(int[] nums, int target){
        int n = nums.length;
        int leftPosition = leftMostPosition(nums, target, n);
        int rightPosition = rightMostPositon(nums, target, n);

        return new int[] {leftPosition, rightPosition};
    }
    public static int leftMostPosition(int[] nums, int target, int n){
        int leftMost = -1;
        int l = 0, r = n- 1;
        while(l <= r){
            int mid = l +(r - l)/2;
            if(nums[mid] == target){
                leftMost = mid;
                r = mid - 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return leftMost;
    }
    public static int rightMostPositon(int[] nums, int target, int n ){
        int rightMost = -1;
        int l = 0, r = n - 1;
        while( l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                rightMost = mid;
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return rightMost;
    }

    // LC 33 : SEARCH IN ROTATED ARRAY
    public static int searchArray(int[] nums, int target){
        int n = nums.length;
        int pivotElem = findPivot(nums, n);
        int idx = binarySearch(0, pivotElem, nums, target);
        if(idx != -1){
            return idx;
        }
        idx = binarySearch(pivotElem, n -1, nums, target);
        return idx;
    }
    public static int findPivot(int[] nums, int n){
        int l = 0, r = n - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return r;
    }
    public static int binarySearch(int l, int r, int[] nums, int target){
        int idx = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                idx = mid;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return idx;
    }
}
