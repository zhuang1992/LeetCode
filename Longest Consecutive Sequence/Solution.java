//������뷨��û��ģ�Ҫʵ��O(n)��ʱ��͵���Hash
//����һ������ˣ����Ƕ�ÿһ����ֻ�������ˣ���û�����ң���������֮��û�б�ǳ��ѷ��ʹ���
//���������Ļ����Ӷȴ����O(mn)��������һ��Ԫ�ؿ��ܻᱻ���ʶ�Ρ���ʱ�ˡ�
//ʹ�ñ�Ǻ�ÿ��Ԫ��ֻ������һ�Ρ�O(n)��
package workbench;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < num.length; i++){
        	hash.put(num[i], 1);
        }
        int maxCnt = 0;
        for(int i = 0; i < num.length; i++){
        	int st = num[i];
        	if(hash.get(st)==0)
        		continue;
        	hash.put(st, 0);
        	int upcnt = 1;
            int cnt = 1;
        	int downcnt = 1;
        	while(hash.containsKey(st+upcnt) && hash.get(st+upcnt)==1){
        		hash.put(st+upcnt, 0);
        		upcnt++;
        	}
        	while(hash.containsKey(st-downcnt) && hash.get(st-downcnt)==1){
        		hash.put(st-downcnt, 0);
        		downcnt++;
        	}
        	cnt += upcnt - 1 + downcnt - 1;
        	maxCnt = cnt>maxCnt? cnt:maxCnt;
        }
        return maxCnt;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int n[] = {100, 4, 200, 1, 3, 2};
    	System.out.print(test.longestConsecutive(n));
    }
}