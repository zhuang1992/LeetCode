//Using precursor and preorder traverse
public class Solution {
    private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}


// - -
public class Solution {
    TreeNode moveLeftToRight(TreeNode r){
    	if(r==null)
    		return null;
    	TreeNode rtemp = r.right;
    	
    	TreeNode tr = moveLeftToRight(r.left);
    	if(tr != null){
    		r.right = tr; 
    		r.left = null;    		
    	}else{
    		r.right = moveLeftToRight(rtemp);
    		return r;
    	}
    	while(tr.right!=null)
    		tr = tr.right;
    	tr.right =  moveLeftToRight(rtemp);
    	return r;
    }
	public void flatten(TreeNode root) {
    	root = moveLeftToRight(root);
    }
	public static void main(String[] args){
		Solution test  = new Solution();
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(5);
		r.left.left = new TreeNode(3);
		r.left.right = new TreeNode(4);
		r.right.right  = new TreeNode(6);
		test.flatten(r);
		while(r!=null){
			if(r.left!=null)
				System.out.print("wrong");
			System.out.println(r.val);
			r = r.right;
		}
	}
}