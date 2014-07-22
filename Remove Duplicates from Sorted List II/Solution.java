//先删头部的重复元素，直到遇到一个不被删的
//再删中间的重复元素

package workbench;
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode delHead = head;
        ListNode delTail = head;
        
        while(true){
        	while(delTail.val==delHead.val){
                delTail = delTail.next;
                if(delTail==null)
                    break;
            }
        	if(delTail==null){
        		if(delHead.next==delTail){
        			head=delHead;
        		}else
        			head = null;
        		break;
        	}
            if(delHead.next==delTail){
            	head = delHead;
                break;
            }else{
            	delHead = delTail;
            }            
        }
        if(head==null || head.next==null)
            return head;
            /*到这里，头部的重复元素已删完。eg: 1->1->2->2->3->4->4->5，已被删成3->4->4->5*/
        delHead = head;
        delTail = head.next;
        while(true){
        	while(delTail.val == delHead.next.val){
                delTail = delTail.next;
                if(delTail==null)
                    break;
            }
        	 if(delTail==null){
        		 if(delHead.next.next == delTail)
        			 ;
        		 else
        			 delHead.next = null;
        		 break;
        	 }             	
            if(delHead.next.next == delTail){
            	delHead = delHead.next;
            }else{
            	delHead.next = delTail;
            }
        }        
        return head;
    }
    public static void main(String[] args){
    	Solution test  = new Solution();
    	ListNode t = new ListNode(1);
    	t.next = new ListNode(2);
    	t.next.next = new ListNode(3);
  //  	t.next.next.next = new ListNode(2);
  //  	t.next.next.next.next = new ListNode(6);
//    	t.next.next.next.next.next = new ListNode(7);
    	ListNode r = test.deleteDuplicates(t);
    	while(r!=null){
    		System.out.println(r.val);
    		r = r.next;
    	}
    }
}