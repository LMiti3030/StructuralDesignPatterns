package mititelu.laura;

import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) {
        DBSingleton instance = DBSingleton.getInstance(); //see Singleton created in Creational module

        try{
            Connection conn = instance.getConnection();

            Statement sta = conn.createStatement();
            int count = sta.executeUpdate("CREATE TABLE Address(ID Integer, StreetName VARCHAR(20), City VARCHAR(20))");

            System.out.println("Table created");
            sta.close();

            sta = conn.createStatement();
            count = sta.executeUpdate("INSERT INTO Address(ID, StreetName, City) VALUES(1, '1234 Some Street', 'Layton')");
            System.out.println(count + " record(s) created.");
            sta.close();

            sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Address");

            while(rs.next()){
                System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
