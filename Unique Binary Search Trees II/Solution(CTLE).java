//��I�Ļ����ϸĵġ�����Ƕԣ�����֪��ΪʲôCompile time limit exceeds. WTF!
//�ѵ����õ��ڴ���ࣿ�����ΪҪ����֮ǰÿ�ÿ��ܵ�����ռ�ڴ���ࡣI��ֻ�����ĸ��������Խ��ܣ�II��Ҫ�����������е���ܲ����ˡ�
//������ʱ�䣬ֱ��DFS�ɡ�
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	TreeNode addNumAndCopy(TreeNode r, int n){
		if(r==null)
			return null;
		TreeNode nr = new TreeNode(r.val+n);
		nr.left = addNumAndCopy(r.left, n);
		nr.right = addNumAndCopy(r.right, n);
		return nr;
	}
	List<List<TreeNode>> recordTree = new LinkedList<List<TreeNode>>();
    public List<TreeNode> generateTrees(int n) {
        int record[] = new int[n+1];
        record[0] = 1;
        recordTree.add(null);
        record[1] = 1;
        List<TreeNode>tmp = new LinkedList<TreeNode>();
        
        tmp.add(new TreeNode(1));
        recordTree.add(tmp);
        if(n==1)
            return recordTree.get(1);
        for(int i = 2; i <= n; i++){
        	//System.out.println(recordTree.size());
        	int split = i-1;
        	int t = 0;
        	record[i] = 1;
    		List<TreeNode> ttTree = new LinkedList<TreeNode>();
        	while(split>=0){
        		TreeNode tt = null;
        		TreeNode ttt = null;
        		for(int z = 0; z < record[i-1-split]; z++){
        			if(recordTree.get(i-1-split)!=null){
        				tt = new TreeNode(i-split);
        				tt.left = recordTree.get(i-1-split).get(z);   
        			}        			
	        		for(int y = 0; y < record[split]; y++){
	        			if(recordTree.get(split)!=null){
	        				ttt = new TreeNode(i-split);
	        				if(tt != null)
	        					ttt.left = tt.left;
	        				ttt.right = addNumAndCopy(recordTree.get(split).get(y),i-split);
	        				ttTree.add(ttt);
	        			}else
	        				ttTree.add(tt);
	        		}       		
        		}	        		
        		split--;
        	}    
        	record[i] = t;
        	recordTree.add(ttTree);
        }
        return recordTree.get(n);
    }
}