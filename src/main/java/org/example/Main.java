package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Two sum
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSumOptimal(nums, target);
//        System.out.println(result[0] + ", " + result[1]);
        String s = "race a car";
        boolean isValid = validPalindrome(s);
//        System.out.println(isValid);
        int[] prices = {7, 6, 4, 3, 1};
//        System.out.println(bestTimeToBuyStocks(prices));
char[] sc = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(sc);
reverserString(sc);
        System.out.println(sc);
    }
    // Two sum
    public static int[] twoSumBruteForce(int[] nums, int target){
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }


        return new int[]{-1, -1};
    }
    public static int[] twoSumOptimal(int[]nums, int target){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // Valid Palindrome
    public static boolean validPalindrome(String s){
        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right){
            if(cleaned.charAt(left) != cleaned.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int bestTimeToBuyStocks(int[] prices){
        int minPrice = prices[0];
        int n = prices.length;
        int maxProfit = 0;
        for(int i = 1; i <= n - 1; i++){
            minPrice = Math.min(prices[i], minPrice);
            int currentProfit = prices[i] - minPrice;
            maxProfit = Math.max(currentProfit, maxProfit);
        }
        return maxProfit;
    }

    public static void reverserString(char[] s){
        int left = 0;
        int right = s.length - 1;
        while (left < right){
            swapArrayElems(s,left, right);
            left++;
            right--;
        }
    }
    public static void swapArrayElems(char[] s, int left, int right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}