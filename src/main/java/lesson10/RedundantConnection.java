package lesson10;

public class RedundantConnection {

    class DisjointSets {
        private int[] dj;

        public DisjointSets(int size) {
            dj = new int[size];
            for (int i = 0; i < size; i++) {
                dj[i] = i;
            }
        }

        public int find(int elem) {
            if (dj[elem] != elem) {
                dj[elem] = find(dj[elem]); // Atualiza o representante do conjunto
            }
            return dj[elem];
        }

        public void union(int elem1, int elem2) {
            dj[find(elem1)] = find(elem2); // Conecta os dois conjuntos
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSets ds = new DisjointSets(n + 1); // `n+1` porque os nós começam de 1, não 0.

        // Processar cada aresta
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // Se `u` e `v` já pertencem ao mesmo conjunto, a aresta é redundante
            if (ds.find(u) == ds.find(v)) {
                return edge;
            }
            // Caso contrário, una os conjuntos
            ds.union(u, v);
        }
        return null; // Não deve acontecer
    }
}
