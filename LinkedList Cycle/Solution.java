package workbench;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	boolean moveForward(ListNode ptr,int step){
		while(step-- > 0){
			ptr = ptr.next;
			if(ptr==null)
				return false;
		}
		return true;
	}
    public boolean hasCycle(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while(moveForward(ptr1,1) && moveForward(ptr2,2)){
        	ptr1=ptr1.next;
        	ptr2=ptr2.next.next;//上面moveForward是传值，没有将ptr真的后移
        	if(ptr1==ptr2)
        		return true;
        }
        return false;
    }
    public static void main(String [] args){
    	ListNode p1 = new ListNode(1);
    	ListNode p2 = new ListNode(2);
    	ListNode p3 = new ListNode(3);
    	ListNode p4 = new ListNode(4);
    	p1.next=p2;
    	p2.next=p3;
    	p3.next=p1;
    	Solution test = new Solution();
    	System.out.println(test.hasCycle(p3));
    }
}