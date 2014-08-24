//归并比快排好写多了。。对于链表来说。不过非递归的该怎么写呢？毕竟要求是O(1)的空间。
package workbench;

public class Solution {
	ListNode merge(ListNode h1, ListNode h2){
		ListNode ptr1 = h1;
		ListNode ptr2 = h2;
		ListNode dumbHead = new ListNode(-1);
		ListNode nptr = dumbHead;
		while(ptr1!=null && ptr2!=null){  
			if(ptr1.val < ptr2.val){
				nptr.next = ptr1;
				ptr1 = ptr1.next;
			}else{
				nptr.next = ptr2;
				ptr2 = ptr2.next;					
			}
			nptr = nptr.next;
		}
		if(ptr1 != null){
			nptr.next = ptr1;
		}
		if(ptr2 != null){
			nptr.next = ptr2;
		}
		return dumbHead.next;
	}
	ListNode mergeSort(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode sptr = head;
		ListNode fptr = head;
		ListNode pres = sptr;
		while(fptr!=null && fptr.next!=null){			//居然这里写错两遍，你敢信
			pres = sptr;
			sptr = sptr.next;
			fptr = fptr.next.next;
		}
		ListNode h2 = pres.next;
		h2 = mergeSort(h2);
		pres.next = null;
		ListNode h1 = mergeSort(head);		
		return merge(h1,h2);
	}
    public ListNode sortList(ListNode head) {
    	if(head == null || head.next == null)
    		return head;    	
        return mergeSort(head);        
    }
    public static void main(String[] args){
    	
    	Solution test = new Solution();
    	ListNode r = new ListNode(3);
    	r.next = new ListNode(1);
    	r.next.next = new ListNode(4);
    	r.next.next.next = new ListNode(3);
    	r.next.next.next.next = new ListNode(4);
    	ListNode rst = test.sortList(r);
    	while(rst != null){
    		System.out.println(rst.val);
    		rst = rst.next;
    	}
    }
}