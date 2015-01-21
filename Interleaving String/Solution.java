package workbench;

import java.util.Stack;

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length() != s3.length())
			return false;
		if(s1.length() == 0 && s2.length() == 0 && s3.length()==0)
			return true;
		boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int i = 1; i <= s2.length(); i++) {
			dp[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				dp[i][j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) && dp[i - 1][j])
						|| ((s2.charAt(j - 1) == s3.charAt(i + j - 1)) && dp[i][j - 1]);
			}
		}
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		Solution test = new Solution();
		System.out.println(test.isInterleave(s1, s2, s3));
	}
}