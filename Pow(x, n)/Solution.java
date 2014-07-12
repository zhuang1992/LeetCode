//注意各种特殊情况，能早终止的一定要早终止，不然会超时。但要注意终止判断的精度。ebs太小会超时，太大会WA
package workbench;

public class Solution {
	double ebs = 0.0000000000001;
    public double pow(double x, int n) {
    	if(Math.abs(x+1.0) < ebs){     // x=-1, n=INF的情况。。给跪
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