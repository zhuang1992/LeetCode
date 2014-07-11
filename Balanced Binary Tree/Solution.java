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
	int dfs(TreeNode r){
		if(r==null)
			return 0;
		int ldepth = dfs(r.left);
		int rdepth = dfs(r.right);
		if(ldepth == -1 || rdepth == -1)
			return -1;
		if(Math.abs(ldepth - rdepth)>1){
			res = false;
			return -1;
		}
		return Math.max(ldepth, rdepth)+1;
	}
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }
    public static void main(String[] args){
    	TreeNode r = new TreeNode(1);
    	r.right = new TreeNode(3);
    	r.right.left = new TreeNode(6);
    	r.right.right = new TreeNode(7);
    	Solution test = new Solution();
    	System.out.println(test.isBalanced(r));
    }
}