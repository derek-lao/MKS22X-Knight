public class KnightBoard{
  private int[][] board;
  private int rows;
  private int cols;
  private int squares;
  /**@throws IllegalArgumentException when either parameter is <= 0.
    */
  // Initialize the board to the correct size and make them all 0's
  public KnightBoard(int rows,int cols){
    board=new int[rows][cols];
    for(int r=0; r<rows; r++)
    {
      for(int c=0; c<cols; c++)
      {
        board[r][c] = 0;
      }
    }
    this.rows = rows;
    this.cols = cols;
    squares = this.rows * this.cols;
  }

  private boolean addable(int row,int col){
    return board[row][col] == 0;
  }
  private boolean removeable(int row,int col){
    return !addable(row,col);
  }
  private boolean outOfBounds(int row,int col){
    return(row < 0 || row >= board.length || col < 0 || col >= board[0].length);
  }

  private boolean solveHelper(int label,int row,int col){
    if(label >= squares && !outOfBounds(row,col))
    {
      return true;
    }
    else
    {
      if(!outOfBounds(row,col) && addable(row,col))
      {
        board[row][col] = label;
        return
        solveHelper(label+1,row+2,col+1) ||
        solveHelper(label+1,row+2,col-1) ||
        solveHelper(label+1,row+1,col+2) ||
        solveHelper(label+1,row+1,col-2) ||
        solveHelper(label+1,row-2,col+1) ||
        solveHelper(label+1,row-2,col-1) ||
        solveHelper(label+1,row-1,col+2) ||
        solveHelper(label+1,row-1,col-1);
      }
    }
  }

  /** Modifies the board by labeling the moves from 1 (at startingRow,startingCol) up to the area of the board in proper knight move steps.
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
  @return true when the board is solvable from the specified starting position
  */
  public boolean solve(int startingRow,int startingCol){

  }

  /**
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
  or out of bounds.
  @return the number of solutions from the starting position specified
  */
  public int countSolutions(int startingRow, int startingCol){

  }
}
