package com.bizzclick.website.ui;

import Examples.GenerateAdStat;

import java.sql.*;


public class DataBase implements Constants {
    private static Connection myConn;
    private static Statement myStm;

    public DataBase() {}

   /* Deleting record about user from table PUBLISHERS by unique field 'email'
    *
    * @param String email   mailbox account to delete
    * @return void          it does not affect the webDriver operation
    * */
    public void deletePublisherByEmail(String email) {
        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            executeDeletePublisherByEmailStatement(myConn, email);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    public void executeDeletePublisherByEmailStatement (Connection connection, String email) throws SQLException {

        myStm = connection.createStatement();
        ResultSet myRes = myStm.executeQuery("SELECT `email` FROM `PUBLISHERS`");

        while (myRes.next()) {
            String emailValue = myRes.getString("email");
            if (emailValue.equals(email)){
                PreparedStatement deleteStmt = myConn.prepareStatement("DELETE FROM `PUBLISHERS` WHERE `email`=?");
                deleteStmt.setString(1, email);
                deleteStmt.executeUpdate();
                deleteStmt.close();
                break;
            }
        }
    }

    public void truncateTable (String tableName) {
        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);
            executeTruncateTableStatement(myConn, tableName);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    public void executeTruncateTableStatement(Connection connection, String tableName) throws SQLException {

        String query = "TRUNCATE TABLE `" + tableName + "`";
        myStm = connection.createStatement();
        myStm.executeUpdate(query);
    }

    public void truncateTables (String[] tableNames) {

        if (tableNames.length <= 0) System.out.println("Your array of tables is empty");
        else {
            try {
                myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);
                executeTruncateArrayOfTablesStatement(myConn, tableNames);

            } catch(Exception exc) {
                exc.printStackTrace();
            } finally {
                try {
                    myConn.close();
                } catch (SQLException se) { /*can't do anything */ }
            }
        }
    }

    public void executeTruncateArrayOfTablesStatement(Connection connection, String[] tableNames) throws SQLException {

        myStm = connection.createStatement();

        for (String tableName : tableNames) {
            String query = "TRUNCATE TABLE `" + tableName + "`";
            myStm.executeUpdate(query);
        }
    }

    public int insertPublisher(String active, String regDate, String name, String company, String email, String password, String lastLoginIP, String lastLoginDateTime, String token, String tokenExpires) {

        int publisherID = 0;

        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            publisherID = executeInsertPublisherStatement(myConn, active, regDate, name, company, email, password, lastLoginIP, lastLoginDateTime, token, tokenExpires);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return publisherID;
    }

    public int executeInsertPublisherStatement(Connection connection, String active, String regDate, String name, String company, String email, String password, String lastLoginIP, String lastLoginDateTime, String token, String tokenExpires) throws SQLException {

        int publisherID = 0;
        String query = "INSERT INTO `PUBLISHERS` (`active`, `reg_date`, `name`, `company`, `email`, `password`, `last_login_ip`, `last_login_datetime`, `token`, `token_expires`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement insertStmt = connection.prepareStatement(query);
        insertStmt.setString(1, active);
        insertStmt.setString(2, regDate);
        insertStmt.setString(3, name);
        insertStmt.setString(4, company);
        insertStmt.setString(5, email);
        insertStmt.setString(6, password);
        insertStmt.setString(7, lastLoginIP);
        insertStmt.setString(8, lastLoginDateTime);
        insertStmt.setString(9, token);
        insertStmt.setString(10,tokenExpires);
        insertStmt.executeUpdate();
        insertStmt.close();

        PreparedStatement getLastInsertId = connection.prepareStatement("SELECT LAST_INSERT_ID()");
        ResultSet rs = getLastInsertId.executeQuery();
        if (rs.next())
        {
            publisherID = rs.getInt("last_insert_id()");
        }
        else System.out.println("Publisher's insert failed... have a nice day! :)");

        return publisherID;
    }

    public int insertApplication(int owner, String title, String packageName, String storeUrl, String category, String platform, String ageLimit, String paidApplication, String currencyName, String exchangeRate, String realCurrency, String appKey, String status) {

        int applicationID = 0;

        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            applicationID = executeInsertApplicationStatement(myConn, owner, title, packageName, storeUrl, category, platform, ageLimit, paidApplication, currencyName, exchangeRate, realCurrency, appKey, status);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return applicationID;
    }

