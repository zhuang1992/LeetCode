//Palindrome Partitioning
//大数据时会TLE，应该是实现上的原因

package workbench;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Solution {
    void initP(boolean[][]p){
    	for(int i=0;i<p.length;i++){
    		for(int j=0;j<p[0].length;j++){
    			p[i][j]=false;
    		}
    	}
    }
	public List<List<String>> partition(String s) {
        int len = s.length();
        boolean p[][]=new boolean[len][len];
        initP(p);
        for(int i = len-1;i>=0;--i){
        	for(int j = i; j< len;++j){
        		if(s.charAt(i)==s.charAt(j) && ((i-j<2)|| p[i+1][j-1])){
        			p[i][j]=true;
        		}
        	}
        }
        System.out.println("part 1 done");
        
        int cnt=0;
        List<List<String>> sub_palins[] =new ArrayList[len]; //sub_palin[i] : sub palindromes of s[i,n]
        for(int i=len-1; i>=0; i--){
        	sub_palins[i]=new ArrayList<List<String>>();
        	System.out.println(cnt++);
        	for(int j = i; j<len; j++){
        		if(p[i][j]){
        			String palindrome = s.substring(i, j+1);
        			if(j>=len-1){
        				List<String>temp=new ArrayList<String>();
        				temp.add(palindrome);
        				sub_palins[i].add(temp);
        			}else{
        				for(int k=0;k<sub_palins[j+1].size();k++){
        					List<String>temp= new ArrayList(sub_palins[j+1].get(k));
        					temp.add(0,palindrome);
        					sub_palins[i].add(temp);
        				}
        			}
        		}
        	}
        }
        return sub_palins[0];
    }
	public static void main(String[] args){
		String s="ltsqjodzeriqdtyewsrpfscozbyrpidadvsmlylqrviuqiynbscgmhulkvdzdicgdwvquigoepiwxjlydogpxdahyfhdnljshgjeprsvgctgnfgqtnfsqizonirdtcvblehcwbzedsmrxtjsipkyxk";
		System.out.println(s.length());
		Solution test = new Solution();
		System.out.println(test.partition(s));
	}
}