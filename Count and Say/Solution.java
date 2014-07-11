//为了避免int超界，work的参数和返回值均采用StringBuffer
//还有work不必写成递归，像第34行那样，将返回值作为参数重新传入即可。
package workbench;
public class Solution {
	StringBuffer work(StringBuffer t){
		StringBuffer res = new StringBuffer();
        char pre = 'x';
        boolean init = true;
        int cnt = 0;
        for(int i = 0; i < t.length(); i++){
        	if(init){
        		pre = t.charAt(i);
        		init = false;
        		cnt ++;
        	}else{
        		if(t.charAt(i)!=pre){
        			res.append(String.valueOf(cnt)+pre);
        			cnt = 1;
        			pre = t.charAt(i);
        		}else{
        			cnt++;
        		}
        	}
        	if(i == t.length()-1){
        		res.append(String.valueOf(cnt)+pre);
        	}
        }
        return res;
	}
    public String countAndSay(int n) {
    	n--;
    	StringBuffer t = new StringBuffer("1");
    	while(n-- > 0){
    		t = work(t);
    	}
    	return t.toString();
    }
    public static void main(String[] args){
    	Solution test  = new Solution();
    	int n = 	9;
    	System.out.println(test.countAndSay(n));
    }
}