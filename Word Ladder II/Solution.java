//Ҳûʲô�ѵİ���������BFSһ��Ȼ����������ܵ���Ŀ�ĵ����·����ֻҪ��һ��hashmap��¼һ�¸����ǰ�����У�Ϊ��ԽдԽ��
//ע��Ҫ�ҵ������·��

//�ҿ�����һ�����۰�������AC�ˡ�������¸���
//�տ�ʼ˼·���ֻ��ҾͲ�˵�ˣ����ȷ�������㷨��ʵ��ʱ���Ǹ��ֵ���
//�ҵ������·��BFSʱҪע������Σ����ʹ��������Queue
//ע��ͬ��εĽڵ��Կɷ��ʣ���ע�ⲻҪ�ظ����(���level���Ѿ��м�¼��˵���˵���ʹ�����Ҫ�������)
//�տ�ʼ������ظ���Ϊ�˱���pre�г����ظ���ǰ�����õ���Set����¼�����⵼���˳�ʱ
//��ȷ���㷨Ӧ���ǲ�������ظ���ǰ���ģ���˺���������Vector
//�ӵ�����LeetCode Java��֧��Vector?�ֻ�����LinkedList��������AC��
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
	void findPath(String cur, List<String> singlePath){   //��Ϊǰ��BFS�У��ѵ�end�����Ͼ���ֹ�ˣ�����DFS������·��һ��������̵ġ�
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
    					if(!str.equals(end) && level.containsKey(str) && level.get(str) < curLevel){  //ע�ⲻ��<=��ͬ��εĽڵ���Ȼ�ǿ��Է��ʵ�
    						continue;
    					}
    					if(!str.equals(end) &&( !level.containsKey(str) || level.get(str) != curLevel)){  //ע���⣬ͬ��ڵ���Է��ʣ�����Ҫ�ظ����
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
    			if(isOver) //�����ѵ�end����ֹ����һ�㣬���ٽ����²���������֤����DFS���Ķ������·����
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