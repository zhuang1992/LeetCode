//注意节点值可能是负数，所以不能用 “若cur>sum则返回”来剪枝
package workbench;

public class Solution {
	int Sum;
    boolean dfs(int cur,TreeNode root){
        if(root==null)
            return false;
        if(cur+root.val == Sum && root.left==null && root.right==null)
            return true;
        return dfs(cur+root.val,root.left) || dfs(cur+root.val,root.right);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        Sum = sum;
        return dfs(0,root);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	TreeNode r = new TreeNode(1);
    	r.left = new TreeNode(3);
    	System.out.println(test.hasPathSum(r,4));
    }
}