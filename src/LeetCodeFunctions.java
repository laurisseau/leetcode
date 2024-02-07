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


}
