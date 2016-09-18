package Examples;

// first probe of working with DB

import java.sql.*;

public class WorkWithDBExample {

    public static void main (String[] args) {
        try {
            // get a connection to db
            Connection myConn = DriverManager.getConnection("jdbc:mysql://192.168.88.36:3306/test?serverTimezone=UTC", "root", "zx1234");
//
// Не забыть!!! - Проработать с админом вопрос о TimeZone - Саша (будут ли стучатся в БД разработчики из других офисов или можем оставить как есть - с Валентином)
//
            // create a statement
            Statement myStm = myConn.createStatement();

            // execute a SQL query
            myStm.executeUpdate("DELETE FROM `PUBLISHERS` WHERE `email`='confirmed.account@mail.ru'");
/*
            // process the result set
            while (myRes.next()) {
                System.out.println(myRes.getString("email") + ", " + myRes.getInt("id"));
            }/**/

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
