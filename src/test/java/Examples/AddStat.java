package Examples;

// filling DB

import com.bizzclick.website.ui.DataBase;

public class AddStat {

    public void insertAdStat(int days) {
        DataBase db = new DataBase();
        db.insertAdStat(days);
    }

    public void insertCrossPromoStat(int days) {
        DataBase db = new DataBase();
        db.insertCrossPromoStat(days);
    }


    public static void main (String[] args) {
        AddStat a = new AddStat();
        a.insertCrossPromoStat(142);
    }
}