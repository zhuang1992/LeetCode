//如果可以使用额外空间的话，可以用hash表存一下已经访问过的节点
//但如果不使用额外空间，就只能使用快慢指针法了
//当环存在的时候，链表有一个性质，就是头结点到入环点和快慢指针碰撞点到入环点的距离（追及距离）相等。
package workbench;

import java.util.*;
public class Solution {
    public ListNode detectCycle(ListNode head) {
    	if(head==null)
    		return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && slow!=null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast==null)
        	    return null;
        	if(fast == slow)
        		break;
        }
        if(fast.next == null || slow==null)
        	return null;
        while(head!=slow){
        	head = head.next;
        	slow = slow.next;
        }
        return head;
    }
}