/** HashMap + Priority Queue/ Min Heap + Comparable + Top-K logic

we can also using bucket to solve this

1 million different numbers , So We don’t necessarily need to sort all 1 million elements.  This is where PriorityQueue becomes useful.

Priority Queue says:
“I don’t care who came first. I care about who has the highest/lowest priority.”
A Priority Queue can always give you the person with the highest/lowest priority depending on how it is configured.
Min-Heap - In Java, PriorityQueue by default : smallest element has the highest priority to come out first.

Heap -> ( Parent ≤ Children ):  smallest value is always at the top.

 */


class Solution {

    // “My Pair class knows how to compare one Pair with another Pair.”
    class Pair implements Comparable<Pair>{   // Compare the count.

        // Comparable: I am telling Java how objects of this class should compare themselves.

        int nums , count;  // number 1 appears 3 times 

        Pair(int nums , int count){
            this.nums = nums;
            this.count = count;
        }

        @Override  // Override method 
        public int compareTo(Pair B ){
           return this.count - B.count;

        }

    }
    public int[] topKFrequent(int[] nums, int k) {
        
        // we take needs key as number + frequency as value
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            // getOrDefault() needs key + default value
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>();  // “Create a PriorityQueue that stores Pair objects.”

        Set<Integer> keys = map.keySet();

        for(int key : keys){

            if(pq.size() < k){
                pq.add(new Pair(key , map.get(key)));

            }else if(pq.peek().count < map.get(key)){     // peek() -> the head of the queue/  highest-priority 

                pq.poll();  // poll() retrieve and remove the highest-priority 
                pq.add(new Pair(key , map.get(key)));


            }
        }

        int[] arr = new int[k];
        int i = k - 1; 

        while( i >= 0){
            arr[i--] = pq.poll().nums;

        }
        return arr ;

        





        
    }
}