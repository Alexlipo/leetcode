package lipo.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_最小栈 {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class MinStack_Diff {
        Deque<Long> stack;
        long min;
        public MinStack_Diff() {
            stack = new LinkedList<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(0L);
                min = val;
            } else {
                long diff = val - min;
                stack.push(diff);
                if (diff < 0) {
                    min = val;
                }
            }
        }

        public void pop() {
            long diff = stack.pop();
            if (diff < 0) {
                min = min - diff;
            }
        }

        public int top() {
            long diff = stack.peek();
            return diff >= 0 ? (int)(min + diff) : (int)min;
        }

        public int getMin() {
            return (int)min;
        }
    }
}
