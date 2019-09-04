///////////////////////////////////////////////////////////////////////////////
// Title:            divideRegions
// Function:         used for all the regions where to operator is division extends Region
// Semester:         Fall 2018
//
// Author:           Julie Sojkowski
// Email:            jas7845@g.rit.edu

import java.util.*;
import java.util.Collections;


public class DivideRegion extends Region
{

    public DivideRegion(int tar, int val)
    /**
     * Constructor for Divide region, calls super class Region
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
        int sum = 0;
        Collections.sort(val);
        int max = Collections.max(val);
        for(int i = 0; i< val.size()-1; i++){
            sum = max/val.get(i);
        }
        return sum == target;
    }

    public String toString()
    /**
     * creates and returns a string representation of Divide Region
     * calls super class Region
     */
    {
        String str = super.toString();
        str += "values: ";
        for(int i =0; i<values.size(); i++){
            str+= values.get(i) + ", ";
        }
        str+= "op: /, verify: " + this.verify();
        return str;
    }
}
