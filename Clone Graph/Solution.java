package workbench;
import java.util.Scanner;
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode ptr = head;
        int cnt = 1;
        while(ptr.next!=null){
            ptr = ptr.next;
            cnt++;
        }
        n = n%cnt; //×¢ÒâÕâÀï
        if(n==0)
        	return head; 
        ListNode tail = ptr;
        cnt-=n;
        cnt--;
        ptr = head;
        while(cnt-- >0){
            ptr = ptr.next;
        }
        ListNode newHead = ptr.next;
        ptr.next = null;
        tail.next = head;
        return newHead;
    }
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	int n = 5;
    	ListNode head = new ListNode(1);
    	ListNode r = head;
    	while(n-- > 0){
    		int t = in.nextInt();
    		r.next = new ListNode(t);
    		r = r.next;
    	}
    	Solution test = new Solution();
    	head = test.rotateRight(head, 6);
    	while(head != null){
    		System.out.println(head.val);
    		head = head.next;
    	}
    	in.close();
    }
}