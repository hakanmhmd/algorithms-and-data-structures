package Arrays;

import java.util.ArrayList;

/**
 * Given an array, find the max profit that you can make by buying and selling in those days
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can
 * earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6.
 * If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 */
public class StockBuySell {
    public static void main(String args[])
    {
        StockBuySell stock = new StockBuySell();

        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;

        stock.stockBuySell(price, n);
    }

    private void stockBuySell(int[] price, int n) {
        if(n==1) return;

        int count = 0;

        ArrayList<BuySell> buySellDays = new ArrayList<>();

        int i=0;
        while(i<n-1){
            // find local minima
            while(i<n-1 && price[i] >= price[i+1]){
                i++;
            }
            if(i == n-1) break;
            BuySell buySell = new BuySell();
            buySell.buy = i;
            i++;

            // find the local maxima
            while(i<n && price[i] >= price[i-1]){
                i++;
            }
            buySell.sell = i-1;
            buySellDays.add(buySell);
            count++;
        }

        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + buySellDays.get(j).buy
                        +"        " + "Sell on day : " + buySellDays.get(j).sell);

        return;
    }

    private class BuySell {
        int buy;
        int sell;
    }
}
