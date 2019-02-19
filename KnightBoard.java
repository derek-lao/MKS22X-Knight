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
    this.rows = rows;
    this.cols = cols;
    squares = rows * cols;
    clear();
  }

  private int count;

  private boolean addable(int row,int col){
    return board[row][col] == 0;
  }
  private boolean removeable(int row,int col){
    return !addable(row,col);
  }
  private boolean outOfBounds(int row,int col){
    return(row < 0 || row >= board.length || col < 0 || col >= board[0].length);
  }
  private boolean illegalBoard(){
    for(int r = 0; r < rows; r++)
    {
      for(int c = 0; c < cols; c++)
      {
        if(board[r][c] != 0) return true;
      }
    }
    return false;
  }

  public void clear(){
    for(int r=0; r<rows; r++)
    {
      for(int c=0; c<cols; c++)
      {
        board[r][c] = 0;
      }
    }
  }

  private boolean solveHelper(int label,int row,int col){
    if(outOfBounds(row,col)) return false;
    else
    {
      // System.out.println("The label is: " + label);
      // System.out.println("The number of squares is: " + squares);
      System.out.println(this.toString());
      System.out.println("The label is " + label);
      if(label >= squares)
      {
        if(addable(row,col))
        {
          System.out.println("Successfully added knight at " + row + "," + col);
          return true;
        }
        System.out.println("Failed to add knight at " + row + "," + col);
        return false;
      }
      else
      {
        if(addable(row,col))
        {
          board[row][col] = label;
          System.out.println("Successfully added knight at " + row + "," + col);
          return
          solveHelper(label+1,row+2,col+1) ||
          solveHelper(label+1,row+2,col-1) ||
          solveHelper(label+1,row+1,col+2) ||
          solveHelper(label+1,row+1,col-2) ||
          solveHelper(label+1,row-2,col+1) ||
          solveHelper(label+1,row-2,col-1) ||
          solveHelper(label+1,row-1,col+2) ||
          solveHelper(label+1,row-1,col-2);
        }
        else
        {
          System.out.println("Failed to add knight at " + row + "," + col);
          board[row][col] = 0;
          return false;
        }
        // System.out.println("Failed to add knight at " + row + "," + col);
        // board[row][col] = 0;
        // return false;
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
    if(illegalBoard())
    {
      throw new IllegalStateException();
    }
    if(outOfBounds(startingRow,startingCol))
    {
      throw new IllegalArgumentException();
    }

    return solveHelper(1,startingRow,startingCol);
  }

  private void countHelper(int label,int row,int col){
    if(!outOfBounds(row,col))
    {
      if(label >= squares)
      {
        if(addable(row,col))
        {
          count++;
        }
        System.out.println("Failed to add knight at " + row + "," + col);
      }
      else
      {
        if(addable(row,col))
        {
          board[row][col] = label;
          countHelper(label+1,row+2,col+1);
          countHelper(label+1,row+2,col-1);
          countHelper(label+1,row+1,col+2);
          countHelper(label+1,row+1,col-2);
          countHelper(label+1,row-2,col+1);
          countHelper(label+1,row-2,col-1);
          countHelper(label+1,row-1,col+2);
          countHelper(label+1,row-1,col-1);
        }
        else
        {
          System.out.println("Failed to add knight at " + row + "," + col);
          board[row][col] = 0;
        }
        // System.out.println("Failed to add knight at " + row + "," + col);
        // board[row][col] = 0;
      }
    }
  }


  /**
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
  or out of bounds.
  @return the number of solutions from the starting position specified
  */
  public int countSolutions(int startingRow, int startingCol){
    if(illegalBoard())
    throw new IllegalStateException();

    if(outOfBounds(startingRow,startingCol))
    {
      throw new IllegalArgumentException();
    }

    count = 0;
    countHelper(1,startingRow,startingCol);
    return count;
  }

  public String toString(){
    String answer = "";
    for(int r=0; r<rows; r++)
    {
      for(int c=0; c<cols; c++)
      {
        int current = board[r][c];
        if(current == 0)
        answer += " " + "_" + " ";
        else if(current < 10)
        answer += " " + current + " ";

        else
        answer += current + " ";
      }
      answer += "\n";
    }
    return answer;
  }
}
