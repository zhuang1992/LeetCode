//直接DFS会超时，加上那个剪枝就可以了
//最好还是用DP写一下
package workbench;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class Solution {
	boolean dfs(String s1, String s2){
		////////////////剪枝
		if(s2.equals(s1))
			return true;
		int A[] = new int[26];  
        for(int i = 0; i < s1.length(); i++)  
            ++A[s1.charAt(i)-'a'];    
        for(int j = 0; j < s2.length(); j++)  
            --A[s2.charAt(j)-'a'];    
        for(int k = 0; k < 26; k++)  
            if(A[k] != 0) return false;  
        ////////////////
		for(int i = 1; i < s1.length(); i++){
			String f11 = s1.substring(0,i);
			String f12 = s1.substring(i,s1.length());
			if(dfs(f11,s2.substring(s2.length()-i ,s2.length())) && dfs(f12, s2.substring(0,s2.length()-i))){
				return true;
			}
			if(dfs(s1.substring(0, i), s2.substring(0, i)) && dfs(s1.substring(i,s1.length()),s2.substring(i,s2.length()))){
				return true;
			}			
		}
		return false;
	}
    public boolean isScramble(String s1, String s2) {
    	if(s1.length() != s2.length())
    		return false;
        return dfs(s1, s2);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.print(test.isScramble("taerg", "great"));
    }
}