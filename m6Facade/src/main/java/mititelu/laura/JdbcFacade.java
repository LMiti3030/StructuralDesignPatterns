package mititelu.laura;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcFacade {

    DBSingleton instance;

    public JdbcFacade(){
        instance = DBSingleton.getInstance();
    }

    public int createTable(){
        int count = 0;
        try(Connection conn = instance.getConnection();
            Statement sta = conn.createStatement()){
            count = sta.executeUpdate("CREATE TABLE Address(ID Integer, StreetName VARCHAR(20), City VARCHAR(20))");
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public int insertIntoTable(){
        int count = 0;

        try{
            Connection conn = instance.getConnection();
            Statement sta = conn.createStatement();
            count = sta.executeUpdate("INSERT INTO Address(ID, StreetName, City) VALUES(1, '1234 Some Street', 'Layton')");
            sta.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

//        try(Connection conn = instance.getConnection();
//            Statement sta = conn.createStatement()){
//            count = sta.executeUpdate("INSERT INTO Address(ID, StreetName, City) VALUES(1, '1234 Some Street', 'Layton')");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return count;
    }

    public List<Address> getAddresses(){
        List<Address> addresses = new ArrayList<>();

        try{
            Connection conn = instance.getConnection();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Address");

            while(rs.next()){
                //System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
                Address address = new Address();
                address.setId(rs.getString(1));
                address.setStreetName(rs.getString(2) );
                address.setCity(rs.getString(3));
                addresses.add(address);
            }
            sta.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

//        try(Connection conn = instance.getConnection();
//            Statement sta = conn.createStatement();
//            ResultSet rs = sta.executeQuery("SELECT * FROM Address")){
//
//            while(rs.next()){
//                //System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3));
//                Address address = new Address();
//                address.setId(rs.getString(1));
//                address.setStreetName(rs.getString(2) );
//                address.setCity(rs.getString(3));
//                addresses.add(address);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return addresses;
    }
}
