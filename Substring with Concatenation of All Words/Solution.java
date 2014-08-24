//脑洞大开如果直接套用word break里的函数，复杂度为O(m^2)，m是L中所有字符串的长度和
//把S从头到尾遍历一遍，这样总的复杂度是O(n*m^2)，n是S的长度
//果然超时了。这是因为word break情况更一般，字典中的string长度可以不同。套用word break是用牛刀了，难怪超时。

//呃居然直接上就能过。只是注意要用Hash表来做统计。还有L中各单词长度一致，可以加速。
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
   public List<Integer> findSubstring(String S, String[] L) {
	   List<Integer>rst = new LinkedList<Integer>();
	   HashMap<String, Integer> hash = new HashMap<String, Integer>();//L中各单词出现的次数
	   HashMap<String, Integer> cur = new HashMap<String, Integer>();	//当前串中已出现哪些单词及次数
	    for(String t : L){
	    	if(hash.containsKey(t)){
	    		hash.put(t, hash.get(t)+1);  //L中可能有重复单词
	    	}else{
	    		hash.put(t, 1);
	    	}	    	
	    }
	    int singLen = L[0].length();
	    int totalLen = L.length * singLen;
	    for(int i = 0; i <= S.length() - totalLen; i++){  //直接枚举子串的起始位置。真暴力。
	    	cur.clear();
	    	int j;
	    	for(j = i ; j < i+totalLen; j+=singLen){  //各单词长度一致，一次跳singLen
	    		String temp = S.substring(j, j+singLen);
	    		if(!hash.containsKey(temp))   //含有L中没有的单词，失败，break
	    			break;
	    		if(cur.containsKey(temp)){
	    			if(cur.get(temp) < hash.get(temp)){  
	    				cur.put(temp, cur.get(temp)+1);
	    			}else														//数量超过了L中出现的次数，失败，break
	    				break;
	    		}else{
	    			cur.put(temp, 1);
	    		}
	    	}
	    	if(j==i+totalLen){  // j == i+totalLen说明成功了，记录。
	    		rst.add(i);
	    	}
	    }
	    return rst;
   }
	public static void main(String[] args){
		String L[] = {"a"};
		Solution test = new Solution();
		List<Integer> r = test.findSubstring("a", L);
		for(Integer i : r)
			System.out.println(i);
	}
}