//ֱ�۵��뷨���öѰ�rating�洢�����ҵ�rating��С�ģ��������ھӵĴ�С������rating�ϴ��ġ�
//�������û����TLE�ˣ����ĸ��Ӷ���O(nlogn)��˵����O(n)���㷨��

public class Solution {
    class children implements Comparable<children>{
    	int id;
    	int rating;
    	children(int id, int rating){
    		this.id = id;
    		this.rating = rating;
    	}
    	public int compareTo(children a){
    		if(rating < a.rating){
    			return -1;
    		}else if(rating == a.rating)
    			return 0;
    		else 
    			return 1;
    	}
    }
	public int candy(int[] ratings) {
		if(ratings.length == 1)
			return 1;
        Queue<children>pq = new PriorityQueue<children>();
        for(int i = 0; i < ratings.length; i++){
        	pq.add(new children(i, ratings[i]));
        }
        int [] candies = new int[ratings.length];
        int rst = ratings.length;
        while(!pq.isEmpty()){
        	children h = pq.poll();
        	int i = h.id;
        	if(i==0){
        		while(h.rating > ratings[i+1] && candies[i] < candies[i+1]){
        			candies[i]++;
        			rst++;  
        		}
        	}else if(i==ratings.length-1){
        		while(h.rating > ratings[i-1] && candies[i] < candies[i-1]){
        			candies[i]++;
        			rst++;
        		}
        	}else{
        		while(h.rating > ratings[i+1] && candies[i] <= candies[i+1]){
        			candies[i]++;
        			rst++;
        		}
        		while(h.rating > ratings[i-1] && candies[i] <= candies[i-1]){
        			candies[i]++;
        			rst++;
        		}
        	}
        }
        return rst;
    }
}