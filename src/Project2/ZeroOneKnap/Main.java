package Project2.ZeroOneKnap;

import java.util.Scanner;

public class Main {
    public static void main(String[] Args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of items");
        int n = input.nextInt();

        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];

        System.out.println("Enter weight for " + n + " elements");
        for (int i = 1; i <= n; i++)
            weight[i] = input.nextInt();
        System.out.println("Enter value for " + n + " elements");
        for (int i = 1; i <= n; i++)
            value[i] = input.nextInt();

        System.out.println("Enter size of knapsack  ");
        int maxWeight = input.nextInt();

        solve(weight, value, maxWeight, n);
    }


    private static void solve(int[] weight, int[] value, int W, int N) {
        int NEGATIVE_INFINITY = Integer.MIN_VALUE;
        int[][] m = new int[N + 1][W + 1];
        int[][] sol = new int[N + 1][W + 1];
        int weightUsed = 0;
        int totalvalue = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                int m1 = m[i - 1][j];
                int m2 = NEGATIVE_INFINITY;
                if (j >= weight[i])
                    m2 = m[i - 1][j - weight[i]] + value[i];
                m[i][j] = Math.max(m1, m2);
                sol[i][j] = m2 > m1 ? 1 : 0;
            }
        }
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w] != 0) {
                selected[n] = 1;
                w = w - weight[n];
            } else
                selected[n] = 0;
        }
        for (int i = 1; i < N + 1; i++) {
            if (selected[i] == 1) {
                System.out.println("item " + i + " has been selected, with weight " + weight[i] + " and value " + value[i]);
                weightUsed += weight[i];
                totalvalue += value[i];
            }

        }
        System.out.println("Total value of items is " + totalvalue);
        System.out.println("Weight used is " + weightUsed);
    }
}


