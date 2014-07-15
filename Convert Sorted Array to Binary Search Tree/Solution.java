//这个感觉很是机智啊，而且居然一下子就过了
package workbench;

public class Solution {
	ListNode getAndIsolateMid(ListNode head){
		ListNode ptr= head;
		int cnt = 0;
		while(ptr!=null){
			cnt++;
			ptr=ptr.next;
		}
		ptr = head;
		for(int i = 0; i < cnt/2-1; i++){
			ptr = ptr.next;
		}
		ListNode mid = ptr.next;
		ptr.next = null;  //要断开
		return mid;
	}
    public TreeNode sortedListToBST(ListNode head) {
    	if(head==null)
    		return null;
    	if(head.next==null) //只有一个结点了，直接返回
    		return new TreeNode(head.val);
        ListNode mid = getAndIsolateMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next); //右子树要从中间结点的下一个结点开始
        return root;
    }
    public static void main(String[] args){
    	ListNode head = new ListNode(1);
    	//我去我刚打完一行测试代码，就先交了发试试，结果居然过了！！
    }
    
}