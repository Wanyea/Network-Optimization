import java.util.*;
import java.io.*;

class assignment3 
{
    public static void main(String args[]) 
    {
        try 
        {
            // Read file.
            File dataFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 2/assignment2_data.txt");
            Scanner dataFileInput = new Scanner(dataFile);  
            Scanner sc = new Scanner(System.in);
            FileWriter writer = new FileWriter("assignment2_output.txt"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void PageRank(int[][] A, int dampingFactor,  int convergenceCriteria) 
    {

    }
}