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

        //Run Dijkstra's algoritm on dataset where UCF PID is: 4867444.

        System.out.println(runDijkstras(matrix, 48, 86));
        System.out.println(runDijkstras(matrix, 86, 7));
        System.out.println(runDijkstras(matrix, 7, 4));
        System.out.println(runDijkstras(matrix, 4, 44));
        System.out.println(runDijkstras(matrix, 44, 44));

       
        // Close scanner 
        toyFileInput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
 
    public static int runDijkstras(ArrayList<List<Integer>> A, int start, int end) 
    {

        return -1;
    }
}