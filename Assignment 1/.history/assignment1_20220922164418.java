import java.util.*;
import java.io.*;

public class assignment1 
{
    public static void main(String args[]) {
        try {
            FileOutputStream toyFile = new FileOutputStream("C:/Users/wanye/source/Network-Optimization/Assignment 1/input");
            Scanner toyFileInput = new Scanner(toyFile);   
            while (toyFileInput.hasNextLine())
                System.out.println(toyFileInput.nextLine());

            toyFileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // Create n x n  matrix

        ArrayList<List<Integer>> matrix = new ArrayList<List<Integer>>();

       
    }
}