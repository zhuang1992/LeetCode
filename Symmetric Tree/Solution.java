//记得之前same tree那题么？这题就是比较root的左右两棵子树是不是same tree，只不过一个向左转的时候另一个向右转。
package workbench;

import java.util.*;
public class Solution {
	boolean compare(TreeNode r1, TreeNode r2){
		if(r1==null && r2!=null)
			return false;
		if(r1!=null && r2==null)
			return false;
		if(r1==null && r2 == null)
			return true;
		if(r1.val != r2.val)
			return false;
		if(compare(r1.left, r2.right)==true){  //向左转，向右转
			if(compare(r1.right,r2.left)==true)//向右转，向左转
				return true;
		}
		return false;
		
	}
    public boolean isSymmetric(TreeNode root) {
    	if(root == null)
    		return false;
        return compare(root.left, root.right);
    }
}