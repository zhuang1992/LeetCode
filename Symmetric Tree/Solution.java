//�ǵ�֮ǰsame tree����ô��������ǱȽ�root���������������ǲ���same tree��ֻ����һ������ת��ʱ����һ������ת��
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
		if(compare(r1.left, r2.right)==true){  //����ת������ת
			if(compare(r1.right,r2.left)==true)//����ת������ת
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