import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        int ans = 0;
        int first = -1;
        int second = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            int count = 0;

            if (first >= start && first <= end) {
                count++;
            }
            if (second >= start && second <= end) {
                count++;
            }

            if (count == 2) {
                continue;
            } 
            else if (count == 1) {
                first = second;
                second = end;
                ans++;
            } 
            else {
                first = end - 1;
                second = end;
                ans += 2;
            }
        }

        return ans;
    }
}
