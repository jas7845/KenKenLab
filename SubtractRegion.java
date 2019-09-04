///////////////////////////////////////////////////////////////////////////////
// Title:            subtractRegion
// Function:         used for all the regions where to operator is subtraction extends Region
// Semester:         Fall 2018
//
// Author:           Julie Sojkowski
// Email:            jas7845@g.rit.edu


import java.util.*;
import java.util.Collections;


public class SubtractRegion extends Region
{
    public SubtractRegion(int tar, int val)
    /**
     * Constructor for Subtract region, calls super class Region
     */
    {
        super(tar, val);
    }

    public boolean verify()
    /**
     * verifies if the region is true
     * returns: true if the region is correct and false if it is not
     */
    {
        ArrayList<Integer> val = super.values;
        Collections.sort(val);
        int max = Collections.max(val);
        for(int i = 0; i< val.size()-1; i++){
            max -= val.get(i);
        }
        return max == target;
    }

    public String toString()
    /**
     * creates and returns a string representation of Subtract Region
     * calls super class Region
     */
    {
        String str = super.toString();
        str += "values: ";
        for(int i =0; i<values.size(); i++){
            str+= values.get(i) + ", ";
        }
        str+= "op: -, verify: " + this.verify();
        return str;
    }

}
