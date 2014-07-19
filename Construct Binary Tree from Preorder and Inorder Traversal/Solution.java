//preorder的第一个元素是根结点，利用它可以将inorder分成两部分，分别是左右子树，可以递归解决。
package workbench;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
public class Solution {
	TreeNode build(int[] preorder, int root, int[] inorder, int st, int end ){
		if(st>end)
			return null;
		if(st==end){
			return new TreeNode(inorder[st]);
		}
		TreeNode r = new TreeNode(preorder[root]);
		for(int i = st; i <= end; i++){
			if(preorder[root] == inorder[i]){
				r.left = build(preorder, root+1, inorder, st, i-1);//在preorder[]中找到左子树的根结点，这个比较容易
				r.right  = build(preorder, root+i-st+1, inorder, i+1, end); //这个要注意，root+i-st+1, 如何在preorder[]中找到右子树的根结点。
				break;
			}
		}		
		return r;
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length==0)
    		return null;
    	return build(preorder, 0, inorder, 0, inorder.length-1);        
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int p[]={1,2,4,3,5};
    	int in[]={1,2,3,4,5};
    	TreeNode r = test.buildTree(p, in);
    }
}