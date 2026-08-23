/** Main logic is:  Product sum except iteslt = Product Right * Product Left

                Product Except Self
                         │
                         ↓
             ┌─────────────────────┐
             │                     │
             ↓                     ↓
        LEFT PRODUCT          RIGHT PRODUCT
             │                     │
             └──────────┬──────────┘
                        ↓
                    MULTIPLY
                        ↓
                     ANSWER


    Time Complexity -> O(n). both first and Second loops are O(n)
    Space Complexity -> O(1) , The output array is required, and your algorithm uses only two extra variables:                

 */

class Solution {

    public int[] productExceptSelf(int[] nums) {   

        int n = nums.length;  // n = 4 

        int[] ans = new int[n]; // Initially Java gives integer arrays the default value 0. 

        int leftProd = 1;       // Product of all elements to the LEFT of the current index. ,, 1 acts as the neutral element for multiplication.

        int rightProd = 1;      // Product of all elements to the RIGHT of the current index.

        // from right to left , array index starts from 0 so (n-1), decreasing
        for(int i = n-1; i >= 0; i-- ){

            ans[i] = rightProd; // Put the product of everything to the RIGHT of i into ans[i].
            rightProd = rightProd * nums[i];
        
        }

        for(int i=0; i<n; i++){
            ans[i] = ans[i] * leftProd; // it already containes rightproduct , so only multiply it into leftproduct
            leftProd = leftProd * nums[i];  // update leftproduct

        }

        return ans;

        
    }
}

// algorithm also works beautifully with zero