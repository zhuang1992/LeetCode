//Ö±½ÓDFS»¹ÊÇTLEÁË
//»¹ÊÇÒªDP
//°¡ÎÒ¾ÓÈ»×Ô¼ºÐ´³öÀ´Õâ¸öDPÁË£¡£¡£¡
//O(n^2)£¬¹Ø¼üÒª¸ãºÃÌî¾ØÕóµÄË³Ðò°¡~~
//dp[i][j]±íÊ¾£º´ÓiÍùºó£¬Èç¹ûÑ¡Ôñ´Ój´¦Åü¿ª£¬ÄÜ·ñÇ¡ºÃ½«s³¹µ×²ð·Ö
//ÏÔÈ»ÌîÕâ¸ö¾ØÕó£¬Òªµ¹×ÅÀ´Ìî¡£
package workbench;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
		boolean dp[][] = new boolean[s.length()][s.length()];
		for(int i = s.length()-1; i >= 0; i--){
			for(int j = s.length()-1; j >=i; j--){
				if(dict.contains(s.substring(i,j+1))){
					if(j == s.length()-1){
						dp[i][j] = true;
					}else{
						dp[i][j] = dp[j+1][s.length()-1];
					}
				}else{
					dp[i][j] = false;
				}					
			}
			for(int b = i; b < s.length()-1; b++){ 	//Õâ¸öforÖ»ÄÜÔÚÉÏÃæÄÇ¸öforÍêÖ®ºóÔÙ¿ªÊ¼£¬ÒòÎªÖ±µ½ÕâÊ±ÐèÒªÓÃµ½µÄdpÐÅÏ¢²ÅÊÕ¼¯Íê³É¡£Ëµµ½µ×»¹ÊÇÌî±íË³Ðò¾ö¶¨µÄ0¡£
				if(dp[i][b]==true && dp[b+1][s.length()-1]==true){
					dp[i][s.length()-1] = true;
					break;
				}
			}
		}
		
		return dp[0][s.length()-1];
    }
    public static void main(String[] args){
    	Solution test =new Solution();
    	Set<String>dict = new HashSet<String>();
    	dict.add("leet");
    	dict.add("code");
    	System.out.print(test.wordBreak("leetscode", dict));
    }
}


//
/**
 * Copyright: NineChapter
 * - Algorithm Course, Mock Interview, Interview Questions
 * - More details on: http://www.ninechapter.com/
 */

public class Solution {
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int j = 1; j <= maxLength && j <= i; j++) {
                if (!canSegment[i - j]) {
                    continue;
                }
                String word = s.substring(i - j, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return canSegment[s.length()];
    }
}