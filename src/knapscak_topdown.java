import java.util.Scanner;

public class knapscak_topdown {
    public static int Knapsack1(int wt[],int val[],int w,int n)
    {
        int arr[][] = new int[n+1][w+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<w+1;j++)
            {
                if(i==0 || j==0)
                {
                    arr[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<w+1;j++)
            {
                if(wt[i-1]<=j)
                {
                    arr[i][j] = Math.max(val[i-1]+arr[i-1][j-wt[i-1]],arr[i-1][j]);
                }
                else
                {
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        return arr[n][w];
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
        System.out.println(Knapsack1(wt,val,w,n));
    }
}
