//双指针，尾指针先行，完全覆盖T后，首指针右移直到不能再右。记录下来长度。首指针再右移一位(此时不能覆盖T了)，再右移尾指针直到覆盖T。取最短即可。
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public String minWindow(String S, String T) {
        int data[] = new int[128];
        int now[] = new int[128];
        int toT = T.length();
        String rst="";
        for(int i = 0; i < T.length(); i++){
        	data[T.charAt(i)]++;
        }
        int ptr1 = 0;
        int ptr2 = -1;
        while(ptr2 < S.length()){
        	while(toT > 0){
           		ptr2++;
           		if(ptr2>=S.length())
           			break;
           		if(data[S.charAt(ptr2)]>0){
           			if(now[S.charAt(ptr2)] < data[S.charAt(ptr2)]){
               			toT--;
           			}
           			now[S.charAt(ptr2)]++;
           		}
            }
           	if(toT > 0 && ptr2>=S.length())
           		return rst;
           	while(data[S.charAt(ptr1)]==0 || now[S.charAt(ptr1)] > data[S.charAt(ptr1)]){
           		if(now[S.charAt(ptr1)] > data[S.charAt(ptr1)])
           			now[S.charAt(ptr1)]--;
           		ptr1++;           		
           	}
           	if(rst.equals("") || ptr2-ptr1+1 < rst.length()){
           		rst = S.substring(ptr1,ptr2+1);
           	}
           	now[S.charAt(ptr1)]--;
           	toT++;         	
           	ptr1++;
        }       
        return rst;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.print(test.minWindow("ADOBECODEBAN", "ABC"));
    }
}