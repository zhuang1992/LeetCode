package workbench;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
class MinStack {
    List<Integer>stack = new ArrayList<Integer>();
    List<Integer>minElem = new ArrayList<Integer>();
    int num = 0;
    public void push(int x) {
        stack.add(num,x);
        if(num==0){
            minElem.add(x);
        }else{
            int minSoFar = minElem.get(minElem.size()-1);
            if(minSoFar >= x){
                minElem.add(x);
            }
        }
        num++;
    }
    public void pop() {
        if(num==0)
            return;
        int n = stack.get(num-1);
        if(n == minElem.get(minElem.size()-1)){
        	minElem.remove(minElem.size()-1);
        }
        stack.remove(num-1);
        num--;
    }
    public int top() {
        if(num==0)
            return -1;
        return stack.get(num-1);
    }
    public int getMin() {
        if(num==0)
            return -1;
        return minElem.get(minElem.size()-1);
    }
}
