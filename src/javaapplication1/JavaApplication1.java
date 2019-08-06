/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// EXACT METHOD | DYNAMIC PROGRAMMING

package javaapplication1;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author chery1111111111111111111111111111111111111111
 */
public class JavaApplication1 {
    private static long startTime = System.currentTimeMillis();
    
     static boolean findPartition (int arr[], int n) 
    { 
        int sum = 0, i, j;
  
        for (i = 0; i < n; i++) 
            sum += arr[i]; 
        
        System.out.println(sum);
        
        if (sum%2 != 0) //sum of partition is odd, return false
            return false; 
  
        boolean part[][] = new boolean[(sum/2)+1][n+1]; 
  
        for (i = 0; i <= n; i++) //top row is initialized as true
            part[0][i] = true; 
  
        for (i = 1; i <= sum/2; i++) //leftmost column is initialized to false, as they won't be able to make up the sum in any way
            part[i][0] = false; 

        for (i = 1; i <= sum/2; i++) 
        { 
            for (j = 1; j <= n; j++) 
            { 
                part[i][j] = part[i][j-1]; 
                if (i >= arr[j-1]) 
                    part[i][j] = part[i][j] || 
                                 part[i - arr[j-1]][j-1]; 
            } 
        }
        
//        // print true false table 
//        for (i = 0; i <= sum/2; i++) 
//        { 
//            for (j = 0; j <= n; j++) {
//                System.out.print(Boolean.valueOf(part[i][j])); 
//                System.out.printf(" ");
//            }
//            System.out.printf("\n"); 
//        }
  
        return part[sum/2][n]; 
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();

        int array[] = new int[100];
        int n = array.length;

        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(901);
        }
        
        System.out.println(Arrays.toString(array));
        
        if(findPartition(array, n) == true){
            System.out.println("Can be divided into two sums.");

        } else {
            System.out.println("Cannot be divided into two sums.");
        }
        
        long endTime = System.currentTimeMillis();
        float sec = (endTime - startTime); System.out.println(sec + " seconds");
    }
    
}
