package lipo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_电话号码的字母组合 {

    String[] charArray = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int i, StringBuilder s, List<String> list) {
        if (i == digits.length()) {
            list.add(s.toString());
            return;
        }
        int index = Integer.parseInt(String.valueOf(digits.charAt(i)));
        for (char c : charArray[index - 2].toCharArray()) {
            s.append(c);
            backtrack(digits, i + 1, s, list);
            s.deleteCharAt(i);
        }
    }

}
