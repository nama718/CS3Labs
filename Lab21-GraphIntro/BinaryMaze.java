import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryMaze {
    public static int[][] maze;

    public static void main(String[] args) {
        Scanner reader = null;
        File file = new File("maze.dat");

        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int rows = reader.nextInt();
        int cols = reader.nextInt();
        maze = new int[rows][cols];
        int cases = reader.nextInt();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maze[r][c] = reader.nextInt();
            }
        }

        for (int cs = 0; cs < cases; cs++) {
            int[][] backupMaze = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    backupMaze[r][c] = maze[r][c];
                }
            }

            boolean found = false;
            Node start = new Node(reader.nextInt(), reader.nextInt());
            Node end = new Node(reader.nextInt(), reader.nextInt());
            Queue<Node> tbVisited = new LinkedList<>();
            tbVisited.offer(start);

            int[] rowM = {-1, 1, 0, 0};
            int[] colM = {0, 0, 1, -1};
            int steps = 0;

            while(tbVisited.peek() != null) {
                if (found) {
                    break;
                }

                Node current = tbVisited.poll();

                if (current.equals(end)) {
                    System.out.println(steps);
                    found = true;
                    break;
                }

                for (int n = 0; n < rowM.length; n++) {
                    if (rowM[n] == 1 || rowM[n] == -1) {
                        if (colM[n] == 1 || colM[n] == -1) {
                            break;
                        }
                    }

                    int sRow = current.row + rowM[n];
                    int sCol = current.col + colM[n];

                    if (sRow < 0 || sCol < 0 || sRow >= maze.length || sCol >= maze[0].length || maze[sRow][sCol] == 0) {
                        continue;
                    }

                    if (end.row == sRow) {
                        if (end.col == sCol) {
                            System.out.println(steps + 1);
                            found = true;
                            break;
                        }
                    }

                    steps++;
                    maze[sRow][sCol] = 0;
                    Node next = new Node(sRow, sCol);
                    tbVisited.offer(next);
                }
            }
            
            if (!found) {
                System.out.println("-1");
            }
        }
    }

    public static class Node {
        public int row;
        public int col;

        public Node() {}

        public Node(int r, int c) {
            this.row = r;
            this.col = c;
        }

        public boolean equals(Node n) {
            if (this.row == n.row) {
                if (this.col == n.col) {
                    return true;
                }
            }
            return false;
        }
    }
}
