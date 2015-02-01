class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int minVal = 0x7fffffff;
        int maxDiff = 0;
        for(int i = 0; i < prices.size();i++){
            minVal = min(minVal,prices[i]);
            maxDiff = max(maxDiff,prices[i] - minVal);
        }
        maxDiff = max(0,maxDiff);
        return maxDiff;
    }
};