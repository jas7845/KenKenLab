///////////////////////////////////////////////////////////////////////////////
// Title:            addRegion
// Function:         used for all the regions where to operator is additon extends Region
// Semester:         Fall 2018
//
// Author:           Julie Sojkowski
// Email:            jas7845@g.rit.edu


import java.util.*;
import java.util.Collections;


public class AddRegion extends Region{
    public AddRegion(int val, int tar)
    /**
     * Constructor for Add region, calls super class Region
     */
    {
        super(val,tar);
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
        int sum = 0;
        for(int i = val.size()-1; i>=0; i--){
            sum += val.get(i);
        }

        return sum==target;
    }


    public String toString()
    /**
     * creates and returns a string representation of Add Region
     * calls super class Region
     */
    {
        String str = super.toString();
        str += "values: ";
        for(int i =0; i<values.size(); i++){
            str+= values.get(i) + ", ";
        }
        str+= "op: +, verify: " + this.verify();
        return str;
    }


}
