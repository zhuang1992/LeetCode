package workbench;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> path;
    public BSTIterator(TreeNode root) {
    	path = new Stack<TreeNode>();
    	while(root != null){
        	path.add(root);
        	root = root.left;
        }        	
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	if(path.size() == 0)
    		return false;
        return true;
    }
    /** @return the next smallest number */
    public int next() {
    	TreeNode ptr = path.pop();
    	int ans = ptr.val;
    	if(ptr.right != null){
    		TreeNode cptr = ptr.right;
    		while(cptr != null){
    			path.push(cptr);
    			cptr = cptr.left;
    		}
    	}
    	return ans;
    }
    public static void main(String[] args){
    	TreeNode r = new TreeNode(1);
    	r.right = new TreeNode(2);
    	BSTIterator test = new BSTIterator(r);
    	System.out.println(test.hasNext());
    	System.out.println(test.next());
    	System.out.println(test.hasNext());
    	System.out.println(test.next());
    	System.out.println(test.hasNext());
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */