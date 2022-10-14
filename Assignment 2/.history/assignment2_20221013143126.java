import java.util.*;
import java.io.*;

public class assignment2 
{
    public static void main(String args[]) 
    {
        // Try to read file, throw exception if not possible. 
        try 
        {

            // Read file.
            File dataFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 2/assignment2_data.txt");
            Scanner dataFileInput = new Scanner(dataFile);  
            Scanner sc = new Scanner(System.in);
            
            
            // Declare/Initialize matrix 'A' and helpers.
            int n = 100;
            int[][] matrix = new int[n][n];
            List<String> line = new ArrayList<String>();
            
            //Populate n x n matrix. 
            for(int i = 0; i < n; i++) {
                if(dataFileInput.hasNext()) {
                    line.add(dataFileInput.next());
                    StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");
                    for(int k = 0; tokenizer.hasMoreTokens(); k++) {
                        matrix[i][k] = Integer.parseInt(tokenizer.nextToken());
                    }
                }
                line = new ArrayList<>(); // Clear to prepare for next row in the matrix.   
            }

            // User input used as starting/ending vertex for Euler circuit (e.g PID: 4867444 --> Starting/Ending vertex": 44)
            int startVertex = sc.nextInt();
            Fleury(matrix, startVertex);


            // for (int i = 0; i < n; i++) 
            // {
            //     for (int j = 0; j < n; j++) 
            //     {
            //         System.out.print(matrix[i][j]);
            //     }

            //     System.out.print("\n");
            // }
        

            // Close scanners 
            dataFileInput.close();
            sc.close();

        // Handle I/O exceptions
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Fleury(int[][] A, int start) 
    {

    }
}