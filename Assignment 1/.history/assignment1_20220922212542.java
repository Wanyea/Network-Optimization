import java.util.*;
import java.io.*;

public class assignment1 
{
    public static void main(String args[]) {
        try {
            File toyFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 1/input/Toy.txt");
            Scanner toyFileInput = new Scanner(toyFile);   
            
               // Create n x n  matrix
        
        int[][] matrix = new matrix[7][7];
        List<String> line = new ArrayList<String>();

     
        for(int i = 0; i < 7; i++) {
            while(toyFileInput.hasNext()) {
                line.add(toyFileInput.next());
                StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");
                for(int j = 0; tokenizer.hasMoreTokens(); i++) {
                    System.out.println(tokenizer.nextToken());
                }
                line.clear();
            }
                
        }
       
        
        toyFileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
}