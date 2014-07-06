//中序遍历一遍，看是否递增
package workbench;

import java.util.Stack;


public class Solution {
	boolean init = true;
	int previous=0;
	boolean inOrder(TreeNode r){
		if(r==null)
			return true;
		if(!inOrder(r.left)){
			return false;
		}
		if(init){
			previous = r.val;
			init = false;
		}else{
			if(r.val<=previous)
				return false;
			else
				previous=r.val;
		}
		if(inOrder(r.right))
			return true;
		return false;
	}
    public boolean isValidBST(TreeNode root) {
    	return inOrder(root);
    }
    public static void main(String[] args){
        Solution test = new Solution();
        TreeNode r = new TreeNode(1);
        r.right = new TreeNode(1);
        System.out.println(test.isValidBST(r));
    }
}