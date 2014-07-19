package workbench;
//��ǰ������������ȫ�ԳƵģ��������е����һ����Ϊ����
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
public class Solution {
    TreeNode build(int[] postorder, int root, int[] inorder, int st, int end){
    	if(st > end)
    		return null;
    	if(st == end)
    		return new TreeNode(inorder[st]);
    	TreeNode r = new TreeNode(postorder[root]);
    	for(int i = st; i <= end; i++){
    		if(inorder[i] == postorder[root]){
    			r.right = build(postorder, root - 1, inorder, i+1,end);  //root-1��postorder����root���������ĸ���
    			r.left = build(postorder, root - (end -i) -1, inorder, st, i-1);//root - (end -i) -1��postorder����root���������ĸ���
    			break;
    		}
    	}
    	return r;
    }
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0)
        	return null;
        return build(postorder, postorder.length-1, inorder, 0, inorder.length-1);
    }
}