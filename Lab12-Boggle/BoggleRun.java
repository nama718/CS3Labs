
/**
 * Write a description of class BoggleRun here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoggleRun
{
        public static void main(String[] args) {
        System.out.println("WORKING");
        new BoggleGame(4, 4);


        final String PATH   = "C:/Users/amanb/Documents/CS3-Labs/Lab12-Boggle/data";
        BoggleBoard  board  = new BoggleBoard(PATH + "/board4x4.txt");
        BoggleSolver solver = new BoggleSolver(PATH + "/dictionary-shakespeare.txt");

        int Sum = 0;

        for (String s : solver.getAllValidWords(board)) {
            System.out.println(s + ", points = " + solver.scoreOf(s));
            Sum += solver.scoreOf(s);
        }

        System.out.println("Score = " + Sum); //should print 84

    }
}
