//直接朴素的做法会超时
package workbench;
public class Solution {
    public void reorderList(ListNode head) {
    	if(head==null)
    		return;
    	ListNode tHead = head;
    	ListNode h2;
    	ListNode ptr;
    	
        while(tHead!=null){
        	h2 = tHead.next;
            ptr = tHead;
            if(ptr.next==null || ptr.next.next==null){
            	break;
            }
            while(ptr.next.next!=null)  //不断地找最后一个，这样就是O(n^2)的时间
            	ptr=ptr.next;
            ListNode t2 = ptr.next;
            ptr.next=null;
            tHead.next = t2;
            t2.next = h2;
            tHead = h2;
        }
    }
    public static void main(String[] args){
    	ListNode p1 = new ListNode(1);
    	ListNode p2 = new ListNode(2);
    	ListNode p3 = new ListNode(3);
    	ListNode p4 = new ListNode(4);
    	p1.next=p2;
    	Solution test = new Solution();
    	test.reorderList(p1);
    	ListNode ptr=p1;
    	while(ptr!=null){
    		System.out.println(ptr.val);
    		ptr = ptr.next;
    	}
    	
    }
}