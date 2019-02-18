public class KnightBoard{
  private int[][] board;
  /**@throws IllegalArgumentException when either parameter is <= 0.
    */
  // Initialize the board to the correct size and make them all 0's
  public KnightBoard(int rows,int cols){
    board=new int[rows][cols];
    for(int r=0;r<rows;r++)
    {
      for(int c=0;c<cols;c++)
      {
        board[r][c]=0;
      }
    }
  }
}
