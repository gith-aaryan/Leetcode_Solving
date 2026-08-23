/** Main logic is:  Product sum except iteslt = Product Right * Product Left






 */


class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] sum = new int[n];
        int leftProd = 1;
        int rightProd = 1;

        for(int i = n-1; i >= 0; i-- ){
            sum[i] = rightProd;
            rightProd = rightProd * nums[i];
        
        }

        for(int i=0; i<n; i++){
            sum[i] = sum[i] * leftProd;
            leftProd = leftProd * nums[i];

        }

        return sum;

        
    }
}