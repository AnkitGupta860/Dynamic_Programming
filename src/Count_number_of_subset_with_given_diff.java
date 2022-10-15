import java.util.Scanner;

public class Count_number_of_subset_with_given_diff {

    public static int countOfSubsetSum(int arr[],int sum,int n)
    {
        int dp[][] = new int[n+1][sum+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static int countDifference(int arr[],int diff,int n)
    {
        int range = 0;
        for(int i=0;i<n;i++)
        {
            range+=arr[i];
        }
        int sum = (diff+range)/2;
        return countOfSubsetSum(arr,sum,n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int diff = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println(countDifference(arr,diff,n));
    }
}
