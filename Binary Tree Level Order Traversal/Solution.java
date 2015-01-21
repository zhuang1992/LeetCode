package workbench;

import java.util.Stack;
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        LinkedList<List<Integer>> rst = new LinkedList<List<Integer>>();
        if(root == null)
            return rst;
        Q.add(root);
        while(!Q.isEmpty()){
            List<Integer> level = new LinkedList<Integer>();
            while(!Q.isEmpty()){
                TreeNode f = Q.poll();
                if(f.left != null)
                    temp.add(f.left);
                if(f.right != null)
                    temp.add(f.right);
                level.add(f.val);
            }
            rst.add(level);
            while(!temp.isEmpty()){
                Q.add(temp.poll());
            }    
        }
        return rst;
    }
}