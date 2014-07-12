//�����ͷ��ʼ��������ֱ����K������ܿ��ܻᳬʱ��
//�����ԼӼ��㣬�����λ��ʼ�жϣ�ֱ�����ɵ�k����
/*����n=3, k=3
 *  ����ÿ��ȷ�������λ����2!=2����
 *  ceil(3/2)=2������ȷ�����λӦΪ2
 *  
 *  �Դ�����
 *  
 *  ע���Ѿ�ʹ�ù������Ͳ���������,��used[]���
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