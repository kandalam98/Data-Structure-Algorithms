# Data-Structure-Algorithms
#We compare the common elements in both the strings
#LCS is the mother of all string comparison
#There are few exceptions 
Example:
S1 =aabbcdde
S2=aaacdbccdef
1) The first two “a” can only match with the two “a” in s2
2) The only c in s1 cannot match with the “c” in s2 which after “b”
it can only match with “c” before “d” that’s the rule of LongestCommonSub

public class LongestCommonSubsequnce 
{
    public static int lcs(String s1,String s2)
    {
        int len1=s1.length();
        int len2=s2.length();
        int [][] dp=new int[len1+1][len2+1];
        for (int i=0 ;i<len1+1; i++)
        {
            for (int j=0 ;j<len2+1 ;j++)
            {
                if (i==0 || j==0)
                {
                    dp[i][j]=0;
                }
                else if (s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
    public static void main(String args[]) 
    {
        String s1="aabbcdde";
        String s2="aaacdbccdef";
        int answer=lcs(s1,s2);
        System.out.println(answer);
        
      
    }
}
Ansswer = 6

