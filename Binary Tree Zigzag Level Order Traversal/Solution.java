package workbench;

import java.util.*;

public class Solution {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    void bfs(TreeNode root){
    	Queue<TreeNode>Q = new LinkedList<TreeNode>();
    	Q.add(root);
    	int curLevel = 1;
    	int nxtLevel = 0;
    	boolean dir = true;
    	List<Integer>level = new LinkedList<Integer>();
    	while(!Q.isEmpty()){
    		TreeNode f = Q.poll();
    		if(dir==true){
    			level.add(f.val);
    		}else{
    			level.add(0,f.val);
    		}
    		curLevel --;
    		if(f.left!=null){
    			Q.add(f.left);
    			nxtLevel++;
    		}
    		if(f.right!=null){
    			Q.add(f.right);
    			nxtLevel++;
    		}
    		if(curLevel==0){
    			res.add(level);
    			level = new LinkedList<Integer>();
    			dir = !dir;
    			curLevel = nxtLevel;
    			nxtLevel = 0;
    		}
    	}
    }
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null)
	        return res;
        bfs(root);
        return res;
    }
	public static void main(String[] args){
		Solution test = new Solution();
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		List<List<Integer>> t = test.zigzagLevelOrder(r);
		for(int i = 0; i < t.size(); i++){
			System.out.println(t.get(i));
		}
	}
}