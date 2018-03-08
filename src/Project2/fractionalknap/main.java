package Project2.fractionalknap;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        int capacity;
        int numberOfItems;
        int weight;
        int cost;
        int[][] items;

        System.out.println("What weight capacity would you like the knapsack to be? ");
        Scanner scanner = new Scanner(System.in);
        capacity = scanner.nextInt();

        System.out.println("How many items would you like to use? ");
        numberOfItems = scanner.nextInt();

        items = new int[2][numberOfItems];
        System.out.println("Enter the weights of each item: ");
        for(int i = 1; i < numberOfItems; i++){
            items[0][i] = scanner.nextInt();
        }

        System.out.println("Enter the cost of each item: ");
        for(int i = 1; i < numberOfItems; i++){
            items[1][i] = scanner.nextInt();
        }
        while(true){

        }
        //change here merge
    }

}
