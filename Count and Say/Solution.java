//Ϊ�˱���int���磬work�Ĳ����ͷ���ֵ������StringBuffer
//����work����д�ɵݹ飬���34��������������ֵ��Ϊ�������´��뼴�ɡ�
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