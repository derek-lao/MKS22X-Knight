public class KnightBoard{
  private int[][] board;
  private int rows;
  private int cols;
  private int squares;
  /**@throws IllegalArgumentException when either parameter is <= 0.
    */
  // Initialize the board to the correct size and make them all 0's
  public KnightBoard(int rows,int cols){
    board = new int[rows][cols];
    solveCoordinates = new int[rows][cols];
    this.rows = rows;
    this.cols = cols;
    squares = rows * cols;
    clearOriginal();
  }

  private int count;
  private int[][] solveCoordinates;
  private int[] first =  {1, 2, 2, 1,-1,-2,-2,-1};
  private int[] second = {2, 1,-1,-2, 2, 1,-1,-2};

  private boolean isZero(int row,int col){
    return board[row][col] == 0;
  }
  private boolean removeable(int row,int col){
    return !isZero(row,col);
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
  private boolean isEmpty(){
    for(int r = 0; r < rows; r++)
    {
      for(int c = 0; c < cols; c++)
      {
        if(board[r][c] != 0) return false;
      }
    }
    return true;
  }

  public void clearOriginal(){
    for(int r=0; r<rows; r++)
    {
      for(int c=0; c<cols; c++)
      {
        board[r][c] = 0;
        solveCoordinates[r][c] = 0;
      }
    }
  }

  public void clearOptimized(){
    optimizedFill();
    for(int r=0; r<rows; r++)
    {
      for(int c=0; c<cols; c++)
      {
        solveCoordinates[r][c] = 0;
      }
    }
  }

  public void optimizedFill(){
    for(int r = 0; r < rows; r++)
    {
      for(int c = 0; c < cols; c++)
      {
        for(int a = 0; a < first.length; a++)
        {
          if(!outOfBounds(r + first[a],c + second[a]))
          board[r][c]++;
        }
      }
    }
  }


  // private boolean solveHelper(int label,int row,int col){
  //     if(outOfBounds(row,col)) return false;
  //     else
  //     {
  //       // System.out.println("The label is " + label);
  //       if(label >= squares)
  //       {
  //         if(isZero(row,col))
  //         {
  //           board[row][col] = label;
  //           // System.out.println("Successfully added knight at " + row + "," + col);
  //           // System.out.println(this.toString());
  //           return true;
  //         }
  //         // System.out.println("Failed to add knight at " + row + "," + col);
  //         // System.out.println(this.toString());
  //         return false;
  //       }
  //       else
  //       {
  //         if(isZero(row,col))
  //         {
  //           board[row][col] = label;
  //           // System.out.println("Successfully added knight at " + row + "," + col);
  //           // System.out.println(this.toString());
  //
  //           // loop to try all directions
  //           for(int a = -2; a < 3; a++)
  //           {
  //             for(int b = -2; b < 3; b++)
  //             {
  //               if(Math.abs(a) != Math.abs(b) && a != 0 && b != 0)
  //               {
  //                 if(solveHelper(label + 1,row + a,col + b))
  //                 {
  //                   return true;
  //                 }
  //               }
  //             }
  //           }
  //
  //           // // hardcode to try all hardcode
  //           // if
  //           // (solveHelper(label + 1,row + 1,col + 2) ||
  //           // solveHelper(label + 1,row + 2,col + 1) ||
  //           // solveHelper(label + 1,row + 2,col - 1) ||
  //           // solveHelper(label + 1,row + 1,col - 2) ||
  //           // solveHelper(label + 1,row - 1,col + 2) ||
  //           // solveHelper(label + 1,row - 2,col + 1) ||
  //           // solveHelper(label + 1,row - 2,col - 1) ||
  //           // solveHelper(label + 1,row - 1,col - 2)
  //           // )
  //           // {
  //           //   return true;
  //           // }
  //
  //           // // EXTREME hardcode to try all hardcode
  //           // if(solveHelper(label + 1,row + 1,col + 2)) return true;
  //           // if(solveHelper(label + 1,row + 2,col + 1)) return true;
  //           // if(solveHelper(label + 1,row + 2,col - 1)) return true;
  //           // if(solveHelper(label + 1,row + 1,col - 2)) return true;
  //           // if(solveHelper(label + 1,row - 1,col + 2)) return true;
  //           // if(solveHelper(label + 1,row - 2,col + 1)) return true;
  //           // if(solveHelper(label + 1,row - 2,col - 1)) return true;
  //           // if(solveHelper(label + 1,row - 1,col - 2)) return true;
  //
  //           // // loop to loop through directions to try
  //           // for(int a = 0;a < first.length; a++)
  //           // {
  //           //   int newRow = row + first[a];
  //           //   int newCol = col + second[a];
  //           //   if(solveHelper(label + 1,newRow,newCol))
  //           //   {
  //           //     return true;
  //           //   }
  //           // }
  //
  //           // // loop to activate solveHelper only in the directions where I can add.
  //           // for(int a = 0;a < first.length; a++)
  //           // {
  //           //   int newRow = row + first[a];
  //           //   int newCol = col + second[a];
  //           //   if(!outOfBounds(newRow,newCol) && isZero(newRow,newCol))
  //           //   {
  //           //     if(solveHelper(label + 1,newRow,newCol))
  //           //     {
  //           //       return true;
  //           //     }
  //           //   }
  //           // }
  //
  //           // if the loop fails
  //           board[row][col] = 0;
  //           // System.out.println("Backtracking one step");
  //           // System.out.println(this.toString());
  //           return false;
  //         }
  //         // System.out.println("Failed to add knight because already occupied at " + row + "," + col);
  //         // System.out.println(this.toString());
  //         return false;
  //       }
  //     }
  //   }

  private boolean solveHelper(int label,int row,int col){
    if(outOfBounds(row,col)) return false;
    else
    {
      System.out.println("The label is " + label);
      System.out.println("The board is currently");
      System.out.println(this.toString());
      if(label > squares)
      {
        if(this.isEmpty())
        {
          System.out.println("The board is empty!");
          System.out.println(this.toString());
          return true;
        }
        System.out.println("The board is not empty!");
        System.out.println(this.toString());
        return false;
      }
      else
      {

        if(!isZero(row,col))
        {
          solveCoordinates[row][col] = label;
          int prev = board[row][col];
          board[row][col] = 0;
          System.out.println("Successfully added knight at " + row + "," + col);
          System.out.println(this.toString());
          // loop to loop through all directions
          for(int a = -2; a < 3; a++)
          {
            for(int b = -2; b < 3; b++)
            {
              if(Math.abs(a) != Math.abs(b) && a != 0 && b != 0)
              {
                if(!outOfBounds(row + a,col + b) && board[row + a][col + b] == 1)
                {
                  if(solveCoordinates[row + a][col + b] == 0)
                  {
                    solveCoordinates[row][col] = 0;
                    board[row][col] = prev;
                    System.out.println("No possible moves to lead to " + (row + a) + "," + (col + a) + " and it has not been occupied");
                    System.out.println("Backtracking one step");
                    System.out.println(this.toString());
                    return false;
                  }
                }
              }
            }
          }

          for(int a = -2; a < 3; a++)
          {
            for(int b = -2; b < 3; b++)
            {
              if(Math.abs(a) != Math.abs(b) && a != 0 && b != 0)
              {
                if(!outOfBounds(row + a,col + b) && board[row + a][col + b] != 0)
                {
                  board[row + a][col + b]--;
                }
              }
            }
          }

          System.out.println("Decreased surrounding squares");
          System.out.println(this.toString());

          for(int a = -2; a < 3; a++)
          {
            for(int b = -2; b < 3; b++)
            {
              if(Math.abs(a) != Math.abs(b) && a != 0 && b != 0)
              {
                if(solveHelper(label + 1,row + a,col + b))
                {
                  return true;
                }
              }
            }
          }
          solveCoordinates[row][col] = 0;
          board[row][col] = prev;
          System.out.println("Backtracking one step");
          System.out.println(this.toString());
          return false;
        }
        System.out.println("Failed to add knight because already occupied at " + row + "," + col);
        System.out.println(this.toString());
        return false;
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
    // clearOptimized();
    // clearOriginal();
    optimizedFill();
    if(solveHelper(1,startingRow,startingCol))
    {
      for(int r = 0; r < rows; r++)
      {
        for(int c = 0;c < cols; c++)
        {
          board[r][c] = solveCoordinates[r][c];
        }
      }
      return true;
    }
    else
    {
      clearOriginal();
      return false;
    }
  }

  private void countHelper(int label,int row,int col){
    if(!outOfBounds(row,col))
    {
      // System.out.println("The label is " + label);
      if(label >= squares)
      {
        if(isZero(row,col))
        {
          board[row][col] = label;
          // System.out.println("Successfully added knight at " + row + "," + col);
          // System.out.println(this.toString());
          count++;
          // System.out.println("The count is " + count);
          board[row][col] = 0;
        }
      }
      else
      {
        if(isZero(row,col))
        {
          board[row][col] = label;
          // System.out.println("Successfully added knight at " + row + "," + col);
          // System.out.println(this.toString());
          // // loop coding for code efficiency
          // for(int a = -2; a < 3; a++)
          // {
          //   for(int b = -2; b < 3; b++)
          //   {
          //     if(Math.abs(a) != Math.abs(b) && a != 0 && b != 0)
          //     {
          //       countHelper(label+1,row+a,col+b);
          //     }
          //   }
          // }
          // hardcoding for runtime efficiency
          countHelper(label+1,row+2,col+1);
          countHelper(label+1,row+2,col-1);
          countHelper(label+1,row+1,col+2);
          countHelper(label+1,row+1,col-2);
          countHelper(label+1,row-2,col+1);
          countHelper(label+1,row-2,col-1);
          countHelper(label+1,row-1,col+2);
          countHelper(label+1,row-1,col-2);
          board[row][col] = 0;
          // System.out.println("Backtracking one step");
          // System.out.println(this.toString());
        }
        // System.out.println("Failed to add knight because already occupied at " + row + "," + col);
        // System.out.println(this.toString());
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
