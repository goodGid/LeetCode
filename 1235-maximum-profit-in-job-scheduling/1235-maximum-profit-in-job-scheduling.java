// from : https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/4515181/Simple-Java-Solution
class Solution {
    public int Solve(int arr[][],int index,int dp[])
    {
        if(index==arr.length)
        {
            return 0;
        }
        // 1st case take the value
        if(dp[index]!=0)
        {
            return dp[index];
        }
        int end=arr[index][1];
        int low=0,high=arr.length-1,i=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid][0]>=end)
            {
                i=mid;
                high=mid-1;
            }
            else
            {
                i=mid+1;
                low=mid+1;
            }
        }
        
        int op1=arr[index][2]+Solve(arr,i,dp);
        // 2nd case, don't take the value
        int op2=0+Solve(arr,index+1,dp);

        return dp[index]=Math.max(op1,op2);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int dp[]=new int[startTime.length];
        int arr[][]=new int[startTime.length][3];
        for(int i=0;i<arr.length;i++)
        {
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }

        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        return Solve(arr,0,dp);
    }
}
