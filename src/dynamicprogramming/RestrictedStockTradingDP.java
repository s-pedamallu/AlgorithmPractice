package dynamicprogramming;

/**
 * Question Link:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * @author spedamallu
 *
 */
public class RestrictedStockTradingDP {

	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}
		int[] prevRound = new int[prices.length];
		for(int k=1; k<=2; k++) {	// k represents the kth transaction (1 transaction => 1 Buy + 1 Sell)
			int cheapestBuy = prevRound[0] - prices[0]; // Buy the first stock
			for(int i=1; i<prices.length; i++) {
				int prevI = prevRound[i];
				prevRound[i] = Math.max(prevRound[i-1], prices[i]+cheapestBuy); // Best of existing profit or selling the bought stock
				cheapestBuy = Math.max(cheapestBuy, prevI - prices[i]);
			}
			System.out.println("maxProfit of round "+k+" is "+prevRound[prices.length-1]);
		}
		return prevRound[prices.length-1];
	}
}
