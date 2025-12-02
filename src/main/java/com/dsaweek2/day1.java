package com.dsaweek2;

public class day1 {
    public static void main(String[] args) {

        int[] arr = {-1,0,3,5,9,12};
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        int m = matrix.length;
        int n = matrix[0].length;
        int mid = 6 + 5 / 2;
//        System.out.println(mid);

        System.out.println("row : " + 9 / n + " col : " + 9 % n);
//        int n = arr.length - 1;
        int target = 20;
//        System.out.println("answer : " + searchA2DMatrix(matrix, target));
    }
    // LC : 704 easy [Binary search]
    // approach One  : Iterative
    public static int binarysearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public static int recursieBinarySearch(int[] nums, int l, int r, int target){
        if(l > r) return -1;
        int mid = l + (r -l)/2;
        if(nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return recursieBinarySearch(nums, mid + 1, r, target);
        }else {
            return recursieBinarySearch(nums, l, mid - 1, target);
        }
//        return mid;
    }


    // LC : 74 MEDIUM [Search in 2D matrix]
    public static boolean searchA2DMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] > target){
                end = mid - 1;
            } else if (matrix[row][col] < target) {
                start = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
