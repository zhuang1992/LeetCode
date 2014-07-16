//�������ʹ�ö���ռ�Ļ���������hash���һ���Ѿ����ʹ��Ľڵ�
//�������ʹ�ö���ռ䣬��ֻ��ʹ�ÿ���ָ�뷨��
//�������ڵ�ʱ��������һ�����ʣ�����ͷ��㵽�뻷��Ϳ���ָ����ײ�㵽�뻷��ľ��루׷�����룩��ȡ�
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