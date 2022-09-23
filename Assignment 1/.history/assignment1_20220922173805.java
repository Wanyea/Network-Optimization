import java.util.*;
import java.io.*;

public class assignment1 
{
    public static void main(String args[]) {
        try {
            File toyFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 1/input/Data.txt");
            Scanner toyFileInput = new Scanner(toyFile);   
            
               // Create n x n  matrix

        ArrayList<List<Integer>> matrix = new ArrayList<List<Integer>>();
        List<Integer> line = new List<Integer>();

        for(int i = 0; i < 99; i++) {
            for(int j = 0; j < 99; j++) {
                    line.add(toyFileInput.nextInt());
            }

            matrix.add(line);
        }
       

        toyFileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
}