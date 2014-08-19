//后序遍历这棵树即可
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	int rst = -9999999;
	int postOrder(TreeNode r){
		if(r==null)
			return 0;
		int val = r.val;
		int vl;
		int vr;
		vl = postOrder(r.left);
		vr = postOrder(r.right);
		rst = Math.max(rst, val+vl+vr);
		val = val+(Math.max(vl,vr));
		return val>0?val:0;  //if it has a negative effect, don't pass to parents.
	}
	public int maxPathSum(TreeNode root) {
		postOrder(root);
        return rst;
    }
}