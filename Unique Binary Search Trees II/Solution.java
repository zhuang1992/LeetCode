//在I的基础上改的。结果是对，但不知道为什么Compile time limit exceeds. WTF!
//难道是用的内存过多？这个因为要储存之前每棵可能的树，占内存过多。I中只存树的个数还可以接受，II中要存具体的树就有点接受不了了。
//牺牲点时间，直接DFS吧。
//注意这个DFS返回的直接是List<TreeNode>。这样很方便。
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    List<TreeNode> dfs(int st, int en){
        List<TreeNode> rst = new LinkedList<TreeNode>();
    	if(st<1 || en>n || st > en){
    		rst.add(null);
    		return rst;
    	}
    	for(int i = st; i <= en; i++){   
    		List<TreeNode>leftTree = dfs(st,i-1);
    		List<TreeNode>rightTree = dfs(i+1,en);
    		for(int j = 0; j < leftTree.size(); j++){
    			for(int k = 0; k < rightTree.size(); k++){
    				TreeNode node = new TreeNode(i);
    				node.left = leftTree.get(j);
    				node.right = rightTree.get(k);
    				rst.add(node);
    			}
    		}	
    	}    	
		return rst;
    }
    int n;
    TreeNode temp;
	public List<TreeNode> generateTrees(int n) {
        this.n = n;
        return dfs(1,n);
    }
	void dfs(TreeNode r){
    	if(r==null)
    		return;
    	System.out.print(r.val+" ");
    	dfs(r.left);
    	dfs(r.right);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	List<TreeNode>r = test.generateTrees(3);
    	for(int i = 0; i < r.size(); i++){
    		test.dfs(r.get(i));
    		System.out.print('\n');
    	}
    	System.out.print("done");
    }
}