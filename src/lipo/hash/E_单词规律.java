package lipo.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class E_单词规律 {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> c2w = new HashMap<>();
        Map<String, Character> w2c = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (c2w.containsKey(c)) {
                if (!word.equals(c2w.get(c))) {
                    return false;
                }
            } else {
                c2w.put(c, word);
            }

            if (w2c.containsKey(word)) {
                if (c != w2c.get(word)) {
                    return false;
                }
            } else {
                w2c.put(word, c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        E_单词规律 o = new E_单词规律();
        System.out.println(o.wordPattern("abba", "dog cat cat dog"));
    }

}
