package Examples;

// Generating of Ads Statistics for DB-table

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GenerateAdStat {

    public int days;
    public int[] impressions;
    public int[] clicks;
    public double[] revenue;
    public String[] dates;

    public GenerateAdStat(int days) {

        this.days = days;
        this.impressions = generateImpressions();
        this.clicks = generateClicks();
        this.revenue = generateRevenue();
        this.dates = generateDates();
    }

    public int[] generateImpressions() {

        double index;
        double[] cleanFunc = new double[days * 24];
        int[] impressions = new int[days * 24];

        for (int day = -1 * days; day < 0; day++) {
            for (int hour = 0; hour < 24; hour++) {
                index = 0.24 * (days + day) + hour / 100.0;
                cleanFunc[24 * (days + day) + hour] = 0.001 * (Math.sin(index) + 0.2 * Math.sin(15 * index)) + 0.002;
                impressions[24 * (days + day) + hour] = (int) (1000000 * (0.8 + Math.random() * 0.4) * cleanFunc[24 * (days + day) + hour]);
            }
        }
        return impressions;
    }

    public int[] generateClicks() {

        double standardDeviation;
        double mean = 15.0;
        double x;
        double[] normalDistribution = new double[impressions.length];
        int[] clicks = new int[impressions.length];

        for (int day = -1 * days; day < 0; day++) {
            for (int hour = 0; hour < 24; hour++) {
                standardDeviation = -1 * day % 7 + 0.5;
                if (hour < 3) x = 24 + hour;
                else x = hour;
                normalDistribution[24 * (days + day) + hour] = Math.exp(-Math.pow(x - mean, 2) / (2 * Math.pow(standardDeviation, 2))) / (standardDeviation * Math.pow(2 * Math.PI, 0.5));
            }
        }

        for (int index = 0; index < impressions.length; index++) {
            clicks[index] = (int) Math.round(impressions[index] * normalDistribution[index] / 20);
        }
        return clicks;
    }

    public double[] generateRevenue() {

        double[] revenue = new double[impressions.length];

        for (int index = 0; index < impressions.length; index++) {
            revenue[index] = (double) impressions[index] * 0.02;
        }
        return revenue;
    }

    public String[] generateDates() {

        String[] dates = new String[impressions.length];

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = Calendar.getInstance().getTime();
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(date);

        currentDate.add(Calendar.DATE, -days - 1);
        for (int day = 0; day < days; day++) {
            currentDate.add(Calendar.DATE, 1);
            for (int hour = 0; hour < 24; hour++) {
                currentDate.set(Calendar.HOUR_OF_DAY, hour);
                currentDate.set(Calendar.MINUTE, 0);
                currentDate.set(Calendar.SECOND, 0);
                dates[24 * day + hour] = ft.format(currentDate.getTime());
            }
        }
        return dates;
    }
}