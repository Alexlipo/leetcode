package lipo.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class H_串联所有单词的子串 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        int wordCount = words.length;

        Map<String, Integer> need = new HashMap<>();
        for (String w : words) {
            need.put(w, need.getOrDefault(w, 0) + 1);
        }

        // 尝试所有对齐方式
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (need.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // 如果某个词超了，缩窗口
                    while (window.get(word) > need.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // 窗口大小正好
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // 遇到非法词，清空窗口
                    window.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }

}
