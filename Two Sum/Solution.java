//手写Hash开散列表
//WA很多次，全都是细节错误啊
//最后终于A了
package workbench;
public class Solution {
	public class node{
		int value;
		int pos;
		node next;		
		node(){
			value = -1;
			pos = -1;
			next = null;
		}
	}
	node headList[] = new node[10003];
    void hashInsert(int key, int pos){
    	int tkey = Math.abs(key);
    	if(headList[tkey%10003]==null){
    		headList[tkey%10003] = new node();
    		headList[tkey%10003].pos = pos;
    		headList[tkey%10003].value = key;
    	}else{
    		node ptr = headList[tkey%10003];
    		while(ptr.next!=null){
    			ptr=ptr.next;
    		}
    		ptr.next = new node();
    		ptr.next.value = key;
    		ptr.next.pos = pos;
    	}
    }


	public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
        	hashInsert(numbers[i],i+1);
        }

        int res[] = new int[2];
        for(int i = 0; i < numbers.length; i++){
        	int s = numbers[i];
        	int ts = Math.abs(s)%10003;
        	if(headList[ts]==null){
        		continue;
        	}
        	node ptr = headList[ts];
        	while(ptr!=null){
        		if(ptr.value==s){
        			break;
        		}
        		ptr = ptr.next;
        	}
        	if(ptr==null){
        		continue;
        	}
        	
        	res[0] = ptr.pos;
        	if(s==target-s){
        		ptr=ptr.next;
            	while(ptr!=null){
            		if(ptr.value==s){
            			break;
            		}
            		ptr = ptr.next;
            	}
            	if(ptr!=null){
            		res[1] = ptr.pos;
            		return res;
            	}
            	continue;
        	}
        	int num2=Math.abs(target-s)%10003;
        	if(headList[num2]!=null){
            	node otherPtr = headList[num2];
            	while(otherPtr!=null){
            		if(otherPtr.value==target - s){
            			res[1] = otherPtr.pos;
            			return res;
            		}
            		otherPtr = otherPtr.next;
            	}
            }else{
            	continue;
           	}        	
        }
        res[0]=-1;
        res[1]=-1;;
        return res;
    }
	public static void main(String[] args){
		int numbers[] = {3,2,4};
		Solution test = new Solution();
		int res[] = new int[2];
		res=test.twoSum(numbers, 6);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
