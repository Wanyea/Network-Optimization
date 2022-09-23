import java.util.*;
import java.io.*;

public class assignment1 
{
    public static void main(String args[]) {

        // Try to read file, throw exception if not possible. 
        try {

            // Read file.
            File toyFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 1/input/Toy.txt");
            Scanner toyFileInput = new Scanner(toyFile);   
            
               
        // Declare/Initialize matrix and helpers.
        ArrayList<List<Integer>> matrix = new ArrayList<List<Integer>>();
        List<String> line = new ArrayList<String>();
        List<Integer> rows = new ArrayList<Integer>();
        int n = 7;

        //Populate n x n matrix. 
        for(int i = 0; i < n; i++) {
            
            while(toyFileInput.hasNext()) {
                line.add(toyFileInput.next());
                StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");
                for(int k = 0; tokenizer.hasMoreTokens(); k++) {
                    rows.add(Integer.parseInt(tokenizer.nextToken()));
                }

                matrix.add(rows);
                line = new ArrayList<>();
                rows = new ArrayList<>();
                
            }   

        }

        System.out.println(matrix);
       
        // Close scanner 
        toyFileInput.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
}