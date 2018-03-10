package Project2.ZeroOneKnap;

import java.util.Scanner;

public class Main {
    public static void main(String[] Args) {
        //scanner for input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of items");
        int n = input.nextInt();
        //instantiates the weight and value arrays
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        //Gets values for weights
        System.out.println("Enter weight for " + n + " elements");
        for (int i = 1; i <= n; i++) {
            weight[i] = input.nextInt();
        }
        //gets values for the item value
        System.out.println("Enter value for " + n + " elements");
        for (int i = 1; i <= n; i++) {
            value[i] = input.nextInt();
        }
        //size of knapsack
        System.out.println("Enter size of knapsack  ");
        int maxWeight = input.nextInt();
        //calls the knap 
        solve(weight, value, maxWeight, n);
    }


    private static void solve(int[] weight, int[] value, int W, int N) {
        //instantiates m, which is used to get all the weights, solution is the final solution
        //The first index is weight, the second is number of items
        //Solution adds a one in indices that are the max value in each
        int[][] m = new int[N + 1][W + 1];
        int[][] solution = new int[N + 1][W + 1];
        int weightUsed = 0;
        int totalValue = 0;
        for (int i = 1; i <= N; i++) {
            //used to find the max weighting of each index of the 2d array m
            for (int j = 0; j <= W; j++) {
                int m1 = m[i - 1][j];
                int m2 = Integer.MIN_VALUE;
                //compares the input seeing if its larger than the previous entry
                if (j >= weight[i]) {
                    m2 = m[i - 1][j - weight[i]] + value[i];
                }
                //plugs either the current item into the matrix, or the new value if higher value
                m[i][j] = Math.max(m1, m2);
                //if the value increases it plugs in a 1
                solution[i][j] = m2 > m1 ? 1 : 0;
            }
        }
        //Gets the final answer by backtracking using solution and and the weight array
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (solution[n][w] != 0) {
                selected[n] = 1;
                w = w - weight[n];
            } else
                selected[n] = 0;
        }
        //outputs the weight of all the selected items, and tallies to get the max weight used and max value of the items
        for (int i = 1; i < N + 1; i++) {
            if (selected[i] == 1) {
                System.out.println("item " + i + " has been selected, with weight " + weight[i] + " and value " + value[i]);
                weightUsed += weight[i];
                totalValue += value[i];
            }

        }
        //outputs totals of the weight and value taken
        System.out.println("Total value of items is " + totalValue);
        System.out.println("Weight used is " + weightUsed);
    }
}


