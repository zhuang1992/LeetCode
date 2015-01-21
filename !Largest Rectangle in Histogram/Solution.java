//这题很重要！腾讯笔试考过。注意要O(n)时间
public class Solution {
    int largestRectangleArea(int []h) {
        if(h.length==0)return 0;
        int height[] = new int[h.length+1];
        height[height.length-1] = 0;
        System.arraycopy(h, 0, height, 0, h.length);
        Stack<Integer>diagram = new Stack<Integer>();//存的是下标
        int maxArea = 0;
        for(int i = 0; i < height.length; i++) {
            if(!diagram.empty()) {
                if(height[i]>=height[diagram.peek()]) {
                    diagram.push(i);   //保证栈中存储的下标所代表的矩形是递增的
                } else {
                    while((!diagram.empty()) && (height[i]<height[diagram.peek()])) {  //如果遇到了比栈顶矩形矮的，弹栈，直到当前矩形比栈顶高
                        int topI = diagram.peek();
                        diagram.pop();
                        int width = diagram.empty()? i : (i-diagram.peek()-1);
                        int tArea = height[topI]*width;            //注意这里计算的是被弹出栈的那个最高矩形，向左最远可以覆盖到的面积。
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