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
        List<Integer> line = new ArrayList<Integer>();

        // for(int i = 0; i < 7; i++) {
        //     for(int j = 0; j < 7; j++) {
                    
        //     }
            
        //     System.out.println(line);
        //    // matrix.add(line);
        //     line.clear();
        // }
       
        while(toyFileInput.hasNext()) {
            if (!toyFileInput.hasNextInt()) {
                 toyFileInput.next();
                 continue;
            }
        
            System.out.println(scanFile.nextInt());

        toyFileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
}