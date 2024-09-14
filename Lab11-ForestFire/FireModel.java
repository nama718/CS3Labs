 

public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] f;
    private FireView myView;

    public FireModel(FireView view)
    {
        f = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                f[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(f);
    }

    /*
        recursiveFire method here
     */

    public void solve()
    {
        for(int j = 0; j < SIZE; ++j)
            if(f[SIZE-1][j].getStatus() == 1)
                f[SIZE-1][j].setStatus(2);
        for(int j = 0; j < SIZE; ++j) {
            if(f[SIZE-1][j].getStatus() == 2)
                if(floodfill(SIZE-1, j)) {
                    System.out.println("Onett is in trouble!");
                    return;
                }
        }
        myView.updateView(f);
        System.out.println("Onett is safe.");
    }

    public boolean floodfill(int i, int j) {
        f[i][j].setStatus(2);
        if(i == 0) return true;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        boolean bad = false;
        for(int k = 0; k < 4; ++k) {
            int ni = i + dx[k], nj = j + dy[k];
            if(ni >= 0 && ni < SIZE && nj >= 0 && nj < SIZE && f[ni][nj].getStatus() == 1)
                bad |= floodfill(ni, nj);
        }
        return bad;
    }
}