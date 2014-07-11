//空间复杂度降低到O(1)，只用了一个队列，
//使用了两个int记录当前层和下一层的节点个数，从而做到在同一个队列中区分不同层的节点
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
    	int nxtLevel = 0;
    	int curLevel = 1;    	
    	TreeLinkNode pre = null;
        while(true){
        	TreeLinkNode f = Q.getFirst();
        	Q.removeFirst();
        	curLevel --;
        	if(pre != null){
        		pre.next = f;
        	}
        	pre = f;        	
        	if(f.left != null){
        		Q.add(f.left);
        		nxtLevel++;
        	}        		
        	if(f.right != null){
        		Q.add(f.right);
        		nxtLevel++;
        	}        		
        	if(curLevel==0){			
        		f.next=null;			
        		if(nxtLevel==0)
        			break;        		
        		curLevel = nxtLevel;
        		nxtLevel = 0;
        		pre = null;
        	}        	
        }
    }
    void inOrder(TreeLinkNode r){
    	if(r==null)
    		return;
    	inOrder(r.left);
    	System.out.println(r.val);
    	System.out.println(r.next);
    	inOrder(r.right);
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
    	test.inOrder(r);
    }
}