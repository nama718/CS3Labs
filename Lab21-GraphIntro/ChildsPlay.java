import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ChildsPlay {
    static Scanner reader = null;

    private static class Graph {
        private HashMap<Integer, HashSet<Integer>> dominoMap = new HashMap<>();
        private HashSet<Integer> tippedSet = new HashSet<>();
        private int tippedDominos;

        public Graph() {

        }

        public void setTipped(int dom) {
            if (tippedSet.contains(dom)) {
                return;
            } else {
                tippedSet.add(dom);
                HashSet<Integer> adjacentDominos = dominoMap.get(dom);
                if (dominoMap.get(dom) != null) {
                    for (int domino : adjacentDominos) {
                        setTipped(domino);
                    }
                }
                tippedDominos = tippedSet.size();
            }
        }

        public void setTipLink(int domCause, int domEffect) {
            if (!dominoMap.containsKey(domCause)) {
                HashSet<Integer> tempSetCause = new HashSet<>();
                tempSetCause.add(domEffect);
                dominoMap.put(domCause, tempSetCause);
            } else {
                dominoMap.get(domCause).add(domEffect);
            }
        }

        public int getTipped() {
            return tippedDominos;
        }
    }

    public static void main(String[] args) {
        try {
            reader = new Scanner(new File("play.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int cases = reader.nextInt();

        for (int i = 0; i < cases; i++) {
            int dominosTotal = reader.nextInt();
            int knockLinks = reader.nextInt();
            int knocked = reader.nextInt();

            Graph graph = new Graph();
            for (int j = 0; j < knockLinks; j++) {
                int domCause = reader.nextInt();
                int domEffect = reader.nextInt();
                graph.setTipLink(domCause, domEffect);
            }

            for (int k = 0; k < knocked; k++) {
                int tippedDomino = reader.nextInt();
                graph.setTipped(tippedDomino);
            }
            System.out.println(graph.getTipped());
        }
    }
}
