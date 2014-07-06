//����DFS����·���ȽϺô�ӡ�������ݹ����Ȼ����
//����ע�⣬���ͨ��һ���ڵ�����ж����ɹ�·��������ڵ�Ҫ����ӵ�ÿһ��·����ȥ��·����������ͨ//������ֵ������һ��

public class Solution {
	int Sum;
    int  dfs(int cur,TreeNode root, List<List<Integer>>paths){
        if(root==null)
            return 0;
        if(cur+root.val == Sum && root.left==null && root.right==null){
        	List<Integer> p = new LinkedList<Integer>();
        	p.add(root.val);
        	paths.add(p);       
            return 1; 	
        }
        int res = 0;
        int t=0;
        if((t=dfs(cur+root.val,root.left,paths))>0){
        	for(int i = 0; i < t; i++){
        		paths.get(paths.size()-1-i).add(0,root.val);
        	}
        	res += t;
        }
        if((t=dfs(cur+root.val,root.right,paths))>0){
        	for(int i = 0; i < t; i++){
        		paths.get(paths.size()-1-i).add(0,root.val);
        	}
        	res += t;
        }
        return res;
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Sum = sum;
        List<List<Integer>>paths = new LinkedList<List<Integer>>();
        dfs(0,root,paths);
        return paths;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	TreeNode r = new TreeNode(1);
    	r.left = new TreeNode(0);
    	r.left.left = new TreeNode(1);
    	r.left.left.left = new TreeNode(0);
    	r.right = new TreeNode(1);
    	r.right.right = new TreeNode(-1);
    	r.right.right.right = new TreeNode(0);
    	r.left.right = new TreeNode(2);
    	r.left.right.left = new TreeNode(-1);
    	r.left.right.right = new TreeNode(0);
    	System.out.println(test.pathSum(r,2));
    }
}