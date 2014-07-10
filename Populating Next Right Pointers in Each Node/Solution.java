//刚开始level声明的位置错了，白搞了半天。。
package workbench;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
public class Solution {
    public void connect(TreeLinkNode root) {
    	if(root==null)
    		return;
        LinkedList<TreeLinkNode>Q = new LinkedList<TreeLinkNode>();
        Q.add(root);
    	LinkedList<TreeLinkNode>level = new LinkedList<TreeLinkNode>();
        while(true){        	
        	TreeLinkNode f = Q.getFirst();
        	Q.removeFirst();
        	if(f.left != null)
        		level.add(f.left);
        	if(f.right != null)
        		level.add(f.right);
        	if(Q.isEmpty()){						//f is the last element in Q
        		f.next=null;
        		if(level.isEmpty())
        			break;
        		while(!level.isEmpty()){
        			if(!Q.isEmpty()){
        				Q.getLast().next = level.getFirst();
        			}
        			Q.add(level.getFirst());
        			level.removeFirst();
        		}
        	}        	
        }
    }
    public static void main(String[] args){
    	TreeLinkNode r = new TreeLinkNode(1);
    	r.left = new TreeLinkNode(2);
    	r.right = new TreeLinkNode(3);
    	r.left.left = new TreeLinkNode(4);
    	r.left.right = new TreeLinkNode(5);
    	r.right.left = new TreeLinkNode(6);
    	r.right.right = new TreeLinkNode(7);
    	Solution test = new Solution();
    	test.connect(r);
    }
}