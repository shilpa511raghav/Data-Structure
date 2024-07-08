public class BestTimeToBuySellStocks {


    public static int bestTimeToBuySellStocks(int prices[]){
        int minSoFar = prices[0];
        int maxProfit = 0;
        for (int i=1;i<prices.length;i++){
            int profit = prices[i]-minSoFar;
           minSoFar = minSoFar>prices[i] ?prices[i]:minSoFar;
           maxProfit = maxProfit > profit ? maxProfit:profit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
       int maxProfitResult=  bestTimeToBuySellStocks(new int[]{7,1,5,3,6,4});
        System.out.println(maxProfitResult);

    }
}
