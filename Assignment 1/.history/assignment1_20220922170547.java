import java.util.*;
import java.io.*;

public class assignment1 
{
    public static void main(String args[]) {
        try {
            File toyFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 1/input");
            Scanner toyFileInput = new Scanner(toyFile);   
            while (toyFileInput.hasNextLine())
                System.out.println(toyFileInput.nextLine());

            toyFileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // Create n x n  matrix

        //ArrayList<List<Integer>> matrix = new ArrayList<List<Integer>>();
        int[][] matrix = new int[99][99];

        for(int i = 0; i < 99; i++) {
            for(int j = 0; j < 99; j++) {
                while(toyFileInput.hasNextLine())
                matrix[i][j] = toyFileInput.nextLine();
            }
        }
       
    }
}