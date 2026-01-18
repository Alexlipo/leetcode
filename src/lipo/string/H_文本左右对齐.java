package lipo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class H_文本左右对齐 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int len = words[i].length();
            int j = i + 1;
            // 1 贪心放单词
            while (j < words.length
                    && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j++].length();
            }

            int wordCount = j - i;
            StringBuilder sb = new StringBuilder();
            // 2️ 最后一行 or 只有一个单词 → 左对齐
            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }
            // 3 普通行 → 两端对齐
            else {
                int wordLen = 0;
                for (int k = i; k < j; k++) {
                    wordLen += words[k].length();
                }
                int spaces = maxWidth - wordLen;
                int gaps = wordCount - 1;
                int base = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spaceCount = base + (extra-- > 0 ? 1 : 0);
                        for (int l = 0; l < spaceCount; l++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }

}
