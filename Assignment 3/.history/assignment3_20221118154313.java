import java.util.*;
import java.io.*;

class assignment3 
{
    public static void main(String args[]) 
    {
        try 
        {
            // Read file.
            File dataFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 3/A.txt");
            Scanner dataFileInput = new Scanner(dataFile);  
            Scanner sc = new Scanner(System.in);
            FileWriter writer = new FileWriter("assignment3_output.txt"); 

            // Declare/Initialize matrix 'A' and helpers.

            int n = 100;
            int[][] matrix = new int[n][n];
            List<String> line = new ArrayList<String>();
            
            //Populate n x n matrix. 
            for(int i = 0; i < n; i++) 
            {
                if(dataFileInput.hasNext()) 
                {
                    line.add(dataFileInput.next());
                    StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");

                    for(int k = 0; tokenizer.hasMoreTokens(); k++) 
                    {
                        matrix[i][k] = Integer.parseInt(tokenizer.nextToken());
                    }
                }

                line = new ArrayList<>(); // Clear to prepare for next row in the matrix.   

                PageRank(matrix, 1, 2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void PageRank(int[][] A, int dampingFactor,  int convergenceCriteria) 
    {

    }
}