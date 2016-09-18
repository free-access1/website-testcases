package Examples;

// Researching of controlled values for random number generator - old project on SmartyAds

public class Analysis
{
    //double budget;
    //double cpc;
    GenerateData data;

    Analysis (GenerateData data, double budget, double cpc)
    {
        this.data = data;
        //this.budget = budget;
        //this.cpc = cpc;
    }


    public double getMaxBid()
    {
        double maxBid = 0;

        for (int index = 0; index < this.data.bid.length; index++) {
            if (this.data.bid[index] > maxBid) maxBid = this.data.bid[index];
        }

        return maxBid;
    }


    public double[][] getPwin()
    {
        double maxBid = this.getMaxBid();

        double[][] pWin = new double[(int) maxBid * 100 + 1][2];

        for (int index_bid = 0; index_bid < pWin.length; index_bid++)
        {
            double bid = (double) index_bid/100;
            int count0 = 0;
            int count1 = 0;

            for (int index = 0; index < data.bid.length; index++)
            {
                if (data.bid[index] == bid)
                {
                    if (data.win[index] == 0) count0++;
                    else count1++;
                }
            }

            pWin[index_bid][0] = bid;

            if (count0 + count1 == 0) pWin[index_bid][1] = 0;
            else pWin[index_bid][1] = (double) (10000 * count1/(count0 + count1)) / 10000;
        }

        return pWin;
    }


    public double[][] getExpectedSecondPrice()
    {
        double maxBid = this.getMaxBid();

        double[][] expectedSecondPrice = new double[(int) maxBid * 100 + 1][3];

        for (int index = 0; index  < expectedSecondPrice.length; index++)
        {
            double bid = (double) index / 100;

            expectedSecondPrice[index][0] = bid;
        }

        for (int index = 0; index < expectedSecondPrice.length; index++)
        {
            int countSecondPrices = 0;
            double secondPriceValue = 0;

            for (int index_win = 0; index_win < data.win.length; index_win++)
            {
                if ((data.bid[index_win] == expectedSecondPrice[index][0]) && (data.win[index_win] == 1) && (countSecondPrices == 0))
                    secondPriceValue = data.secondPrice[index_win];

                else if ((data.bid[index_win] == expectedSecondPrice[index][0]) && (data.win[index_win] == 1) && (countSecondPrices != 0))
                    countSecondPrices++;
            }

            expectedSecondPrice[index][1] = secondPriceValue;
            expectedSecondPrice[index][2] = (double) countSecondPrices;
        }

        return expectedSecondPrice;
    }/**/

    public static void main (String[] args)
    {
        GenerateData data = new GenerateData(10000, 0.1, 0.75, 1, 0.0033);

        Analysis camp = new Analysis(data, 100, 0.05);
        double[][] pWin = camp.getPwin();
        double[][] esp = camp.getExpectedSecondPrice();

        for (int index = 0; index < esp.length; index++)
        {
            System.out.println(esp[index][0]+" - "+esp[index][1]+" - "+esp[index][2]);
        }
    }
}

