import java.sql.SQLOutput;
import java.util.Scanner;

public class knapsack {

    public static int Knapsack(int wt[],int val[],int w,int n)
    {
        if(n==0 || w==0)
        {
            return 0;
        }
        if(wt[n-1]<=w)
        {
            return Math.max(val[n-1]+Knapsack(wt,val,w-wt[n-1],n-1),Knapsack(wt,val,w,n-1));
        }
        else
        {
            return Knapsack(wt,val,w,n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];
        for(int i=0;i<n;i++)
        {
            wt[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            val[i] = sc.nextInt();
        }
        System.out.println(Knapsack(wt,val,w,n));
    }
}
