import java.util.*;
import java.io.*;

public class assignment1 
{
    public static void main(String args[]) {
        try {
            File toyFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 1/input/Data.txt");
            Scanner toyFileInput = new Scanner(toyFile);   
            
               // Create n x n  matrix

        //ArrayList<List<Integer>> matrix = new ArrayList<List<Integer>>();
        int[][] matrix = new int[100][100];

        for(int i = 0; i < 99; i++) {
            for(int j = 0; j < 99; j++) {
                if(toyFileInput.hasNextInt())
                    matrix[i][j] = toyFileInput.nextInt();
                    System.out.print(matrix[i][j]);
            }
        }
       

        toyFileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
}