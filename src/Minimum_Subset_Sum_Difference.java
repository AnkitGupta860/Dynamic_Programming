import java.util.ArrayList;
import java.util.Scanner;

public class Minimum_Subset_Sum_Difference {

    public static int minDifference(int arr[],int n)
    {
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        boolean dp[][] = new boolean[n+1][sum+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<(sum/2)+1;i++)
        {
            if(dp[n][i]==true)
            {
                list.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++)
        {
            min = Math.min(min,sum-(2*list.get(i)));
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println(minDifference(arr,n));
    }
}
