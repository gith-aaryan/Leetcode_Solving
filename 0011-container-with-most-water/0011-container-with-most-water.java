class Solution {
    public int maxArea(int[] height) {
        
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right ){

            int minheight = Math.min(height[left] , height[right]);
            int width = right - left;

            int currentWater = width * minheight;

            maxWater = Math.max(maxWater , currentWater) ;

           int pointerSliding = (height[left] < height[right]) ? left++ : right-- ;

        }

        return maxWater;

        
        
    }
}