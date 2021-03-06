import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {
    
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a,b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a,b) -> (a - b));

    }
    
    public void addNum(int num) {
        if (queMin.isEmpty() || queMin.peek() >= num) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMin.size() < queMax.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }
    
    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        } else {
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

