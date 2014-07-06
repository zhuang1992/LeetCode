//ά��һ�����ݽṹʹ�÷��ʲ����Ͳ���ɾ����������O(1)���Ӷȡ�
//��һ��hash�����һ��˫��������ʵ�֡�
//�����hashmap����key���������е��±꣬���ǻᳬʱ����Ϊͨ���±���������е�Ԫ��Ч�ʵ�
//��Ҫ�Լ�д��������hashmap����key���Ӧ�ڵ�ĵ�ַ����<key,LinkNode>

//ֵ��ע���һ���ǣ������һ���������setʱcache��û�ж�Ӧ���cache��������ʱ��Ҫɾ��β�ڵ㣬����ͷ����һ�½ڵ㡣
//��map�б�������remove���ɵļ�¼�������µļ�¼��
package workbench;

import java.util.HashMap;
public class LRUCache {
	public class LinkNode{
		public int value;
		public int key;
		LinkNode pre;
		LinkNode nxt;
		LinkNode(){
			key=-1;
			value=-1;
			pre=null;
			nxt=null;
		}
	}
    HashMap<Integer,LinkNode>map;
    LinkNode head;
    LinkNode tail;
    int cnt;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer,LinkNode>(); 
        cnt=0;
    }
    public int get(int key) {
        if(map.containsKey(key)){
        	LinkNode temp = map.get(key);
        	if(temp==head){
        		return temp.value;
        	}
        	if(temp==tail){
        		tail = tail.pre;
        	}else{
        		temp.nxt.pre = temp.pre;
        	}
        	temp.pre.nxt=temp.nxt;
        	temp.nxt = head;
        	temp.pre=null;
        	head.pre=temp;
        	head=temp;
        	return head.value;
        }else
        	return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
        	LinkNode temp = map.get(key);
        	if(temp==head){
        		temp.value = value;
        		return ;
        	}
        	if(temp==tail){
        		tail = tail.pre;
        	}else{
        		temp.nxt.pre = temp.pre;
        	}
        	temp.pre.nxt=temp.nxt;
        	temp.nxt = head;
        	temp.pre=null;
        	temp.value=value;
        	head.pre=temp;
        	head=temp;
        }else{
        	if(cnt<capacity){
        		LinkNode newNode = new LinkNode();
        		newNode.key=key;
        		newNode.value=value;
        		if(cnt==0){
            		map.put(key, newNode);
        			head=newNode;
        			tail=newNode;
        			cnt++;
        			return;
        		}
        		newNode.nxt=head;
        		newNode.pre=null;
        		map.put(key, newNode);
        		head.pre=newNode;
        		head=newNode;
        		cnt++;
        	}else{
        		LinkNode temp = map.get(tail.key);
        		map.remove(tail.key);
        		temp.key=key;
        		temp.value=value;
        		if(cnt==1){
        			map.put(key, temp);
        			return;
        		}
        		tail = tail.pre;
        		temp.pre.nxt=null;
        		temp.nxt=head;
        		temp.pre=null;
        		map.put(key, temp);
        		head.pre=temp;
        		head=temp;
        	}
        }
        
    }
    public static void main(String[] args){
    	LRUCache test = new LRUCache(2);
    	while(true){
    		test.set(2,1);
    		test.set(2,2);
    		System.out.println(test.get(2));
    		test.set(1,1);
    		test.set(4,1);
    		System.out.println(test.get(2));
    		while(true);
    	}
    }
}