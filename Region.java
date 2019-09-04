///////////////////////////////////////////////////////////////////////////////
// Title:            Region
// Function:         Abstract class to create regions of the KenKen puzzle
// Semester:         Fall 2018
//
// Author:           Julie Sojkowski
// Email:            jas7845@g.rit.edu
import java.util.*;


public abstract class Region {
    private int number;
    protected int target;
    protected ArrayList<Integer> values = new ArrayList();

    public Region (int num, int tar) //num is number of the region, tar is target of region
    {
        number =  num;
        target = tar;
    }

    public void addValue(int val)
    /**
     * val is the value to be added to the list
     * adds a value to ArrayList values
     */
    {
        Integer i = val;
        values.add(i);
    }

    public abstract boolean verify();
    /**
     * verifies if the region is true
     * returns: true if the region is correct and false if it is not
     */

    public String toString()
    /**
     * creates a string representation of Region
     */
    {
        String str = "Region: " + number + ", target: " + target + ", ";
        return str;
    }

}
