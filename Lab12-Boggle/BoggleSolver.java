import java.util.*;
import java.io.*;

public class BoggleSolver
{
    // Initializes the data structure using the given array of strings as the dictionaryionary.
    // (You can assume each word in the dictionaryionary contains only the uppercase letters A - Z.)
  HashSet<String> dictionary;
  int in = 0;
    public BoggleSolver(String dictionaryName)
    {
        try{
      Scanner s = new Scanner(new File(dictionaryName));
      dictionary = new HashSet<>();
      while(s.hasNextLine()) {
        dictionary.add(s.nextLine());
      }
    } catch(Exception ex) {
      System.out.println(dictionaryName);
    }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable object
    public Iterable<String> getAllValidWords(BoggleBoard board)
    {
        HashSet<String> answer = new HashSet<String>(); 
    for(int i = 0; i < board.rows(); ++i)
      for(int j = 0; j < board.cols(); ++j)
        sort("", 1 << (i * 4 + j), answer, i, j, board);
        return answer;
    }

  public void sort(String currentStr, int pos, HashSet<String> answer, int x, int y, BoggleBoard board) {
    currentStr += board.getLetter(x, y);
    if(board.getLetter(x, y) == 'Q') currentStr += 'U';
    if(dictionary.contains(currentStr)) answer.add(currentStr);
    int[] coordX = {-1, -1, 0, 1, 1, 1, 0, -1}, coordy = {0, 1, 1, 1, 0, -1, -1, -1};
    for(int i = 0; i < coordX.length; ++i) {
      int u = x + coordX[i], v = y + coordy[i];
      if(u >= 0 && u < board.rows() && v >= 0 && v < board.cols()) {
        int index = u * 4 + v;
        if((pos & (1 << index)) == 0) {
          sort(currentStr, pos | (1 << index), answer, u, v, board);
        }
      }
    }
  }
   

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A - Z.)
    public int scoreOf(String word)
    {
    int length = word.length();
         if(length < 3) return 0;
        if(length < 5) return 1;
    if(length == 5) return 2;
    if(length == 6) return 3;
    if(length == 7) return 5;
        return 11;
    }

   

}
