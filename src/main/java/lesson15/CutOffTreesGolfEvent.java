package lesson15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

record Item(int i, int j){}

public class CutOffTreesGolfEvent {

    public int cutOffTree(List<List<Integer>> forest) {
        List<Item> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new Item(i, j));
                }
            }
        }
        //sort
        trees.sort(Comparator.comparingInt(a -> forest.get(a.i()).get(a.j())));

        Item previous = new Item(0, 0);
        int steps = 0;

        for (var curr : trees) {
            int aux = bfs(forest, previous, curr);
            if (aux == -1) {
                return -1;
            }
            steps += aux;
            previous = curr;
        }
        return steps;
    }

    public int bfs(List<List<Integer>> forest, Item source, Item dst) {
        Deque<Item> q = new LinkedList<>();
        q.offer(source);
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];

        visited[source.i()][source.j()] = true;
        int cost = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                var curr = q.poll();
                if (curr.equals(dst)) {
                    return cost;
                }
                int[][] neighs = new int[][]{
                        {curr.i()+1, curr.j()},
                        {curr.i()-1, curr.j()},
                        {curr.i(), curr.j()-1},
                        {curr.i(), curr.j()+1}
                };
                for (var n : neighs) {
                    if (n[0] < 0 || n[0] >= forest.size()) continue;
                    if (n[1] < 0 || n[1] >= forest.get(0).size()) continue;
                    if (forest.get(n[0]).get(n[1]) == 0) continue;
                    if (visited[n[0]][n[1]]) continue;

                    visited[n[0]][n[1]] = true;
                    q.offer(new Item(n[0], n[1]));
                }
                size--;
            }
            cost++;
        }
        return -1;
    }
}
