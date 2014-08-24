//�Զ������ֱ������word break��ĺ��������Ӷ�ΪO(m^2)��m��L�������ַ����ĳ��Ⱥ�
//��S��ͷ��β����һ�飬�����ܵĸ��Ӷ���O(n*m^2)��n��S�ĳ���
//��Ȼ��ʱ�ˡ�������Ϊword break�����һ�㣬�ֵ��е�string���ȿ��Բ�ͬ������word break����ţ���ˣ��ѹֳ�ʱ��

//����Ȼֱ���Ͼ��ܹ���ֻ��ע��Ҫ��Hash������ͳ�ơ�����L�и����ʳ���һ�£����Լ��١�
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
   public List<Integer> findSubstring(String S, String[] L) {
	   List<Integer>rst = new LinkedList<Integer>();
	   HashMap<String, Integer> hash = new HashMap<String, Integer>();//L�и����ʳ��ֵĴ���
	   HashMap<String, Integer> cur = new HashMap<String, Integer>();	//��ǰ�����ѳ�����Щ���ʼ�����
	    for(String t : L){
	    	if(hash.containsKey(t)){
	    		hash.put(t, hash.get(t)+1);  //L�п������ظ�����
	    	}else{
	    		hash.put(t, 1);
	    	}	    	
	    }
	    int singLen = L[0].length();
	    int totalLen = L.length * singLen;
	    for(int i = 0; i <= S.length() - totalLen; i++){  //ֱ��ö���Ӵ�����ʼλ�á��汩����
	    	cur.clear();
	    	int j;
	    	for(j = i ; j < i+totalLen; j+=singLen){  //�����ʳ���һ�£�һ����singLen
	    		String temp = S.substring(j, j+singLen);
	    		if(!hash.containsKey(temp))   //����L��û�еĵ��ʣ�ʧ�ܣ�break
	    			break;
	    		if(cur.containsKey(temp)){
	    			if(cur.get(temp) < hash.get(temp)){  
	    				cur.put(temp, cur.get(temp)+1);
	    			}else														//����������L�г��ֵĴ�����ʧ�ܣ�break
	    				break;
	    		}else{
	    			cur.put(temp, 1);
	    		}
	    	}
	    	if(j==i+totalLen){  // j == i+totalLen˵���ɹ��ˣ���¼��
	    		rst.add(i);
	    	}
	    }
	    return rst;
   }
	public static void main(String[] args){
		String L[] = {"a"};
		Solution test = new Solution();
		List<Integer> r = test.findSubstring("a", L);
		for(Integer i : r)
			System.out.println(i);
	}
}