///////////////////////////////////////////////////////////////////////////////
// Title:            Grid
// Function:         Creates and uses Grid two-D int array
// Semester:         Fall 2018
//
// Author:           Julie Sojkowski
// Email:            jas7845@g.rit.edu



public class Grid {
   private int[][] grid;

   Grid(int dim)
   /**
    * constructor for grid class
    * creates a square grid of the dimension read from the file
    */
   {
       this.grid = new int[dim][dim];
   }

    public void setVal(int row, int col, int nextInt)
    /**
     * sets the value for the grid
     * row: row the value is to be set on
     * col: column value is to be set on
     * nextInt: value to be set at grid[row][col]
     */
    {
        grid[row][col] = nextInt;
    }

    public int getVal(int row, int col)
    /**
     * returns the value in the grid at row, col
     */
    {
        return grid[row][col];
    }
}