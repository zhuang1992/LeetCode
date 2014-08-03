//���������
//Ҳ�����׿��Կ����ݹ�ṹ���´��õݹ�дд��
package workbench;

public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length;
        boolean isOver = false;
        int first=-1;
        for(int i = len-2; i>=0; i--){
        	if(num[i]<num[i+1]){
        		int t =len-1;
        		while(num[i]>=num[t]){
        			t--;
        		}
        		int temp = num[t];
        		num[t] = num[i];
        		num[i] = temp;
        		isOver = true;
        		first = i;
        		break;
        	}
        }
        int low; int high;
        if(isOver){
            low = first+1;
            high = len-1;        	
        }else{
        	low = 0; 							//low��ʼ����-1��isOver�Ϳ���ʡȥ��
        	high = len-1;
        }
        while(low<high){
    		int temp = num[high];
    		num[high] = num[low];
    		num[low] = temp;
    		high--;low++;
    	}
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int num[]={5,1,1};
    	test.nextPermutation(num);
    	for(int i = 0; i < num.length; i++)
    		System.out.println(num[i]);
    }
}