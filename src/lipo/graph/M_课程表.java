package lipo.graph;

import java.util.*;

/**
 * https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class M_课程表 {

    public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
        // 入度数组，用于记录每门课程的入度
        int[] inDegree = new int[numCourses];
        // 邻接表，存储每门课程的后续课程
        List<List<Integer>> sufCourses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            sufCourses.add(new ArrayList<>());
        }
        // 计算每门课程的入度，并构建邻接表
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            sufCourses.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 存储入度为 0 的课程的队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 记录已完成课程的数量
        int count = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            count++;
            // 获取当前课程的后续课程列表
            for (Integer sufCourse : sufCourses.get(course)) {
                // 后续课程的入度减 1
                if (--inDegree[sufCourse] == 0) {
                    queue.offer(sufCourse);
                }
            }
        }
        return count == numCourses;
    }

    private final List<List<Integer>> edges = new ArrayList<>();
    private int[] visited;
    private boolean valid = true;
    public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (int suf : edges.get(i)) {
            if (visited[suf] == 0) {
                dfs(suf);
                if (!valid) {
                    return;
                }
            } else if (visited[suf] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }

    public static void main(String[] args) {
        M_课程表 o = new M_课程表();
        //System.out.println(o.canFinish(2, new int[][]{{1, 0},{0, 1}}));
        System.out.println(o.canFinish_bfs(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
    }
}
