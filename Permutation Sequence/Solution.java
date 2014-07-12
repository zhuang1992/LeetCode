//如果从头开始挨个产生直到第K个，则很可能会超时。
//可以稍加计算，从最高位开始判断，直接生成第k个。
/*例：n=3, k=3
 *  对于每个确定的最高位，有2!=2个数
 *  ceil(3/2)=2，即可确定最高位应为2
 *  
 *  以此类推
 *  
 *  注意已经使用过的数就不能再用了,用used[]标记
 */
package workbench;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
public class Solution {
    int factorial(int n){
    	if(n==1)
    		return 1;
    	return n*factorial(n-1);
    }
    boolean used[] = new boolean[10];
    int getnum(int index, int n){
    	for(int i = 1; i <= n; i++){
    		if(used[i]==false){
    			index--;
    			if(index==0){
    				used[i] = true;
    				return i;
    			}
    		}
    	}
    	return -1;
    }
	public String getPermutation(int n, int k) {
		StringBuffer res = new StringBuffer();
		for(int i = n - 1; i > 0; i--){
			int t = (int) Math.ceil((double)k/(double)factorial(i));
			res.append(String.valueOf(getnum(t,n)));
			k= k - (t-1)*factorial(i);
		}
		res.append(getnum(1,n));
		return res.toString();
    }
	public static void main(String[] args){
		Solution test = new Solution();
		System.out.print(test.getPermutation(9, 2));
	}
}