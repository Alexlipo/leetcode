package lipo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class M_简化路径 {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if ("".equals(p) || ".".equals(p)) {
                continue;
            }
            if ("..".equals(p)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }
        return result.isEmpty() ? "/" : result.toString();
    }

}