    public int executeInsertApplicationStatement(Connection connection, int owner, String title, String packageName, String storeUrl, String category, String platform, String ageLimit, String paidApplication, String currencyName, String exchangeRate, String realCurrency, String appKey, String status) throws SQLException {

        int applicationID = 0;
        String query = "INSERT INTO `APPLICATIONS` (`owner`, `title`, `package_name`, `URL`, `categories`, `platform`, `age_limits`, `paid_application`, `currency_name`, `exchange_rate`, `real_currency`, `APP_KEY`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement insertStmt = connection.prepareStatement(query);
        insertStmt.setInt(1, owner);
        insertStmt.setString(2, title);
        insertStmt.setString(3, packageName);
        insertStmt.setString(4, storeUrl);
        insertStmt.setString(5, category);
        insertStmt.setString(6, platform);
        insertStmt.setString(7, ageLimit);
        insertStmt.setString(8, paidApplication);
        insertStmt.setString(9, currencyName);
        insertStmt.setString(10,exchangeRate);
        insertStmt.setString(11,realCurrency);
        insertStmt.setString(12,appKey);
        insertStmt.setString(13,status);
        insertStmt.executeUpdate();
        insertStmt.close();

        PreparedStatement getLastInsertId = connection.prepareStatement("SELECT LAST_INSERT_ID()");
        ResultSet rs = getLastInsertId.executeQuery();
        if (rs.next())
        {
            applicationID = rs.getInt("last_insert_id()");
        }
        else System.out.println("Application's insert failed... have a nice day! :)");

        return applicationID;
    }

    public int insertAdSpace(int ownedApp, String title, String type, String adWidth, String adHeight, String bidFloor, String refreshTime, String clickType) {

        int adSpaceID = 0;

        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

           adSpaceID =  executeInsertAdSpaceStatement(myConn, ownedApp, title, type, adWidth, adHeight, bidFloor, refreshTime, clickType);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return adSpaceID;
    }

    public int executeInsertAdSpaceStatement(Connection connection, int ownedApp, String title, String type, String adWidth, String adHeight, String bidFloor, String refreshTime, String clickType) throws SQLException {

        int adSpaceID = 0;
        String query = "INSERT INTO `ADSPACES` (`owned_app`, `adspace_title`, `type`, `width`, `height`, `CPM`, `refresh_time`, `click_type`, `useOverlay`,  `overlayUrl`,  `UsePassBack`, `PassbackCode`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement insertStmt = connection.prepareStatement(query);
        insertStmt.setInt(1, ownedApp);
        insertStmt.setString(2, title);
        insertStmt.setString(3, type);
        insertStmt.setString(4, adWidth);
        insertStmt.setString(5, adHeight);
        insertStmt.setString(6, bidFloor);
        insertStmt.setString(7, refreshTime);
        insertStmt.setString(8, clickType);
        insertStmt.setString(9, "no");
        insertStmt.setString(10,"");
        insertStmt.setString(11,"false");
        insertStmt.setString(12,"");
        insertStmt.executeUpdate();
        insertStmt.close();

        PreparedStatement getLastInsertId = connection.prepareStatement("SELECT LAST_INSERT_ID()");
        ResultSet rs = getLastInsertId.executeQuery();
        if (rs.next())
        {
            adSpaceID = rs.getInt("last_insert_id()");
        }
        else System.out.println("AdSpace's insert failed... have a nice day! :)");

        return adSpaceID;
    }

    public int insertPubApp(
            String active, String regDate, String name, String company, String email, String password, String lastLoginIP, String lastLoginDateTime, String token, String tokenExpires,
            String appTitle, String packageName, String storeUrl, String category, String platform, String ageLimit, String paidApplication, String currencyName, String exchangeRate, String realCurrency, String appKey, String status)
    {
        int applicationID = 0;

        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            int publisherID = executeInsertPublisherStatement(myConn, active, regDate, name, company, email, password, lastLoginIP, lastLoginDateTime, token, tokenExpires);
            applicationID = executeInsertApplicationStatement(myConn, publisherID, appTitle, packageName, storeUrl, category, platform, ageLimit, paidApplication, currencyName, exchangeRate, realCurrency, appKey, status);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return applicationID;
    }

    public int insertPubAppAdSpace(
            String active, String regDate, String name, String company, String email, String password, String lastLoginIP, String lastLoginDateTime, String token, String tokenExpires,
            String appTitle, String packageName, String storeUrl, String category, String platform, String ageLimit, String paidApplication, String currencyName, String exchangeRate, String realCurrency, String appKey, String status,
            String adSpaceTitle, String type, String adWidth, String adHeight, String bidFloor, String refreshTime, String clickType)
    {
        int adSpaceID = 0;

        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            int publisherID = executeInsertPublisherStatement(myConn, active, regDate, name, company, email, password, lastLoginIP, lastLoginDateTime, token, tokenExpires);
            int applicationID = executeInsertApplicationStatement(myConn, publisherID, appTitle, packageName, storeUrl, category, platform, ageLimit, paidApplication, currencyName, exchangeRate, realCurrency, appKey, status);
            adSpaceID =  executeInsertAdSpaceStatement(myConn, applicationID, adSpaceTitle, type, adWidth, adHeight, bidFloor, refreshTime, clickType);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return adSpaceID;
    }

