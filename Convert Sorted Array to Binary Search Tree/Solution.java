//����о����ǻ��ǰ������Ҿ�Ȼһ���Ӿ͹���
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
		ptr.next = null;  //Ҫ�Ͽ�
		return mid;
	}
    public TreeNode sortedListToBST(ListNode head) {
    	if(head==null)
    		return null;
    	if(head.next==null) //ֻ��һ������ˣ�ֱ�ӷ���
    		return new TreeNode(head.val);
        ListNode mid = getAndIsolateMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next); //������Ҫ���м������һ����㿪ʼ
        return root;
    }
    public static void main(String[] args){
    	ListNode head = new ListNode(1);
    	//��ȥ�Ҹմ���һ�в��Դ��룬���Ƚ��˷����ԣ������Ȼ���ˣ���
    }
    
}