package lipo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_O1时间插入删除和获取随机元素 {

    class RandomizedSet {

        private ArrayList<Integer> list;
        private Map<Integer, Integer> map;
        private Random random;
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int last = list.getLast();
            // 把最后一个元素移动到 idx 位置
            list.set(index, last);
            map.put(last, index);
            // 删除最后一个
            list.removeLast();
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

}
