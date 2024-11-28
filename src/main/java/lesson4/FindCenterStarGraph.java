package lesson4;

import java.util.HashMap;
import java.util.Map;

public class FindCenterStarGraph {

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{4,2}};
        int result = findCenter(edges);
        System.out.println(result);
    }

    public static int findCenter(int[][] edges) {
        Map<Integer, Integer> nodeCounts = new HashMap<>();

        // Itera por todas as arestas e incrementa as conexões de cada nó
        for (int[] edge : edges) {
            nodeCounts.put(edge[0], nodeCounts.getOrDefault(edge[0], 0) + 1);
            nodeCounts.put(edge[1], nodeCounts.getOrDefault(edge[1], 0) + 1);
        }

        // O centro será o nó que aparece em todas as arestas (edges.length + 1)
        for (Map.Entry<Integer, Integer> entry : nodeCounts.entrySet()) {
            if (entry.getValue() == edges.length) {
                return entry.getKey();
            }
        }

        // Se nenhum centro for encontrado (o que não deve acontecer com entradas válidas)
        return -1;
    }
}
