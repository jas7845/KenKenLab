///////////////////////////////////////////////////////////////////////////////
// Title:            KenKen
// Function:         Looks at a KenKen puzzle solution and checks if it is correct
// Semester:         Fall 2018
//
// Author:           Julie Sojkowski
// Email:            jas7845@g.rit.edu

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class KenKen {
    private ArrayList<Integer> incorrect = new ArrayList<Integer>();
    private ArrayList<Region> regions = new ArrayList<Region>();

    public KenKen(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        int dim = scan.nextInt();
        int num_regions = scan.nextInt();

        Grid grid = new Grid(dim);            // creates a new grid
        for(int row=0; row<dim; row++) {      //reads in the solutions and adds them to the grid
            for (int col = 0; col < dim; col++) {
                grid.setVal(row, col, scan.nextInt());
            }
        }

        for (int i = 0; i <num_regions; i++)  // creates each region based on the sign and adds it to the ArrayList regions
        {
            int target = scan.nextInt();
            String sign = scan.next();
            if (sign.equals("+")) {
                regions.add(new AddRegion(i, target));
            }
            if (sign.equals("-")) {
                regions.add(new SubtractRegion(i, target));
            }
            if (sign.equals("/")) {
                regions.add(new DivideRegion(i, target));
            }
            if (sign.equals("*")) {
                regions.add(new MultiplyRegion(i, target));
            }
        }
        for(int row=0; row<dim; row++)        //loops through grid and adds the values to regions ArrayList values
        {
            for(int col=0; col<dim; col++)
            {
                int it = grid.getVal(row,col);
                regions.get(scan.nextInt()).addValue(it);
            }
        }
        for (int i=0; i< regions.size(); i++) //calls regions toString and prints out each Region in ArrayList regions
        {
            String print = regions.get(i).toString();
            System.out.println(print);
        }
    }

    public void check()
    /**
     * checks all the regions to make sure they are valid
     * if they are not valid the region number is added to ArrayList incorrect
     */
    {
        for(int i=0; i< regions.size(); i++){
            boolean ver = regions.get(i).verify();
            if(!ver){
                Integer val = i;
                incorrect.add(val);
            }
        }
    }

    public ArrayList getIncorrectRegions()
    /**
     * An accessor for the incorrect regions that are computed by the check() method
     */
    {
        return incorrect;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        KenKen ken = new KenKen(args[0]);
        ken.check();
        ArrayList<Integer> val = ken.getIncorrectRegions();
        if (val.size()>0){
            String vals = "";
            for(int i= 0; i<val.size(); i++ ){
                vals = String.valueOf(val.get(i));
            }
            System.out.println("Puzzle is incorrect! Invalid Regions: " + vals);
        }
        else{
            System.out.println("Puzzle is correct!");
        }
    }
}
