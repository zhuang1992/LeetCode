//��I�Ļ����ϸĵġ�����Ƕԣ�����֪��ΪʲôCompile time limit exceeds. WTF!
//�ѵ����õ��ڴ���ࣿ�����ΪҪ����֮ǰÿ�ÿ��ܵ�����ռ�ڴ���ࡣI��ֻ�����ĸ��������Խ��ܣ�II��Ҫ�����������е���ܲ����ˡ�
//������ʱ�䣬ֱ��DFS�ɡ�
//ע�����DFS���ص�ֱ����List<TreeNode>�������ܷ��㡣
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