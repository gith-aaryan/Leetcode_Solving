/** 
TC: O(nlogn) , SC: O(n)

If the next interval starts before it ends, the intervals overlap, so the code extends the end. Otherwise, it adds a separate interval. */

class Solution {

    // Associative array
    public int[][] merge(int[][] intervals) {

        if(intervals.length <= 1){          // zero or one intervals,return the input as-is.
            return intervals;

        }

        // sort by ascending order by starting point
        Arrays.sort(intervals , Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>(); // number of results may be smaller than the number of input intervals.

        int[] newIntervals = intervals[0]; // newInterval to the first interval
        result.add(newIntervals);        // adds the first intervals 

        for(int[] interval: intervals){
            
             // Overlap: extend the current interval if needed
            if(interval[0] <= newIntervals[1]){   // current interval starts before or at the end of newInterval

            newIntervals[1] = Math.max(newIntervals[1] , interval[1]);  // Math.max keeps whichever end point is larger.
            }
            else{
                 // No overlap: start a new interval
                newIntervals = interval;
                result.add(newIntervals);  // Adds that separate interval to the result list.

            }
            
    }

        return result.toArray(new int[result.size()][]);  // Converts the list of intervals into a two-dimensional array and returns it.
        
    }
}