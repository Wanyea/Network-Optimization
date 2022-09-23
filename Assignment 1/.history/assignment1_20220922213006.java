import java.util.*;
import java.io.*;

public class assignment1 
{
    public static void main(String args[]) {
        try {
            File toyFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 1/input/Toy.txt");
            Scanner toyFileInput = new Scanner(toyFile);   
            
               // Create n x n  matrix
        
        ArrayList<List<Integer>> matrix = new ArrayList<List<Integer>>();
        List<String> line = new ArrayList<String>();

     
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
            while(toyFileInput.hasNext()) {
                line.add(toyFileInput.next());
                StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");
                for(int k = 0; tokenizer.hasMoreTokens(); k++) {
                    matrix[i][k] = Integer.parseInt(tokenizer.nextToken());
                }

                line.clear();
            }

            }
                
        }

        System.out.println(matrix);
       
        
        toyFileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
}