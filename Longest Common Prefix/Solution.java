package workbench;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	if(s.length()==0)return 0;
    	char[] temp = s.toCharArray();
    	int[] last = new int[256];
    	for(int i = 0; i < 256; i++){
    		last[i] = -1;
    	}
    	int len = 0;
    	int start = 0;
        for(int i = 0; i < s.length(); i++){
        	if(last[temp[i]]>=start){
        		len = len < i - start? i - start : len;
        		start = last[temp[i]]+1;
        	}
        	last[temp[i]] = i;        	
        }
        len = len < last[temp[s.length()-1]] - start + 1 ? last[temp[s.length()-1]] - start + 1 : len;
        return len;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	String s = "abcauvwxyz";
    	System.out.println(test.lengthOfLongestSubstring(s));
    }
}