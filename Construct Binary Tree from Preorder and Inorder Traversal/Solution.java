//preorder�ĵ�һ��Ԫ���Ǹ���㣬���������Խ�inorder�ֳ������֣��ֱ����������������Եݹ�����
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
				r.left = build(preorder, root+1, inorder, st, i-1);//��preorder[]���ҵ��������ĸ���㣬����Ƚ�����
				r.right  = build(preorder, root+i-st+1, inorder, i+1, end); //���Ҫע�⣬root+i-st+1, �����preorder[]���ҵ��������ĸ���㡣
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