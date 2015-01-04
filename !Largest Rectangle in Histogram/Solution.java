//这题很重要！腾讯笔试考过。注意要O(n)时间
public class Solution {
    int largestRectangleArea(int []h) {
        if(h.length==0)return 0;
        //if(height.size()==1 && height[0]==0)return 0;
        int height[] = new int[h.length+1];
        height[height.length-1] = 0;
        System.arraycopy(h, 0, height, 0, h.length);
        Stack<Integer>diagram = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i < height.length; i++) {
            if(!diagram.empty()) {
                if(height[i]>=height[diagram.peek()]) {
                    diagram.push(i);
                } else {
                    while((!diagram.empty()) && (height[i]<height[diagram.peek()])) {
                        int topI = diagram.peek();
                        diagram.pop();
                        int width = diagram.empty()? i : (i-diagram.peek()-1);
                        int tArea = height[topI]*width;
                        maxArea = Math.max(maxArea,tArea);
                    }
                    diagram.push(i);
                }
            } else {
                diagram.push(i);
            }
        }

        return maxArea;
    }
}