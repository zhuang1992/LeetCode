//不能用前序遍历一遍，中序遍历一遍再比较序列
//因为节点值可能相等，但结构不同，如{1,1}, {1,#,1}
//还是一遍深搜就搞定吧
package workbench;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
public class Solution {
	boolean res = true;
	void dfs(TreeNode p, TreeNode q){
		if(p==null && q==null){
            return;
        }
        if(p == null || q== null){
        	res = false;
        	return;
        }
        if(p.val != q.val){
        	res = false;
        	return;
        }
        dfs(p.left,q.left);
        dfs(p.right,q.right);
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
		dfs(p,q);
		return res;
	}
    public static void main(String[] args){
    	TreeNode r1= new TreeNode(1);
    	r1.right = new TreeNode(1);
    	TreeNode r2 = new TreeNode(0);
    	r2.left = new TreeNode(1);
    	Solution test = new Solution();
    	System.out.println(test.isSameTree(r1, r2));
    }
}
