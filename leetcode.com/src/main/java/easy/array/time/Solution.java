package easy.array.time;

public class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0, max = 0, min = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            min = prices[i];
            if (prices[i] < prices[i + 1]) {
                max = prices[i + 1] - min;
                profit += max;
            }
        }
        return profit;
    }
}
