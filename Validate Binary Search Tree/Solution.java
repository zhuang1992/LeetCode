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

//Recursive

public class Solution{
	boolean _isBST(TreeNode r,long lmax, long rmin){
		if(r == null)
			return true;
		if(r.val < lmax || r.val > rmin)
			return false;
		return _isBST(r.left, lmax, r.val) || _isBST(r.right, r.val, rmin);
	}
	boolean isValidBST(TreeNode r){
		return _isBST(r, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	public static void main(String[] args){
		
	}
}
