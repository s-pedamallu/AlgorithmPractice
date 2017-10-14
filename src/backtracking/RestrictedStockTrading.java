package backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Question Link:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * @author spedamallu
 *
 */
public class RestrictedStockTrading {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        return maxProfit(prices, -1, new PriorityQueue<Integer>(), 0);
    }

    private int maxProfit(int[] prices, int buyPrice, PriorityQueue<Integer> profitSoFar, int n) {
        if(n==prices.length) {
            int profit = 0;
            Iterator<Integer> itr = profitSoFar.iterator();
            List<Integer> debug = new ArrayList<>();
            while(itr.hasNext()) {
            	int np = itr.next();
                profit += np;
                debug.add(np);
            }
            System.out.println("Final profit: "+profit+" Contributors: "+debug);
            return profit;
        }
        if(buyPrice == -1) {
            return maxProfit(prices, prices[n], profitSoFar, n+1);
        } else if(buyPrice > prices[n]) {
            return maxProfit(prices, prices[n], profitSoFar, n+1);
        } else {
            int profit = prices[n] - buyPrice;
            PriorityQueue<Integer> pq = new PriorityQueue<>(profitSoFar);
            if(profitSoFar.size()>1 && profitSoFar.peek()<profit) {
                int p =profitSoFar.remove();
                System.out.println("Removed profit: "+p);
            }
            if(profitSoFar.size()<2) {
            	profitSoFar.add(profit);
            }
            System.out.println("Buy Price: "+buyPrice+" Sell Price: "+prices[n]+" Adding profit: "+profit);
            return Math.max(maxProfit(prices, -1, profitSoFar, n+1),
                            maxProfit(prices, buyPrice, pq, n+1));
        }
    }
}
