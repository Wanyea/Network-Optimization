import java.util.*;
import java.io.*;

class assignment3 
{
    public static void main(String args[]) 
    {
        try 
        {
            // Read file.
            File dataFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 3/A.txt");
            Scanner dataFileInput = new Scanner(dataFile);  
            Scanner sc = new Scanner(System.in);
            

            // Declare/Initialize matrix 'A' and helpers.

            int n = 100;
            int[][] matrix = new int[n][n];
            List<String> line = new ArrayList<String>();
            double epsilon = 1 * Math.pow(10, -5); // 1e^-5
            float dampingFactor =  (79.0f / 100.0f);

            //Populate n x n matrix. 
            for(int i = 0; i < n; i++) 
            {
                if(dataFileInput.hasNext()) 
                {
                    line.add(dataFileInput.next());
                    StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");

                    for(int k = 0; tokenizer.hasMoreTokens(); k++) 
                    {
                        matrix[i][k] = Integer.parseInt(tokenizer.nextToken());
                    }
                }

                line = new ArrayList<>(); // Clear to prepare for next row in the matrix.   

            }

            PageRank(matrix, dampingFactor, epsilon); // Make a call to the PagRank method with givenm 
                                                                          // damping factor & convergence criteria.

    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void PageRank(int[][] A, float dampingFactor,  double convergenceCriteria) 
    {
        float initialRank = (1.0f / 100.0f); // 1 / N, where N is 100 webpages.

        float[] webpageRank = new float[100]; // Stores rank for each webpage.

        // Initialize each webpage rank with 1 / N, where N is the number of webpages. 
        for (int i = 0; i < 100; i++) 
        {
            webpageRank[i] = initialRank;
        }

        updatePageRank(A, webpageRank, dampingFactor, convergenceCriteria);
    }

    // Updates the pagerank of each webpage. 
    public static void updatePageRank(int[][] A, float[] webpageRank, float dampingFactor, double convergenceCriteria) 
    {
        try 
        {

            boolean hasConverged = false;
            float oldPageRank;
            int numOfIterations = 0;
            double difference = 0.0f;
            int numOfUniqueLinks = 0;

            while (!hasConverged) 
            {
                for (int i = 0; i < 100; i++) 
                {
                    oldPageRank = webpageRank[i];

                    // Find number of distinct links at a given page.

                    for (int j = 0; j < 100; j++) 
                    {
                        if (A[i][j] == 1) 
                        {
                            numOfUniqueLinks++;
                        }

                    
                    }
                    
                    webpageRank[i] += decayEquation(webpageRank[i], numOfUniqueLinks, dampingFactor);
                    difference = ((double)oldPageRank - (double)webpageRank[i]);

                    numOfUniqueLinks = 0;

                    if (difference < convergenceCriteria) 
                    {
                        hasConverged = true;
                    } else {
                        numOfIterations++;
                    }

                    System.out.println(String.valueOf(difference) + ", Number of iterations: " + String.valueOf(numOfIterations));
                }

                HashMap<Integer, Float> positionRank = new HashMap<Integer, Float>();
                for (int i = 0; i < 99; i++) 
                {
                    positionRank.put(i, webpageRank[i]);
                }

                List<Map.Entry<Integer, Float>> output = new LinkedList<Map.Entry<Integer, Float>>(positionRank.entrySet());

                Collections.sort(output, new Comparator<Map.Entry<Integer, Float>>() 
                {
                    @Override
                    public int compare(Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2) 
                    {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });

                System.out.println(output);
            

                FileWriter writer = new FileWriter("assignment3_output.txt"); 
                writer.write("Number of iterations: " + String.valueOf(numOfIterations) + "\n");
                writer.write("ranking: ");

                for (int i = 0; i < 99; i++) 
                {
                    writer.write(output.get(i) + "(" + webpageRank[i] + "), ");
                }

                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }


    public static float decayEquation(float oldPageRank, int numUniqueLinks, float dampingFactor) 
    {
        if (numUniqueLinks == 0)
            return (dampingFactor * (oldPageRank / 100.0f)) + ((1.0f - dampingFactor) / 100.0f);


        return (dampingFactor * (oldPageRank / (float) numUniqueLinks)) + ((1.0f - dampingFactor) / 100.0f);

    }
}