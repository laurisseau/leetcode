import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCodeFunctions {
    public int trap(int[] height) {
        /*
            Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
            Output: 6
         */
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int water = 0;

        for(int i = 0; i < n; i++){
            if(i == 0){
                leftMax[0] = height[0];
                rightMax[n - 1] = height[n - 1];
            }else{
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
                rightMax[n - i - 1] = Math.max(height[n - i - 1], rightMax[n - i]);
            }
        }

        for(int i = 0; i < n; i++){
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(j >= 0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    public int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i, needle.length() + i).equals(needle)){
                    return i;
                }
            }
        }

        return -1;
    }

    public int candy(int[] ratings) {

        int n = ratings.length;
        int candies = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }

        for(int i = 0; i < n; i++){
            candies = candies + Math.max(left[i], right[i]);
        }

        return candies;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[index - 2]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> group = new HashMap<>();

        for(String str: strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            if(!group.containsKey(sortedStr)){
                group.put(sortedStr, new ArrayList<>());
            }
            group.get(sortedStr).add(str);
        }

        return new ArrayList<>(group.values());
    }

    public char nonRepeatingCharacter(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++){

            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }else{
                map.put(str.charAt(i), 1);
            }

        }

        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                return str.charAt(i);
            }
        }

        return '_';
    }


}
