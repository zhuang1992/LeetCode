//也没什么难的啊，不过是BFS一下然后输出所有能到达目的的最短路径，只要用一个hashmap记录一下各点的前驱就行，为何越写越乱
//注意要找的是最短路径

//我靠真是一波三折啊，终于AC了。必须得吐个槽
//刚开始思路各种混乱就不说了，最后确定下来算法后，实现时又是各种蛋疼
//找的是最短路，BFS时要注意分清层次，因此使用了两个Queue
//注意同层次的节点仍可访问，但注意不要重复入队(如果level中已经有记录，说明此点访问过，不要再入队了)
//刚开始入队有重复，为了避免pre中出现重复的前驱，用的是Set来记录，而这导致了超时
//正确的算法应该是不会出现重复的前驱的，因此后来换用了Vector
//坑爹的是LeetCode Java不支持Vector?又换成了LinkedList，才终于AC。
package workbench;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class Solution {
	List<List<String>>res = new ArrayList<List<String>>();
	
	HashMap<String, List<String> >pre = new HashMap<String, List<String>>();
	String start;
	String end;
	void findPath(String cur, List<String> singlePath){   //因为前面BFS中，搜到end后马上就终止了，这里DFS出来的路径一定都是最短的。
		if(cur.equals(start)){
			res.add(singlePath);
			return;
		}
		if(!pre.containsKey(cur))
			return;
		List<String> p = pre.get(cur);
		for(String i : p){
			List<String>ts = new ArrayList<String>(singlePath);
			ts.add(0,i);
			findPath(i,ts);
		}		
	}
	HashMap<String, Integer>level = new HashMap<String, Integer>();
	
	List<List<String>> bfs(Set<String>dict){
    	Queue<String>Q = new LinkedList<String>();
    	Queue<String>nlevelQ = new LinkedList<String>();
    	Q.add(start);
    	level.put(start, 0);
    	boolean isOver  = false;
    	int curLevel = 1;
    	while(!Q.isEmpty()){
    		String f = Q.poll();
    		//System.out.println(f);
    		StringBuffer strbuff = new StringBuffer(f);
    		for(int i = 0; i < f.length(); i++){
    			char ori = strbuff.charAt(i);
    			for(char j = 'a'; j <= 'z'; j++){
    				if(j==ori)
    					continue;
    				strbuff.replace(i, i+1,""+j);       
    				String str = strbuff.toString();
    				if(str.equals(end))
    					isOver = true;
    				if(dict.contains(str)){
    					if(!str.equals(end) && level.containsKey(str) && level.get(str) < curLevel){  //注意不是<=，同层次的节点仍然是可以访问的
    						continue;
    					}
    					if(!str.equals(end) &&( !level.containsKey(str) || level.get(str) != curLevel)){  //注意这，同层节点可以访问，但不要重复入队
    						nlevelQ.add(str);
    					}
    					level.put(str, curLevel);    						
    					if(pre.containsKey(str)){
    						List<String>temp = pre.get(str);
    						temp.add(f);
    					}else{
    						List<String>temp = new LinkedList<String>();
    						temp.add(f);
    						pre.put(str, temp);
    					}    					
    				}
    			}
    			strbuff.replace(i, i+1, ""+ori);
    		}
    		if(Q.isEmpty()){
    			if(isOver) //发现搜到end，终止于这一层，不再进行下层搜索，保证后面DFS到的都是最短路径。
    				break;
    			while(!nlevelQ.isEmpty()){
    				String temp = nlevelQ.poll();
    				Q.add(temp);
    			}
    			curLevel++;
    		}
    	}	
    	List<String> s = new ArrayList<String>();
    	s.add(end);
    	findPath(end, s);
    	return res;
    }
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		dict.add(start);
		dict.add(end);
		this.start = start;
		this.end = end;
		return bfs(dict);
    }
	public static void main(String[] args){
		Solution test = new Solution();
		Set<String>dict = new HashSet<String>();
		String start="hot";
		String end="dot";
//		dict.add("ted");
//		dict.add("tex");
//		dict.add("red");
//		dict.add("tax");
//		dict.add("tad");
//		dict.add("den");
//		dict.add("rex");
//		dict.add("pee");
		dict.add("hot");
//		dict.add("cog");
		dict.add("dog");
//		dict.add("tot");
//		dict.add("hog");
//		dict.add("hop");
//		dict.add("pot");
		dict.add("dot");
		System.out.println(test.findLadders(start, end, dict));
	}
}