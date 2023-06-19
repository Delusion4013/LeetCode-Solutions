import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);    
        }
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
           public int compare(int[] m, int[] n) {
               return m[1] - n[1];
           } 
        });

        for (Map.Entry<Integer, Integer> entry: occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (pq.size() == k) {
                if (pq.peek()[1] < count) {
                    pq.poll();
                    pq.offer(new int[]{num, count});
                }
            } else {
                pq.offer(new int[]{num, count});
            }
        }

        int[] ret = new int[k];
        for (int i =0; i < k; i++) {
            ret[i] = pq.poll()[0];
        }
        return ret;
    }
}
// @lc code=end

