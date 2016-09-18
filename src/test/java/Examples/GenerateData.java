package Examples;

// Old data-generator from my researching in SmartyAds 

public class DataGenerator {

    double[] bidFloor;
    double[] secondPrice;
    double[] bid;
    byte[] win;
    byte[] click;
    double[][] pWin;
    double[][] expectedSecondPrice;


    public double[] generateBidFloor(int iterations, double maxBidFloorValue)
    {
        double[] bidFloorVector = new double[iterations];

        for (int index = 0; index < iterations; index++)
        {
            bidFloorVector[index] = (double) (Math.round(100 * Math.random() * maxBidFloorValue)) / 100;
        }

        return bidFloorVector;
    }


    public double[] generateSecondPrice(double[] bidFloorVector, double maxSecondPriceValue)
    {
        double[] secondPriceVector = new double[bidFloorVector.length];

        for (int index = 0; index < secondPriceVector.length; index++)
        {
            secondPriceVector[index] = (double) (Math.round(100 * (0.01 + bidFloorVector[index] + Math.random() * (maxSecondPriceValue - 0.01 - bidFloorVector[index])))) / 100;
        }

        return secondPriceVector;
    }


    public double[] generateBid(int iterations, double maxBidValue)
    {
        double[] bidVector = new double[iterations];

        for (int index = 0; index < iterations; index++)
        {
            bidVector[index] = (double) (Math.round(100 * Math.random() * maxBidValue)) / 100;
        }

        return bidVector;
    }


    public byte[] generateWin(double[] bidVector, double[] secondPriceVector)
    {
        byte[] winVector = new byte[bidVector.length];

        for (int index = 0; index < winVector.length; index++)
        {
            if (bidVector[index] > secondPriceVector[index]) winVector[index] = 1;
            else winVector[index] = 0;
        }

        return winVector;
    }


    public byte[] generateClick(byte[] winVector, double ctr)
    {
        byte[] clickVector = new byte[winVector.length];

        for (int index = 0; index < clickVector.length; index++)
        {
            if (winVector[index] == 1)
            {
                int random = (int) Math.round(Math.random() * 1000);

                if (random >= (1000 - 1000 * ctr)) clickVector[index] = 1;
                else clickVector[index] = 0;
            }

            else clickVector[index] = 0;
        }

        return clickVector;
    }

    GenerateData(int iterations, double bidFloorMaxValue, double secondPriceMaxValue, double bidMaxValue, double ctr)
    {
        this.bidFloor = this.generateBidFloor(iterations, bidFloorMaxValue);
        this.secondPrice = this.generateSecondPrice(this.bidFloor, secondPriceMaxValue);
        this.bid = this.generateBid(iterations, bidMaxValue);
        this.win = this.generateWin(this.bid, this.secondPrice);
        this.click = this.generateClick(this.win, ctr);
        this.pWin = this.getPwin();
        this.expectedSecondPrice = this.getExpectedSecondPrice();
    }


    public double getMaxBid()
    {
        double maxBid = 0;

        for (int index = 0; index < this.bid.length; index++)
        {
            if (this.bid[index] > maxBid) maxBid = this.bid[index];
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

            for (int index = 0; index < this.bid.length; index++)
            {
                if (this.bid[index] == bid)
                {
                    if (this.win[index] == 0) count0++;
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

            for (int index_win = 0; index_win < this.win.length; index_win++)
            {
                if ((this.bid[index_win] == expectedSecondPrice[index][0]) && (this.win[index_win] == 1) && (countSecondPrices == 0))
                    secondPriceValue = this.secondPrice[index_win];

                else if ((this.bid[index_win] == expectedSecondPrice[index][0]) && (this.win[index_win] == 1) && (countSecondPrices != 0))
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
