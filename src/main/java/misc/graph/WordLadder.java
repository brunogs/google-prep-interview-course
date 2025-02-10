package misc.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {

    record Pair(String word, Map<String, Boolean> visited, Integer start){}

    public static void main(String[] args) {
        /*String start = "qa";
        String end = "sq";
        List<String> ladders = List.of(
                "si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        );*/
        String beginWord = "leet";
        String endWord = "code";
        List<String> ladders = List.of("lest","leet","lose","code","lode","robe","lost");

        int i = ladderLength(beginWord, endWord, ladders);
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Integer shorter = null;
        Deque<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();

        visited.add(beginWord);

        int distance = 1;
        while (!q.isEmpty()) { //leet
            int size = q.size();
            while (size > 0) {
                String current = q.poll();
                if(current.equals(endWord)) {
                    return distance;
                }
                for (String neigh : findNeighboors(current, wordList, visited)) {
                    q.offer(neigh);
                    visited.add(neigh);
                }
                size--;
            }
            distance++;
        }

        return 0;
    }

    private static List<String> findNeighboors(String current, List<String> words, Set<String> visited) {
        List<String> result = new ArrayList<>();
        for (String w : words) {
            if (visited.contains(w))
                continue;
            if (isAdjacent(current, w))
                result.add(w);
        }
        return result;
    }

    private static boolean isAdjacent(String word, String similar) {
        if (word.length() != similar.length())
            return false;
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != similar.charAt(i))
                diff++;
            if (diff > 1)
                return false;
        }
        return diff == 1;
    }
}
