//求无权图的最短路径，用BFS
//注意在寻找可转移到的点时，不能遍历整个Set挨个判断，这样复杂度是n^2
//而是试着对源单词的每一位做出一次修改，看是否在这个Set中。这样复杂度是26*word_length。注意使用了Hash，判断是否在集合中的复杂度为O(1)。

public class Solution {
    boolean checkNeighbor(String a, String b){
    	boolean diff = false;
    	for(int i = 0; i < a.length(); i++){
    		if(a.charAt(i)!=b.charAt(i)){
    			if(!diff)diff=true;
    			else return false;
    		}
    	}
    	return true;
    }
    int bfs(String start, Set<String>dict,String end){
    	Queue<String>Q = new LinkedList<String>();
    	Q.add(start);
    	HashMap<String,Integer> depth = new HashMap<String,Integer>();
    	depth.put(start,1);
    	while(!Q.isEmpty()){
    		String f = Q.poll();
    		if(checkNeighbor(f,end)){
    			return depth.get(f)+1;
    		}
    		StringBuffer strbuff = new StringBuffer(f);
    		for(int i = 0; i < f.length(); i++){
    			char ori = strbuff.charAt(i);
    			for(char j = 'a'; j <= 'z'; j++){
    				if(j==ori)
    					continue;
    				strbuff.replace(i, i+1,""+j);       //char 变String!!!
    				String str = strbuff.toString();
    				if(dict.contains(str)){
    					depth.put(str, depth.get(f)+1);
            			Q.add(str);
            			dict.remove(str);
    				}
    			}
    			strbuff.replace(i, i+1, ""+ori);
    		}
    	}
    	return 0;
    }
	public int ladderLength(String start, String end, Set<String> dict) {
		dict.add(start);
		dict.add(end);
		int res =bfs(start,dict,end);
        return res;
    }
	public static void main(String[] args){
		Solution test = new Solution();
		Set<String>dict = new HashSet<String>();
		String start="hit";
		String end="dog";
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		System.out.println(test.ladderLength(start, end, dict));
	}
}