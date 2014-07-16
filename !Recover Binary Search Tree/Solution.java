//注意递归是要用到栈的，空间复杂度为O(n)
//如何将空间复杂度降为O(1)呢? 传说中的morris中序遍历是啥？
package workbench;

import java.util.*;
public class Solution {
    TreeNode pre;
    TreeNode m1 = null;
    TreeNode m2 = null;
    boolean isOver = false;
    boolean init = true;
	void inorderLeft(TreeNode r){
		if(r==null)
			return;
		if(isOver)
			return;
    	inorderLeft(r.left);
    	if(init){
    		pre = r;
    		init = false;
    	}else	if(r.val <pre.val){
    		m1 = pre;
    		isOver = true;
    		return;
    	}
    	pre = r;
    	inorderLeft(r.right);
    }
	void inorderRight(TreeNode r){
		if(r==null)
			return;
		if(isOver)
			return;
		inorderRight(r.right);
		if(init){
			pre = r;
			init = false;
		}else if(r.val > pre.val){
			m2 = pre;
			isOver = true;
			return;
		}
		pre = r;
		inorderRight(r.left);
	}
	public void recoverTree(TreeNode root) {
		if(root==null)
			return;
		init = true;
		isOver = false;
        inorderLeft(root);

		init = true;
        isOver = false;
        inorderRight(root);
        int temp = m1.val;
        m1.val = m2.val;
        m2.val = temp;
    }
	public static void main(String[] args){
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(3);
		Solution  test = new Solution();
		test.recoverTree(r);
		System.out.println(r.val+"	"+r.left.val+"	"+r.right.val);
	}
}