    public void deletePubTruncateAppAdsStat(String publisherMailbox) {
        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            executeDeletePublisherByEmailStatement(myConn, publisherMailbox);
            executeTruncateArrayOfTablesStatement(myConn, DB_APP_ADS_STAT_TABLES_NAMES);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    public void deletePubTruncateAppAdsStatInsertPub(String publisherName, String publisherCompany, String publisherMailbox) {
        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            executeDeletePublisherByEmailStatement(myConn, publisherMailbox);
            executeTruncateArrayOfTablesStatement(myConn, DB_APP_ADS_STAT_TABLES_NAMES);
            executeInsertPublisherStatement(myConn, "true", "2016-02-02 10:00:00", publisherName, publisherCompany, publisherMailbox, PASSWORD_VALUE_VALID_FOR_DB, "192.168.0.1", "2016-02-02 10:00:00", " ", "0000-00-00 00:00:00");

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    public void deletePubTruncateAppAdsStatInsertPubApp(String publisherName, String publisherCompany, String publisherMailbox,
                                                        String appTitle, String packageName, String storeUrl, String category, String platform, String ageLimit, String paidApplication, String currencyName, String exchangeRate, String realCurrency, String appKey, String status)
    {
        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            executeDeletePublisherByEmailStatement(myConn, publisherMailbox);
            executeTruncateArrayOfTablesStatement(myConn, DB_APP_ADS_STAT_TABLES_NAMES);
            int publisherID = executeInsertPublisherStatement(myConn, "true", "2016-02-02 10:00:00", publisherName, publisherCompany, publisherMailbox, PASSWORD_VALUE_VALID_FOR_DB, "192.168.0.1", "2016-02-02 10:00:00", " ", "0000-00-00 00:00:00");
            executeInsertApplicationStatement(myConn, publisherID, appTitle, packageName, storeUrl, category, platform, ageLimit, paidApplication, currencyName, exchangeRate, realCurrency, appKey, status);

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    public int insertAdStat(int days) {

        GenerateAdStat stat = new GenerateAdStat(days);

        int adSpaceStatID = 0;

        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            for (int index = 0; index < stat.dates.length; index++) {

                adSpaceStatID = executeInsertAdStatStatement(myConn, stat.dates[index], stat.revenue[index], stat.revenue[index], stat.impressions[index], stat.clicks[index], 0);
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return adSpaceStatID;
    }

    public int executeInsertAdStatStatement(Connection connection, String date, double spent, double revenue, int impressions, int clicks, int uniques) throws SQLException {

        int adSpaceStatID = 0;
        String query = "INSERT INTO `ADSPACE_STATS` (`ADSPACE`, `PERIOD`, `SPENT`, `REVENUE`, `IMP_COUNT`, `CLICK_COUNT`, `uniq_users`) VALUES (?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement insertStmt = connection.prepareStatement(query);
        insertStmt.setString(1, String.valueOf(1));
        insertStmt.setString(2, date);
        insertStmt.setString(3, String.valueOf(spent));
        insertStmt.setString(4, String.valueOf(revenue));
        insertStmt.setString(5, String.valueOf(impressions));
        insertStmt.setString(6, String.valueOf(clicks));
        insertStmt.setString(7, String.valueOf(uniques));
        insertStmt.executeUpdate();
        insertStmt.close();

        PreparedStatement getLastInsertId = connection.prepareStatement("SELECT LAST_INSERT_ID()");
        ResultSet rs = getLastInsertId.executeQuery();
        if (rs.next())
        {
            adSpaceStatID = rs.getInt("last_insert_id()");
        }
        else System.out.println("AdSpace's insert failed... have a nice day! :)");

        return adSpaceStatID;
    }

    public int insertCrossPromoStat(int days) {

        GenerateAdStat stat = new GenerateAdStat(days);

        int crossPromoStatID = 0;

        try {
            myConn = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

            for (int index = 0; index < stat.dates.length; index++) {

                crossPromoStatID = executeInsertCrossPromoStatStatement(myConn, 1, stat.dates[index], stat.impressions[index], stat.clicks[index], 0);
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try { myConn.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return crossPromoStatID;
    }

    public int executeInsertCrossPromoStatStatement(Connection connection, int promoID, String date, int impressions, int clicks, int uniques) throws SQLException {

        int adSpaceStatID = 0;
        String query = "INSERT INTO `PROMO_STATS` (`promo_id`, `period`, `imp_count`, `click_count`, `uniq_users`) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement insertStmt = connection.prepareStatement(query);
        insertStmt.setString(1, String.valueOf(promoID));
        insertStmt.setString(2, date);
        insertStmt.setString(3, String.valueOf(impressions));
        insertStmt.setString(4, String.valueOf(clicks));
        insertStmt.setString(5, String.valueOf(uniques));
        insertStmt.executeUpdate();
        insertStmt.close();

        PreparedStatement getLastInsertId = connection.prepareStatement("SELECT LAST_INSERT_ID()");
        ResultSet rs = getLastInsertId.executeQuery();
        if (rs.next())
        {
            adSpaceStatID = rs.getInt("last_insert_id()");
        }
        else System.out.println("AdSpace's insert failed... have a nice day! :)");

        return adSpaceStatID;
    }
}