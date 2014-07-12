//ע��������������������ֹ��һ��Ҫ����ֹ����Ȼ�ᳬʱ����Ҫע����ֹ�жϵľ��ȡ�ebs̫С�ᳬʱ��̫���WA
package workbench;

public class Solution {
	double ebs = 0.0000000000001;
    public double pow(double x, int n) {
    	if(Math.abs(x+1.0) < ebs){     // x=-1, n=INF�������������
    		if(n%2==0)
    			return 1.0;
    		return -1.0;
    	}
    	if(n<0){
    		x = 1.0/x;
    		n = -1 * n;
    	}
    	double ix = x;
    	double res = 1;
    	
        while(n-- >0){
        	double temp = res;
        	res*=ix;
        	if(Math.abs(res-0)<ebs){
        		break;
        	}
        	if(Math.abs(res-temp)<ebs){
        		break;
        	}
        }
        return res;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.print(test.pow(0.99999, 948688));
    }
}