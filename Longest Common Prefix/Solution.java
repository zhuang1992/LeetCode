package workbench;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        int minLen = 999999999;
        int minId = -1;
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length()<minLen){
                minLen = strs[i].length();
                minId = i;
            }
        }
        int maxL = strs[minId].length();
        int tail = 0;
        boolean isOver = false;
        while(tail<maxL){
            for(int i = 0; i < strs.length; i++){
                if(strs[i].charAt(tail)!=strs[minId].charAt(tail)){
                    isOver = true;
                    break;
                }
            }
            if(isOver)break;
            tail++;
        }
        if(tail==maxL)
            return strs[minId];
        return strs[minId].substring(0,tail);
    }
}