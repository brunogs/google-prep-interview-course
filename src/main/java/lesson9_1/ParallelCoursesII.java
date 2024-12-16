package lesson9_1;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class ParallelCoursesII {

    public int minNumberOfSemesters(int n, int[][] relations, int k) {

        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];

        for (var relation : relations) {
            inDegree[relation[1]]++;
            outDegree[relation[0]]++;
        }

        //Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(outDegree[b], outDegree[a]));

        for (int i = 1 ; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        //
        int semester = 0;

        while (!queue.isEmpty()) {

            semester++;// 1
            int maxCourses = k; // 1
            int coursesAvailable = queue.size(); // 2

            List<Integer> nextSemester = new ArrayList<>();

            System.out.println("Queue at start of semester " + semester + ": " + queue);

            while (maxCourses > 0 && coursesAvailable > 0) {
                int node = queue.poll(); // 13

                //System.out.println("semester " + semester + " cource = " + node);

                for (var relation : relations) {
                    if (relation[0] == node) {
                        inDegree[relation[1]]--;
                        outDegree[node]--;
                        if (inDegree[relation[1]] == 0) {
                            //queue.add(relation[1]);
                            nextSemester.add(relation[1]);
                        }
                    }
                }

                maxCourses--;
                coursesAvailable--;
            }

            queue.addAll(nextSemester);
        }

        return semester;
    }
}
