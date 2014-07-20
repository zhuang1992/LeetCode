//高精度乘法
//直接模拟乘法的过程
//注意最后别忘了前导0的去除
package workbench;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
public class Solution {
	StringBuffer add(StringBuffer s1, StringBuffer s2){
		int len1 = s1.length();
		int len2 = s2.length();
		StringBuffer res = new StringBuffer();
		len1--;len2--;
		int c = 0;
		while(len1>=0 || len2>=0){
			int t1,t2;
			if(len1<0){
				t1 = 0;
			}else{
				t1 = s1.charAt(len1)-'0';
			}
			if(len2<0){
				t2 = 0;
			}else{
				t2 = s2.charAt(len2)-'0';
			}
			char temp =(char)((t1+t2+c)%10+'0');
			res.append(temp);
			c = (t1+t2+c)/10;
			len1--;
			len2--;
		}
		
		if(c!=0){
			char temp =(char)(c+'0');
			res.append(temp);
		}
		return res.reverse();
	}
    public String multiply(String num1, String num2) {
        StringBuffer res = new StringBuffer();
        int len1 = num1.length();
        int len2 = num2.length();
        
        for(int i = len1-1; i >=0; i--){
    		int t1 = Integer.valueOf(num1.charAt(i))-'0';
        	int c = 0;
        	StringBuffer tres = new StringBuffer();
        	for(int j = len2-1; j >= 0; j--){
        		int t2 = Integer.valueOf(num2.charAt(j))-'0';
        		char temp =  (char) ((t1*t2+c)%10 + '0');
        		tres.append(temp) ;
        		c = (t1*t2+c)/10;
        	}
        	char temp =  (char) ((c) + '0');
        	tres.append(temp);
        	tres = tres.reverse();
        	
        	for(int z = 0; z < len1-1-i; z++){
        		tres.append('0');
        	}
        	res = add(res,tres);
        }
        int zero=0;
    	for(int tr = 0; tr < res.length(); tr++){
    		if(res.charAt(tr)=='0'){
    			zero++;
    		}else
    			break;
    	}
    	if(zero>0)
    		res.delete(0, zero);
    	if(res.length()==0)
    		res.append('0');
        return res.toString();
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	StringBuffer t1 = new StringBuffer("8727000");
    	StringBuffer t2 = new StringBuffer("1963575");
    	System.out.print(test.multiply("223435","0"));
    }
}