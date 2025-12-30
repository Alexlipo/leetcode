package lipo.heap;

import java.util.*;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        M_前K个高频元素 o = new M_前K个高频元素();
        System.out.println(Arrays.toString(o.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(o.topKFrequent(new int[]{1}, 1)));
    }
}
