package Project2.fractionalknap;


import java.util.Scanner;

public class main {
    public static void main(String args[]) {   //variable instantiation
        int i, j = 0, qty, m, n;
        float sum=0,max;
        int totalCost;
        //INPUT
        Scanner sc = new Scanner(System.in);
        //2 dim array, one row for wieght, the other for values
        int array[][];
        System.out.println("Enter number of items");
        n=sc.nextInt();
        array = new int[2][n];
        System.out.println("Enter the weights of each items");
        for(i=0;i<n;i++)
            array[0][i]=sc.nextInt();

        System.out.println("Enter the values of each items");
        for(i=0;i<n;i++)
            array[1][i]=sc.nextInt();

        System.out.println("Enter maximum volume of knapsack :");
        qty = sc.nextInt();
        //keeps track of loop, contiues as long as there is space in the bag
        m = qty;
        while(m>=0)
        {
            //current size
            max=0;
            //this loops finds the maximum value from the list, this index is stored in j
            for(i=0;i<n;i++)
            {
                if(((float)array[1][i])/((float)array[0][i])>max)
                {
                    //sets current max and keeps track of its index j=i
                    max=((float)array[1][i])/((float)array[0][i]);

                    j=i;
                }
            }

            //this outputs the items, the first case is when an item won't completely fit, and it cuts it into pieces
            if(array[0][j]>m)
            {
                System.out.println("Quantity of item number: " +  (j+1) + " added is " +m);
                //keeps track of total profit
                sum+=m*max;
                //causes the loop to quit
                m=-1;
            }
            else
            {
                System.out.println("Quantity of item number: " + (j+1) + " added is " + array[0][j]);
                //takes away allowable space
                m-=array[0][j];
                sum+=(float)array[1][j];
                //removes the item from the list
                array[1][j]=0;
            }
        }
        System.out.println("The total profit is " + (int) sum);
        sc.close();
    }

}
