package Examples;

import com.bizzclick.website.ui.DataBase;

// SandBox on Local DB

public class InsertPublisherExample extends DataBase {

    public static void main (String[] args) {

        DataBase db = new DataBase();

        String[] tables = {DB_PUBLISHERS_TABLE_NAME_VALUE, DB_APPLICATIONS_TABLE_NAME_VALUE, DB_AD_SPACES_TABLE_NAME_VALUE};
        db.truncateTables(tables);

        int applicationID = db.insertPubApp(
                "TRUE", "2016-07-19 16:52:52", "name", "company", "mail1@mail.mail", PASSWORD_VALUE_VALID_FOR_DB, "192.168.0.1", "2016-07-19 16:53:48", " ", "0000-00-00 00:00:00",
                "Yahoho", "com.madnes.yahoho", "", "IAB1-1 Books & Literature", "android", "0", "false", "Zyabliki", "100", "false", "ZoomBaBee1", "initial");
        System.out.println(applicationID);

        db.truncateTables(tables);

        int adSpaceID = db.insertPubAppAdSpace (
                "TRUE", "2016-07-19 16:52:52", "name", "company", "mail2@mail.mail", PASSWORD_VALUE_VALID_FOR_DB, "192.168.0.1", "2016-07-19 16:53:48", " ", "0000-00-00 00:00:00",
                "Yahoho", "com.madnes.yahoho", "", "IAB1-1 Books & Literature", "android", "0", "false", "Zyabliki", "100", "false", "ZoomBaBee2", "initial",
                "Main Mobile Ad", "banner", "250", "250", "300000", "15", "inapp");
        System.out.println(adSpaceID);

        db.truncateTables(tables);
    }
}

