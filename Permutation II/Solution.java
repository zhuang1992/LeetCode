//这种方法太暴力，直接用set去重，复杂度偏高。推荐下面两种。
package workbench;

public class Solution {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Set<List<Integer>> tempRes = new HashSet<List<Integer>>();
	List<Integer> temp;
	public List<List<Integer>> permuteUnique(int[] num) {
		//res.add(null);
        for(int i = 0; i < num.length; i++){
        	if(res.size()==0){
        		temp = new LinkedList<Integer>();
        		temp.add(num[i]);
        		res.add(temp);
        		continue;
        	}
        	for(int j = 0; j < res.size(); j++){
        		for(int k = 0; k <= res.get(j).size(); k++){
        			temp = new LinkedList<Integer>(res.get(j));
        			temp.add(k,num[i]);
        			tempRes.add(temp);
        		}
        	}
        	res = new LinkedList<List<Integer>>(tempRes);
        	tempRes.clear();
        	
        }
        return res;
    }
	public static void main(String[] args){
		int num[]={1,1,2,1};
		Solution test = new Solution();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = test.permuteUnique(num);
		//System.out.println(res.size());
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j));
			}
			System.out.println("");
		}
	}
}
//Recursion
public class Solution {
    List<List<Integer>> rst = new LinkedList<List<Integer>>();
    
    void dfs(int[] num, List<Integer> per, int pos, int insertPos){
        if(per.size() == num.length){
            rst.add(new LinkedList<Integer>(per));
            return;
        }
        int st = 0;
        if(pos > 0 && num[pos] == num[pos-1]){           //如果这个数与上个数是一样的，则这个数可选的插入位置仅限于上个数插入位置之后。这样就避免了重复计算。
            st = insertPos+1;
        }
        for(int i = st; i <= per.size(); i++){
            per.add(i, num[pos]);
            dfs(num, per, pos+1, i);
            per.remove(i);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        dfs(num, new LinkedList<Integer>(), 0, 0);
        return rst;
    }
}

//Iteration
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        LinkedList<List<Integer>> rst = new LinkedList<List<Integer>>();
        if(num == null || num.length == 0)
            return rst;
        rst.add(new LinkedList<Integer>());//rst=[[]];
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            int cnt = rst.size();
            while(cnt-- > 0){
                List<Integer> item = rst.getFirst();
                int st = 0;
                if(i > 0 && num[i] == num[i-1]){
                    st = item.lastIndexOf(num[i-1])+1;   //同样是先需要获得上一个重复的数的位置。
                }
                for(int k = st; k <= item.size(); k++){
                    item.add(k,num[i]);
                    rst.add(new LinkedList<Integer>(item));
                    item.remove(k);
                }
                rst.removeFirst();
            }
        }
        return rst;
    }
}