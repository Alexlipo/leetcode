package lipo.heap;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_数组中的第K个最大元素 {

    private Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;
        while (left <= right) {
            int p = partition(nums, left, right);
            if (p == target) {
                return nums[p];
            }
            if (p < target) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        int r = left + random.nextInt(right - left + 1);
        swap(nums, r, right);

        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    public int findKthLargest_bucket(int[] nums, int k) {
        int[] bucket = new int[20001];
        for (int n : nums) {
            bucket[n + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k -= bucket[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        M_数组中的第K个最大元素 o = new M_数组中的第K个最大元素();
        System.out.println(o.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(o.findKthLargest_heap(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

}
