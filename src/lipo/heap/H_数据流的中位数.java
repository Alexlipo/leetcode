package lipo.heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/find-median-from-data-stream/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class H_数据流的中位数 {
    class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        public MedianFinder() {
            minHeap = new PriorityQueue<>((a,b) -> b - a);
            maxHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (minHeap.isEmpty() || num <= minHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            } else if (minHeap.size() < maxHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            return minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();
        }
    }
}
